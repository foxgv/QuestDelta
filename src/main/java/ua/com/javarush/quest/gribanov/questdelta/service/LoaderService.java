package ua.com.javarush.quest.gribanov.questdelta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import ua.com.javarush.quest.gribanov.questdelta.entity.*;
import ua.com.javarush.quest.gribanov.questdelta.repository.AnswerRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestionRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

@UtilityClass
public class LoaderService {
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final String DEFAULT_IMAGES_FOLDER = "defaultImages";
    private String TEMP_FOLDER;

    private UserRepository userRepository;
    private QuestRepository questRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private User defaultAdmin;
    private final Quest defaultQuest = Quest.builder().build();

    {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void load(){
//        Path path = Paths.get(FileUtils.getTempDirectory().getAbsolutePath(), UUID.randomUUID().toString());
//        try {
//            TEMP_FOLDER = Files.createDirectories(path).toFile().getAbsolutePath();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

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
        defaultAdmin.setId(1);
        if (userRepository.find(defaultAdmin).isEmpty()){
            userRepository.add(defaultAdmin);
        }
        Quest defaultQuest = defaultQuest(defaultAdmin.getId());
        defaultQuest.getQuestions()
                .forEach(q->{
                    questionRepository.add(q);
                    q.getAnswers().forEach(answerRepository::add);
                });
        questRepository.add(defaultQuest);
        defaultAdmin.setCreatedQuest(defaultQuest);
    }

    private Quest defaultQuest(long authorID){
        Answer answer1 = Answer.builder()
                .questionID(1100)
                .answerText("Принять вызов")
                .nextQuestionID(1200)
                .build();
        answer1.setId(1101);
        Answer answer2 = Answer.builder()
                .questionID(1100)
                .answerText("Отклонить вызов")
                .nextQuestionID(1300)
                .build();
        answer1.setId(1102);
        Question question1 = Question.builder()
                .questID(defaultQuest.getId())
                .questionText("Ты потерял память.\nПринять вызов НЛО?")
                .isALast(false)
                .image("")
                .answer(answer1)
                .answer(answer2)
                .build();
        question1.setId(1100);
        Question question2 = Question.builder()
                .questID(defaultQuest.getId())
                .questionText("Ты отклонил вызов.\nПоражение.")
                .isALast(true)
                .image("")
                .build();
        question1.setId(1300);
        Quest defaultQuest = Quest.builder()
                .name("НЛО")
                .authorID(authorID)
                .image("")
                .question(question1)
                .question(question2)
                .build();
        defaultQuest.setId(1000);
        return defaultQuest;
    }
}
