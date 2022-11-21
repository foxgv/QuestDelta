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
import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class LoaderService {
    private final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
    private final String DEFAULT_QUESTS_FOLDER_NAME = "quests";
    private final String BACKUP_DB_FILE_NAME = "dataBaseBU.yml";
    private final String TEMP_FOLDER_NAME = "tempDB";
    public static final Path TEMP_FOLDER_PATH = Paths.get(FileUtils.getTempDirectory().getAbsolutePath(), TEMP_FOLDER_NAME);
    private static final Path RESOURCE_FOLDER_PATH = Path.of(FilenameUtils.getPath(
            Objects.requireNonNull(LoaderService.class.getResource("/"))
                    .getPath())
            .replace("%20", " "));

    private UserRepository userRepository;
    private QuestRepository questRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private GameRepository gameRepository;

    static {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void load(){

        userRepository = UserRepository.get();
        questRepository = QuestRepository.get();
        questionRepository = QuestionRepository.get();
        answerRepository = AnswerRepository.get();
        gameRepository = GameRepository.get();

        Path bdYamlBU = TEMP_FOLDER_PATH.resolve(BACKUP_DB_FILE_NAME);
        try {
            if(!Files.exists(TEMP_FOLDER_PATH)){
                Files.createDirectory(TEMP_FOLDER_PATH);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File bdYamlBUFile = new File(bdYamlBU.toString());
        if (Files.exists(bdYamlBU) && !Files.isDirectory(bdYamlBU) && bdYamlBUFile.length() > 0){
            loadFromBackUp(bdYamlBU);
        } else {
            loadDefaultAdmin();
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
        List<User> users = new ArrayList<>(userRepository.getAll());

        if (users.size() > 0) {
            try (OutputStream outputStream = Files.newOutputStream(TEMP_FOLDER_PATH.resolve(BACKUP_DB_FILE_NAME))) {
                MAPPER.writeValue(outputStream, users);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Collection<Quest> loadDefaultQuests(Long authorID){
        Collection<Quest> restoredQuests = new ArrayList<>();
        Path defaultQuestsPath = RESOURCE_FOLDER_PATH.resolve(DEFAULT_QUESTS_FOLDER_NAME);
        QuestService questService = QuestService.get();
        if(Files.exists(defaultQuestsPath)){
            try{
                restoredQuests = Files.list(defaultQuestsPath)
                        .filter(p->!Files.isDirectory(p))
                        .map(p->{
                            try {
                                return Files.newInputStream(p);
                            } catch (IOException e) {
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .map(is->{
                            try {
                                return MAPPER.readValue(is, Quest.class);
                            } catch (IOException e) {
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                restoredQuests.forEach(questService::normalizeQuest);
                for (Quest restoredQuest : restoredQuests) {
                    restoredQuest.setAuthorID(authorID);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (restoredQuests.isEmpty()) {
            Quest defaultQuest;
            defaultQuest = Quest.builder()
                    .name("Ошибка загрузки из файла")
                    .description("Простой квест")
                    .duration(1)
                    .image("")
                    .firstQuestionID(1100L)
                    .build();
            defaultQuest.setId(1000L);
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
            answer2.setId(1102L);
            Question question1 = Question.builder()
                    .questID(defaultQuest.getId())
                    .questionText("Возникли ошибки с загрузкой квеста.\nСколько будет 2х2?")
                    .image("")
                    .build();
            question1.setId(1100L);
            question1.setAnswer(answer1);
            question1.setAnswer(answer2);
            Question question2 = Question.builder()
                    .questID(defaultQuest.getId())
                    .questionText("Верно.\nТы отличный математик!")
                    .isLast(true)
                    .isWin(true)
                    .image("")
                    .build();
            question2.setId(1200L);
            Question question3 = Question.builder()
                    .questID(defaultQuest.getId())
                    .questionText("Не правильно.\nС арифметикой ты не дружишь.")
                    .isLast(true)
                    .isWin(false)
                    .image("")
                    .build();
            question3.setId(1300L);
            List<Question> questions = new ArrayList<>();
            Collections.addAll(questions, question1, question2, question3);
            defaultQuest.setQuestions(questions);
            defaultQuest.setAuthorID(authorID);
            questService.normalizeQuest(defaultQuest);
            restoredQuests.add(defaultQuest);
        }

        return restoredQuests;
    }

    private void loadDefaultAdmin(){
        User defaultAdmin = User.builder()
                .name("Administrator")
                .login("admin")
                .password("admin")
                .role(Role.ADMINISTRATOR)
                .avatar("avatar-admin")
                .build();
        defaultAdmin.setId(1L);
        userRepository.add(defaultAdmin);

        Collection<Quest> defaultQuests = loadDefaultQuests(defaultAdmin.getId());
        if (Objects.nonNull(defaultQuests)) {
            for (Quest defaultQuest : defaultQuests) {
                questRepository.add(defaultQuest);
                defaultAdmin.setCreatedQuest(defaultQuest);
            }
        }
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
                if (q.getQuestions() != null) {
                    q.getQuestions()
                            .forEach(qe -> {
                                questionRepository.add(qe);
                                Collection<Answer> answers = qe.getAnswers();
                                if (answers != null) {
                                    answers.forEach(answerRepository::add);
                                }
                            });
                }
            });
        }
    }
}
