package ua.com.javarush.quest.gribanov.questdelta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import ua.com.javarush.quest.gribanov.questdelta.entity.*;
import ua.com.javarush.quest.gribanov.questdelta.repository.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class LoaderService {
    private final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());

    private final String DEFAULT_QUEST_FILE_NAME = "quest.yaml";
    private final String BACKUP_DB_FILE_NAME = "dataBaseBU.yml";
    private final String TEMP_FOLDER_NAME = "tempDB";
    public static final Path TEMP_FOLDER_PATH = Paths.get(FileUtils.getTempDirectory().getAbsolutePath(), TEMP_FOLDER_NAME);

    private UserRepository userRepository;
    private QuestRepository questRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private GameRepository gameRepository;
    private User defaultAdmin;
    private Quest defaultQuest;

    {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void load(){

        userRepository = UserRepository.get();
        questRepository = QuestRepository.get();
        questionRepository = QuestionRepository.get();
        answerRepository = AnswerRepository.get();
        gameRepository = GameRepository.get();

        Path bdYamlBU = TEMP_FOLDER_PATH.resolve(BACKUP_DB_FILE_NAME);
        File bdYamlBUFile = new File(bdYamlBU.toString());
        if (Files.exists(bdYamlBU) && !Files.isDirectory(bdYamlBU) && bdYamlBUFile.length() > 0){
            loadFromBackUp(bdYamlBU);
        } else {
            loadDefaultAdmin(TEMP_FOLDER_PATH);
        }



    }

    private void loadFromBackUp(Path bdYamlBU) {
        List<User> users;
        try (InputStream inputStream = Files.newInputStream(bdYamlBU)){
            MAPPER.findAndRegisterModules();
            users = MAPPER.readerForListOf(User.class).readValue(inputStream);
            users.forEach(userRepository::add);
            users.forEach(LoaderService::fillRepositories);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        MAPPER.findAndRegisterModules();
        List<User> users = userRepository.getAll().stream().collect(Collectors.toList());

        if (users.size() > 0) {
            try (OutputStream outputStream = Files.newOutputStream(TEMP_FOLDER_PATH.resolve(BACKUP_DB_FILE_NAME))) {
                MAPPER.writeValue(outputStream, users);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Quest loadDefaultQuest(Path tempFolderPath, Long authorID){
        Quest restoredQuest;
        try (InputStream inputStream = Files.newInputStream(tempFolderPath.resolve(DEFAULT_QUEST_FILE_NAME))){
            restoredQuest = MAPPER.readValue(inputStream, Quest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Objects.isNull(restoredQuest)) {
            restoredQuest = Quest.builder().build();
            Answer answer1 = Answer.builder()
                    .questionID(1100L)
                    .answerText("4")
                    .nextQuestionID(1200L)
                    .build();
            answer1.setId(1101L);
            Answer answer2 = Answer.builder()
                    .questionID(1100L)
                    .answerText("Не уверен, но кажется 5")
                    .nextQuestionID(1300L)
                    .build();
            answer1.setId(1102L);
            Question question1 = Question.builder()
                    .questID(restoredQuest.getId())
                    .questionText("Возникли ошибки с загрузкой квеста.\nСколько будет 2х2?")
                    .image("")
                    .build();
            question1.setId(1100L);
            question1.setAnswer(answer1);
            question1.setAnswer(answer2);
            Question question2 = Question.builder()
                    .questID(restoredQuest.getId())
                    .questionText("Верно.\nТы отличный математик!")
                    .isALast(true)
                    .isAWin(true)
                    .image("")
                    .build();
            question2.setId(1200L);
            Question question3 = Question.builder()
                    .questID(restoredQuest.getId())
                    .questionText("Не правильно.\nС арифметикой ты не дружишь.")
                    .isALast(true)
                    .isAWin(false)
                    .image("")
                    .build();
            question3.setId(1300L);
            Quest defaultQuest = Quest.builder()
                    .name("Ошибка загрузки из файла")
                    .authorID(authorID)
                    .image("")
                    .question(question1)
                    .question(question2)
                    .question(question3)
                    .build();
            defaultQuest.setId(1000L);
            defaultQuest.setFirstQuestionID(1100L);
        }
        restoredQuest.setAuthorID(authorID);
        return restoredQuest;
    }

    private void loadDefaultAdmin(Path tempFolderPath){
        defaultAdmin = User.builder()
                .name("Administrator")
                .login("admin")
                .password("admin")
                .role(Role.ADMINISTRATOR)
                .avatar("avatar-admin.png")
                .build();
        defaultAdmin.setId(1L);
        userRepository.add(defaultAdmin);

        defaultQuest = loadDefaultQuest(tempFolderPath, defaultAdmin.getId());

        questRepository.add(defaultQuest);
        defaultAdmin.setCreatedQuest(defaultQuest);
        fillRepositories(defaultAdmin);
    }

    private void fillRepositories(User user){
        Collection<Quest> quests = user.getCreatedQuests();
        Collection<Game> games = user.getPlayingGames();
        if (!Objects.isNull(games )){
            games.forEach(gameRepository::add);
        }
        if (!Objects.isNull(quests)) {
            quests.forEach(questRepository::add);
            quests.forEach(q -> {
                q.getQuestions()
                        .forEach(qe -> {
                            questionRepository.add(qe);
                            Collection<Answer> answers = qe.getAnswers();
                            if (answers != null) {
                                answers.forEach(answerRepository::add);
                            }
                        });
            });
        }
    }
}
