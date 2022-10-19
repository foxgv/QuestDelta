package ua.com.javarush.quest.gribanov.questdelta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import ua.com.javarush.quest.gribanov.questdelta.entity.*;
import ua.com.javarush.quest.gribanov.questdelta.repository.AnswerRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestionRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.UserRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Objects;

@UtilityClass
public class LoaderService {
    private final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
    private final String DEFAULT_IMAGES_FOLDER_NAME = "defaultImages";
    private final String TEMP_FOLDER_NAME = "tempDB";
    private String tempFolderPath;

    private UserRepository userRepository;
    private QuestRepository questRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private User defaultAdmin;
    private Quest defaultQuest;

    {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void load(){
        Path path = Paths.get(FileUtils.getTempDirectory().getAbsolutePath(), TEMP_FOLDER_NAME);
        try {
            tempFolderPath = Files.createDirectories(path).toFile().getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userRepository = UserRepository.get();
        questRepository = QuestRepository.get();
        questionRepository = QuestionRepository.get();
        answerRepository = AnswerRepository.get();

        defaultAdmin = User.builder()
                .name("Administrator")
                .login("admin")
                .password("admin")
                .role(Role.ADMINISTRATOR)
                .avatar("default-avatar-admin.png")
                .build();
        defaultAdmin.setId(1L);
        userRepository.add(defaultAdmin);

        defaultQuest = restoreQuest(path, defaultAdmin.getId());

        questRepository.add(defaultQuest);
        defaultAdmin.setCreatedQuest(defaultQuest);

//        try (OutputStream outputStream = Files.newOutputStream(path.resolve("quest.yaml"))) {
//            MAPPER.writeValue(outputStream, defaultQuest);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private Quest restoreQuest(Path path, Long authorID){
        Quest restoredQuest;
        try (InputStream inputStream = Files.newInputStream(path.resolve("quest.yaml"))){
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
        fillRepositories(restoredQuest);
        return restoredQuest;
    }

    private void fillRepositories(Quest quest){
        quest.getQuestions()
                .forEach(q -> {
                    questionRepository.add(q);
                    Collection<Answer> answers = q.getAnswers();
                    if (answers != null) {
                        answers.forEach(answerRepository::add);
                    }
                });
    }
}
