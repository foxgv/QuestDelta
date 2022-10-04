package ua.com.javarush.quest.kossatyy.questdelta.config;

import lombok.experimental.UtilityClass;
import ua.com.javarush.quest.kossatyy.questdelta.entity.*;
import ua.com.javarush.quest.kossatyy.questdelta.repository.*;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Init {

    private final UserRepository userRepository = Container.getInstance(UserRepository.class);
    private final GameRepository gameRepository = Container.getInstance(GameRepository.class);
    private final LevelRepository levelRepository = Container.getInstance(LevelRepository.class);
    private final ButtonRepository buttonRepository = Container.getInstance(ButtonRepository.class);
    private final RequirementRepository requirementRepository = Container.getInstance(RequirementRepository.class);

    public void load() {

        //----  Users
        User admin = User.builder()
                .id(1L)
                .login("admin")
                .password("111")
                .role(Role.ADMIN)
                .build();

        User maxim = User.builder()
                .id(2L)
                .login("maxim")
                .password("111")
                .role(Role.ADMIN)
                .build();

        User editor = User.builder()
                .id(3L)
                .login("editor")
                .password("222")
                .role(Role.EDITOR)
                .build();

        for (int i = 1; i <= 20; i++) {
            userRepository.create(User.builder()
                    .login("user" + i)
                    .password("333")
                    .role(Role.USER)
                    .build());
        }

        userRepository.create(admin);
        userRepository.create(maxim);
        userRepository.create(editor);

        //----  Game
        Game game_tomb = Game.builder()
                .id(1L)
                .name("Tomb of magic")
                .description("История повествует о странствующем волшебнике, искавшего древний источник знаний")
                .image("tomb_of_magic.jpg")
                .authorId(maxim.getId())
                .startQuestionId(0L)
                .build();

        //----  Requirements
        Requirement water = Requirement.builder()
                .id(1L)
                .name("Вода")
                .build();
        requirementRepository.create(water);

        Requirement earth = Requirement.builder()
                .id(2L)
                .name("Земля")
                .build();
        requirementRepository.create(earth);

        Requirement fire = Requirement.builder()
                .id(3L)
                .name("Огонь")
                .build();
        requirementRepository.create(fire);

        List<Requirement> requirements = new ArrayList<>();
        requirements.add(water);
        requirements.add(earth);
        requirements.add(fire);

        game_tomb.setRequirements(requirements);

        //----  Levels
        Long gameTombId = game_tomb.getId();
        List<Level> levels = new ArrayList<>();

        // Level - 0
        Button btn0_1 = Button.builder()
                .id(1L)
                .mainDescription("Далее")
                .mainLevelId(1L)
                .build();
        buttonRepository.create(btn0_1);

        Level level0 = Level.builder()
                .id(0L)
                .gameId(gameTombId)
                .name("Пролог")
                .image("wizard.jpg")
                .description("История повествует о странствующем волшебнике, искавшего древний источник знаний. Согласно древним письменностям одним из таких источников является заброшенная Гробница магии, секреты которой так и не были раскрыты. Потратив годы на поиски, волшебник обнаружил её в непроходимых джунглях. Но сможет ли он постичь новых знаний или его ожидает опасность, будет зависеть от принятых решений…")
                .buttons(List.of(btn0_1))
                .build();
        levelRepository.create(level0);
        levels.add(level0);

        // Level - 1
        Button btn1_1 = Button.builder()
                .id(2L)
                .mainDescription("Войти")
                .mainLevelId(3L)
                .build();
        buttonRepository.create(btn1_1);

        Button btn1_2 = Button.builder()
                .id(3L)
                .mainDescription("Не входить")
                .mainLevelId(4L)
                .build();
        buttonRepository.create(btn1_2);

        Button btn1_3 = Button.builder()
                .id(4L)
                .mainDescription("Осмотреться")
                .mainLevelId(2L)
                .build();
        buttonRepository.create(btn1_3);

        Level level1 = Level.builder()
                .id(1L)
                .gameId(gameTombId)
                .name("Вход в гробницу")
                .image("entry.jpg")
                .description("Вход в гробницу находился в самой глуши леса. Он порос растительностью и трудно было разобрать надписи, высеченные на нем. Выглядело все это зловеще, даже пугающе…")
                .buttons(List.of(btn1_1, btn1_2, btn1_3))
                .build();
        levelRepository.create(level1);
        levels.add(level1);

        // Level - 2
        Button btn2_1 = Button.builder()
                .id(5L)
                .mainDescription("Посмотреть на руну")
                .mainLevelId(6L)
                .build();
        buttonRepository.create(btn2_1);

        Button btn2_2 = Button.builder()
                .id(6L)
                .mainDescription("Очистить с помощью магии")
                .mainLevelId(7L)
                .altDescription("Очистить с помощью магии")
                .altLevelId(5L)
                .requirementId(water.getId())
                .build();
        buttonRepository.create(btn2_2);

        Level level2 = Level.builder()
                .id(2L)
                .gameId(gameTombId)
                .name("Осмотр входа")
                .image("entry_inscription.jpg")
                .description("Вы осматриваетесь. Рядом стоящий монумент привлекает ваше внимание. На нем описывается некая тайная сила, неподвластной никому... \n" +
                        "Под надписью изображен знак похожий на руну магии, возможно, он означает что-то важное. Из-за множества пройденных лет руна покрылась толстым слоем пыли и копоти.")
                .buttons(List.of(btn2_1, btn2_2))
                .build();
        levelRepository.create(level2);
        levels.add(level2);

        // Level - 3
        Button btn3_1 = Button.builder()
                .id(7L)
                .mainDescription("Продолжить спускаться")
                .mainLevelId(8L)
                .build();
        buttonRepository.create(btn3_1);

        Level level3 = Level.builder()
                .id(3L)
                .gameId(gameTombId)
                .name("Спуск")
                .image("stairs.jpg")
                .description("Войдя в гробницу, вы начинаете спускаться по мрачной лестнице. Она введет куда-то глубоко вниз. Лишь остатки солнечного света освещают вам путь. Каждая пройденная ступенька внушает в вас долю сомнению, стоило ли сюда входить и безопасно ли идти дальше…")
                .buttons(List.of(btn3_1))
                .build();
        levelRepository.create(level3);
        levels.add(level3);

        // Level - 4
        Button btn4_1 = Button.builder()
                .id(8L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn4_1);

        Level level4 = Level.builder()
                .id(4L)
                .gameId(gameTombId)
                .name("Поражение - уход")
                .image("lose_runaway.jpg")
                .description("Вы побоялись за свою жизнь и ушли, так и не узнав, что скрывает гробница.")
                .buttons(List.of(btn4_1))
                .build();
        levelRepository.create(level4);
        levels.add(level4);

        // Level - 5
        Button btn5_1 = Button.builder()
                .id(9L)
                .mainDescription("Посмотреть на руну")
                .mainLevelId(6L)
                .build();
        buttonRepository.create(btn5_1);

        Level level5 = Level.builder()
                .id(5L)
                .gameId(gameTombId)
                .name("Другая стихия")
                .image("magic.png")
                .description("Ваши попытки очистить руну были тщетны, так как ваша стихия не подходит для таких целей. Нужно осмотреть хотя бы часть руны.")
                .buttons(List.of(btn5_1))
                .build();
        levelRepository.create(level5);
        levels.add(level5);

        // Level - 6
        Button btn6_1 = Button.builder()
                .id(10L)
                .mainDescription("Вернуться ко входу")
                .mainLevelId(1L)
                .build();
        buttonRepository.create(btn6_1);

        Level level6 = Level.builder()
                .id(6L)
                .gameId(gameTombId)
                .name("Часть руны")
                .image("entry_inscription_dark.jpg")
                .description("Видны очертания некой руны. Она имеет некое свечение, похоже она излучает магию.")
                .buttons(List.of(btn6_1))
                .build();
        levelRepository.create(level6);
        levels.add(level6);

        // Level - 7
        Button btn7_1 = Button.builder()
                .id(11L)
                .mainDescription("Вернуться ко входу")
                .mainLevelId(1L)
                .build();
        buttonRepository.create(btn7_1);

        Level level7 = Level.builder()
                .id(7L)
                .gameId(gameTombId)
                .name("Целая руна")
                .image("entry_inscription_clear.jpg")
                .description("Ваша стихия прекрасно подошла, чтобы очистить надпись.\n" +
                        "Перед вами появилась руна. Она имеет некое свечение, похоже она излучает магию.")
                .buttons(List.of(btn7_1))
                .build();
        levelRepository.create(level7);
        levels.add(level7);

        // Level - 8
        Button btn8_1 = Button.builder()
                .id(12L)
                .mainDescription("Выбрать руну")
                .mainLevelId(9L)
                .build();
        buttonRepository.create(btn8_1);

        Level level8 = Level.builder()
                .id(8L)
                .gameId(gameTombId)
                .name("Врата")
                .image("gate.jpg")
                .description("Спустившись вниз, вы обнаружили закрытые врата. Похоже они запечатаны магией. На них имеются надписи, как и на входе в гробницу. Для их открытия нужно использовать правильную руну магии, но какую…")
                .buttons(List.of(btn8_1))
                .build();
        levelRepository.create(level8);
        levels.add(level8);

        // Level - 9
        Button btn9_1 = Button.builder()
                .id(13L)
                .mainDescription("Руна Вен")
                .mainLevelId(11L)
                .build();
        buttonRepository.create(btn9_1);

        Button btn9_2 = Button.builder()
                .id(14L)
                .mainDescription("Руна Зоа")
                .mainLevelId(11L)
                .build();
        buttonRepository.create(btn9_2);

        Button btn9_3 = Button.builder()
                .id(15L)
                .mainDescription("Руна Кван")
                .mainLevelId(10L)
                .build();
        buttonRepository.create(btn9_3);

        Button btn9_4 = Button.builder()
                .id(16L)
                .mainDescription("Руна Оан")
                .mainLevelId(11L)
                .build();
        buttonRepository.create(btn9_4);

        Level level9 = Level.builder()
                .id(9L)
                .gameId(gameTombId)
                .name("Врата")
                .image("gate.jpg")
                .description("Спустившись вниз, вы обнаружили закрытые врата. Похоже они запечатаны магией. На них имеются надписи, как и на входе в гробницу. Для их открытия нужно использовать правильную руну магии, но какую…")
                .buttons(List.of(btn9_1, btn9_2, btn9_3, btn9_4))
                .build();
        levelRepository.create(level9);
        levels.add(level9);

        // Level - 10
        Button btn10_1 = Button.builder()
                .id(17L)
                .mainDescription("Идти дальше")
                .mainLevelId(12L)
                .build();
        buttonRepository.create(btn10_1);

        Level level10 = Level.builder()
                .id(10L)
                .gameId(gameTombId)
                .name("Проход за вратами")
                .image("passage_after_gate.jpg")
                .description("Перед вами распахиваются врата, и вы следуете дальше по тропе. Здешняя флора пропитана магией и каждое отдельное растение переливается в различных цветах. В конце прохода слышны звуки…")
                .buttons(List.of(btn10_1))
                .build();
        levelRepository.create(level10);
        levels.add(level10);

        // Level - 11
        Button btn11_1 = Button.builder()
                .id(18L)
                .mainDescription("Бежать")
                .mainLevelId(14L)
                .build();
        buttonRepository.create(btn11_1);

        Button btn11_2 = Button.builder()
                .id(19L)
                .mainDescription("Защититься магией")
                .mainLevelId(13L)
                .altDescription("Защититься магией")
                .altLevelId(14L)
                .requirementId(earth.getId())
                .build();
        buttonRepository.create(btn11_2);

        Level level11 = Level.builder()
                .id(11L)
                .gameId(gameTombId)
                .name("Обвал")
                .image("collapse.jpg")
                .description("Выбранная руна была ошибкой! Земля начинает сотрясаться под ногами. Похоже сработала защитная магия врат! Землетрясение повлекло обрушение потолка. Осторожней…")
                .buttons(List.of(btn11_1, btn11_2))
                .build();
        levelRepository.create(level11);
        levels.add(level11);

        // Level - 12
        Button btn12_1 = Button.builder()
                .id(20L)
                .mainDescription("Идти на свет")
                .mainLevelId(15L)
                .build();
        buttonRepository.create(btn12_1);

        Button btn12_2 = Button.builder()
                .id(21L)
                .mainDescription("Подняться наверх")
                .mainLevelId(16L)
                .build();
        buttonRepository.create(btn12_2);

        Button btn12_3 = Button.builder()
                .id(22L)
                .mainDescription("Подойти к существу")
                .mainLevelId(17L)
                .build();
        buttonRepository.create(btn12_3);

        Level level12 = Level.builder()
                .id(12L)
                .gameId(gameTombId)
                .name("Перекресток")
                .image("crossroad.jpg")
                .description("""
                        Идя на звук, вы доходите до развилки.\s
                        Вы обращаете внимание на свет, исходящего из правого прохода, возможно там кто-то есть.\s
                        Внезапно в глаза вам бросается некое существо, скрывающегося в темноте центрального прохода. Выглядит оно недоброжелательно. \s
                        Левее существа есть проход куда-то выше, возможно если пройти мимо, существо не обратит на вас внимание.""")
                .buttons(List.of(btn12_1, btn12_2, btn12_3))
                .build();
        levelRepository.create(level12);
        levels.add(level12);

        // Level - 13
        Button btn13_1 = Button.builder()
                .id(23L)
                .mainDescription("Пройти во врата")
                .mainLevelId(10L)
                .build();
        buttonRepository.create(btn13_1);

        Level level13 = Level.builder()
                .id(13L)
                .gameId(gameTombId)
                .name("Защита от обвала")
                .image("earth_magic.jpg")
                .description("Благодаря силе земли вам удается защититься от падающих обломков. Вы остались целы. Похоже один из осколков повредил врата, и они распахнулись.")
                .buttons(List.of(btn13_1))
                .build();
        levelRepository.create(level13);
        levels.add(level13);

        // Level - 14
        Button btn14_1 = Button.builder()
                .id(24L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn14_1);

        Level level14 = Level.builder()
                .id(14L)
                .gameId(gameTombId)
                .name("Поражение - обвал")
                .image("lose_collapse.jpg")
                .description("Ни попытка побега, ни ваша магия не смогли вас уберечь от падающих осколков. Вы умираете… Похоже эта гробница теперь и ваша тоже…")
                .buttons(List.of(btn14_1))
                .build();
        levelRepository.create(level14);
        levels.add(level14);

        // Level - 15
        Button btn15_1 = Button.builder()
                .id(25L)
                .mainDescription("Вернуться назад")
                .mainLevelId(12L)
                .build();
        buttonRepository.create(btn15_1);

        Button btn15_2 = Button.builder()
                .id(26L)
                .mainDescription("Осмотреть алтарь")
                .mainLevelId(18L)
                .build();
        buttonRepository.create(btn15_2);

        Level level15 = Level.builder()
                .id(15L)
                .gameId(gameTombId)
                .name("Комната с алтарем")
                .image("altar_room.jpg")
                .description("В комнате вы обнаружили алтарь с зажжёнными свечами, но никого больше не наблюдаете.")
                .buttons(List.of(btn15_1, btn15_2))
                .build();
        levelRepository.create(level15);
        levels.add(level15);

        // Level - 16
        Button btn16_1 = Button.builder()
                .id(27L)
                .mainDescription("Пройти дальше")
                .mainLevelId(19L)
                .build();
        buttonRepository.create(btn16_1);

        Level level16 = Level.builder()
                .id(16L)
                .gameId(gameTombId)
                .name("Верхняя комната")
                .image("upper_room.jpg")
                .description("Поднявшись наверх, вы обнаруживаете просторный зал. В центре, которого находится статуя падшего ангела. На другом конце виднеется проход куда-то дальше, но дорога становится все мрачнее и мрачнее. Нагнетающая обстановка все больше оказывает на вас влияние…")
                .buttons(List.of(btn16_1))
                .build();
        levelRepository.create(level16);
        levels.add(level16);

        // Level - 17
        Button btn17_1 = Button.builder()
                .id(28L)
                .mainDescription("Выбрать другой путь")
                .mainLevelId(12L)
                .build();
        buttonRepository.create(btn17_1);

        Button btn17_2 = Button.builder()
                .id(29L)
                .mainDescription("Идти в темноту")
                .mainLevelId(20L)
                .build();
        buttonRepository.create(btn17_2);

        Level level17 = Level.builder()
                .id(17L)
                .gameId(gameTombId)
                .name("Существо")
                .image("creature.jpg")
                .description("Вы начали приближаться к этому существу, но оно испугалось и убежало куда-то в глубь темноты…")
                .buttons(List.of(btn17_1, btn17_2))
                .build();
        levelRepository.create(level17);
        levels.add(level17);

        // Level - 18
        Button btn18_1 = Button.builder()
                .id(30L)
                .mainDescription("Отойти от алтаря")
                .mainLevelId(15L)
                .build();
        buttonRepository.create(btn18_1);

        Level level18 = Level.builder()
                .id(18L)
                .gameId(gameTombId)
                .name("Алтарь")
                .image("altar.jpg")
                .description("На алтаре разбросаны различные вещи, но ничего интересного вы не находите.")
                .buttons(List.of(btn18_1))
                .build();
        levelRepository.create(level18);
        levels.add(level18);

        // Level - 19
        Button btn19_1 = Button.builder()
                .id(31L)
                .mainDescription("Идти дальше")
                .mainLevelId(21L)
                .build();
        buttonRepository.create(btn19_1);

        Level level19 = Level.builder()
                .id(19L)
                .gameId(gameTombId)
                .name("Проход")
                .image("passage_after_upper_room.jpg")
                .description("Вы проходите дальше и наблюдаете длинный коридор ведущий вас все глубже. Чувствуется, что влажность в этой части подземелья выше, чем в предыдущих местах. Из-за такого климата дорожка покрылась слоем слизи. Нерасторопно передвигаясь, вы продолжаете свой путь…")
                .buttons(List.of(btn19_1))
                .build();
        levelRepository.create(level19);
        levels.add(level19);

        // Level - 20
        Button btn20_1 = Button.builder()
                .id(32L)
                .mainDescription("Идти дальше")
                .mainLevelId(23L)
                .build();
        buttonRepository.create(btn20_1);

        Button btn20_2 = Button.builder()
                .id(33L)
                .mainDescription("Вернуться назад")
                .mainLevelId(12L)
                .build();
        buttonRepository.create(btn20_2);

        Button btn20_3 = Button.builder()
                .id(34L)
                .mainDescription("Осветить путь")
                .mainLevelId(22L)
                .requirementId(fire.getId())
                .build();
        buttonRepository.create(btn20_3);

        Level level20 = Level.builder()
                .id(20L)
                .gameId(gameTombId)
                .name("Темнота")
                .image("darkness.jpg")
                .description("Тьма сгущается, и вы перестаете различать дорогу под ногами. Дальнейшее передвижение может быть опасно, передвигаться придется на ощупь. Неизвестно чего ожидать в глубине прохода…")
                .buttons(List.of(btn20_1, btn20_2, btn20_3))
                .build();
        levelRepository.create(level20);
        levels.add(level20);

        // Level - 21
        Button btn21_1 = Button.builder()
                .id(35L)
                .mainDescription("Идти дальше")
                .mainLevelId(24L)
                .build();
        buttonRepository.create(btn21_1);

        Level level21 = Level.builder()
                .id(21L)
                .gameId(gameTombId)
                .name("Комната пыток")
                .image("torture_room.jpg")
                .description("Вы проходите дальше и вас охватывает озноб… Температура помещения и правда здесь низкая, но это был шок от увиденного. Похоже здесь находилась своего рода комната пыток. Огромные клетки спускались с потолка. От увиденного вам захотелось быстрее покинуть данное помещение…")
                .buttons(List.of(btn21_1))
                .build();
        levelRepository.create(level21);
        levels.add(level21);

        // Level - 22
        Button btn22_1 = Button.builder()
                .id(36L)
                .mainDescription("Подняться по лестнице")
                .mainLevelId(25L)
                .build();
        buttonRepository.create(btn22_1);

        Level level22 = Level.builder()
                .id(22L)
                .gameId(gameTombId)
                .name("Найден проход")
                .image("out_of_the_dark.jpg")
                .description("Без ваших способностей вы бы долго блуждали во тьме, но тут обнаруживаете узкий проход. Этот проход выводит вас лестницу ведущую куда-то вверх…")
                .buttons(List.of(btn22_1))
                .build();
        levelRepository.create(level22);
        levels.add(level22);

        // Level - 23
        Button btn23_1 = Button.builder()
                .id(37L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn23_1);

        Level level23 = Level.builder()
                .id(23L)
                .gameId(gameTombId)
                .name("Поражение - темнота")
                .image("lose_darkness.jpg")
                .description("Пройдя значительное расстояние, вы перестаете разбирать куда идти дальше, похоже вы заблудились в темноте. Этот проход похож на лабиринт. Вас охватывает паника и беспомощность. Идти сюда было глупой затеей, которая повлекла вечным скитанием в кромешной тьме…")
                .buttons(List.of(btn23_1))
                .build();
        levelRepository.create(level23);
        levels.add(level23);

        // Level - 24
        Button btn24_1 = Button.builder()
                .id(38L)
                .mainDescription("Идти дальше")
                .mainLevelId(26L)
                .build();
        buttonRepository.create(btn24_1);

        Level level24 = Level.builder()
                .id(24L)
                .gameId(gameTombId)
                .name("Стоки")
                .image("drains.jpg")
                .description("Дорога выводит вас на сточный канал. Повсюду находится зловонный запах. Вы чувствуете легкий ветерок, тянущийся откуда-то из глубины…")
                .buttons(List.of(btn24_1))
                .build();
        levelRepository.create(level24);
        levels.add(level24);

        // Level - 25
        Button btn25_1 = Button.builder()
                .id(39L)
                .mainDescription("Войти в комнату")
                .mainLevelId(27L)
                .build();
        buttonRepository.create(btn25_1);

        Level level25 = Level.builder()
                .id(25L)
                .gameId(gameTombId)
                .name("Проход к сокровищнице")
                .image("passage_to_treasury.jpg")
                .description("Поднявшись наверх, вы обнаруживаете коридор ведущий в единственную комнату с закрытыми дверьми. Добраться до сюда составило много труда. Возможно, кто-то специально сделал такое укромное место.")
                .buttons(List.of(btn25_1))
                .build();
        levelRepository.create(level25);
        levels.add(level25);

        // Level - 26
        Button btn26_1 = Button.builder()
                .id(40L)
                .mainDescription("Тайна")
                .mainLevelId(30L)
                .build();
        buttonRepository.create(btn26_1);

        Button btn26_2 = Button.builder()
                .id(41L)
                .mainDescription("Время")
                .mainLevelId(28L)
                .build();
        buttonRepository.create(btn26_2);

        Button btn26_3 = Button.builder()
                .id(42L)
                .mainDescription("42")
                .mainLevelId(29L)
                .build();
        buttonRepository.create(btn26_3);

        Level level26 = Level.builder()
                .id(26L)
                .gameId(gameTombId)
                .name("Врата судьбы")
                .image("gate_of_fate.jpg")
                .description("Вы проходите дальше по стокам и натыкаетесь на магические врата. Из них доносится голос… Тихий и спокойный шепот спрашивает у вас: “Вчера было, сегодня есть и завтра будет”. \n" +
                        "Недолго думая, вы произносите ответ…")
                .buttons(List.of(btn26_1, btn26_2, btn26_3))
                .build();
        levelRepository.create(level26);
        levels.add(level26);

        // Level - 27
        Button btn27_1 = Button.builder()
                .id(43L)
                .mainDescription("Войти в левую комнату")
                .mainLevelId(32L)
                .build();
        buttonRepository.create(btn27_1);

        Button btn27_2 = Button.builder()
                .id(44L)
                .mainDescription("Войти в центральную комнату")
                .mainLevelId(31L)
                .build();
        buttonRepository.create(btn27_2);

        Button btn27_3 = Button.builder()
                .id(45L)
                .mainDescription("Войти в правую комнату")
                .mainLevelId(32L)
                .build();
        buttonRepository.create(btn27_3);

        Level level27 = Level.builder()
                .id(27L)
                .gameId(gameTombId)
                .name("Двери")
                .image("crossroad_2.jpg")
                .description("""
                        В центре комнаты присутствует монумент, на котором висит табличка. Она гласит следующее: “Оно забрало много жизней, но я так и не смог вернуть свое богатство…”\s
                        Похоже это послание от создателя было его целью жизни, но он так и не смог его постичь. Чтобы это не значило.
                        Перед вами встал выбор дальнейшего пути.""")
                .buttons(List.of(btn27_1, btn27_2, btn27_3))
                .build();
        levelRepository.create(level27);
        levels.add(level27);

        // Level - 28
        Button btn28_1 = Button.builder()
                .id(46L)
                .mainDescription("Пройти дальше")
                .mainLevelId(33L)
                .build();
        buttonRepository.create(btn28_1);

        Level level28 = Level.builder()
                .id(28L)
                .gameId(gameTombId)
                .name("Проход судьбы")
                .image("passage_of_fate.jpg")
                .description("После произнесенного ответа, врата раскрылись и позволили вам пройти дальше. В конце прохода виднеется яркое свечение…")
                .buttons(List.of(btn28_1))
                .build();
        levelRepository.create(level28);
        levels.add(level28);

        // Level - 29
        Button btn29_1 = Button.builder()
                .id(47L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn29_1);

        Level level29 = Level.builder()
                .id(29L)
                .gameId(gameTombId)
                .name("Поражение - 42")
                .image("lose_42.png")
                .description("Ответ, опережающий свое время, но совсем на другой вопрос…\n" +
                        "Врата закрываются и преграждают вам путь. На этом ваше путешествие заканчивается. Тайна этой гробницы так и останется неизведанной…")
                .buttons(List.of(btn29_1))
                .build();
        levelRepository.create(level29);
        levels.add(level29);

        // Level - 30
        Button btn30_1 = Button.builder()
                .id(48L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn30_1);

        Level level30 = Level.builder()
                .id(30L)
                .gameId(gameTombId)
                .name("Поражение – ответ судьбы")
                .image("lose_fate.jpg")
                .description("После произнесенного ответа нависла тишина, но после короткого промежутка времени врата закрываются и преграждают вам путь. \n" +
                        "  На этом ваше путешествие заканчивается. Тайна этой гробницы так и останется неизведанной…")
                .buttons(List.of(btn30_1))
                .build();
        levelRepository.create(level30);
        levels.add(level30);

        // Level - 31
        Button btn31_1 = Button.builder()
                .id(49L)
                .mainDescription("Продолжить")
                .mainLevelId(34L)
                .build();
        buttonRepository.create(btn31_1);

        Level level31 = Level.builder()
                .id(31L)
                .gameId(gameTombId)
                .name("Сокровищница")
                .image("final_2.jpg")
                .description("""
                        Вы входите в комнату и обнаруживаете, что это сокровищница! Она вся усыпана горами золота и драгоценностями. Пробираясь по этим горам, вы находите в центре помещения саркофаг. Похоже это могила создателя. Надпись на ней гласит: “Его уже нельзя вернуть!”
                        Похоже все эти драгоценности имели мало смысла для него, и он искал что-то другое, но кто знает, что это на самом деле было…
                        На этом ваше приключение заканчивается…""")
                .buttons(List.of(btn31_1))
                .build();
        levelRepository.create(level31);
        levels.add(level31);

        // Level - 32
        Button btn32_1 = Button.builder()
                .id(50L)
                .mainDescription("Новая игра")
                .mainLevelId(-1L)
                .build();
        buttonRepository.create(btn32_1);

        Level level32 = Level.builder()
                .id(32L)
                .gameId(gameTombId)
                .name("Поражение - двери")
                .image("lose_doors.jpg")
                .description("Вы проходите в мало освещенную комнату. Она оказывается полностью пустой. Но тут издается шорох, доносящийся из угла этой комнаты. Вы подходите ближе и понимаете, это существо, которое ранее встречали. Оно, заметив вас, начинает стремительно сближаться, чтобы напасть. Все происходит настолько быстро, что вы даже не успеваете среагировать…\n" +
                        "Этот монстр не оставляет вам и шансов на выживание…")
                .buttons(List.of(btn32_1))
                .build();
        levelRepository.create(level32);
        levels.add(level32);

        // Level - 33
        Button btn33_1 = Button.builder()
                .id(51L)
                .mainDescription("Спуститься")
                .mainLevelId(35L)
                .build();
        buttonRepository.create(btn33_1);

        Level level33 = Level.builder()
                .id(33L)
                .gameId(gameTombId)
                .name("Гробница")
                .image("tomb_room.jpg")
                .description("""
                        Вы идете дальше на свечение, но ваша дорога прерывается обрывом. Дойдя до него, вас завораживает увиденное…\s
                        Это погребальный зал – сердце данной гробницы. Вы лицезрите от части пугающий, но и в тоже время захватывающий вид.\s
                        Вы понимаете, что почти достигли своей цели и осталось совсем чуть-чуть…""")
                .buttons(List.of(btn33_1))
                .build();
        levelRepository.create(level33);
        levels.add(level33);

        // Level - 34
        Button btn34_1 = Button.builder()
                .id(52L)
                .mainDescription("Новая игра")
                .mainLevelId(-2L)
                .build();
        buttonRepository.create(btn34_1);

        Level level34 = Level.builder()
                .id(34L)
                .gameId(gameTombId)
                .name("Финал")
                .image("final.jpg")
                .description("Одна из историй о приключении странствующего волшебника была завершена. На этом его путь продолжается, в поисках чего-то неизведанного…\n" +
                        "И кто знает куда его занесет в следующий раз на этой необъятной земле. Ведь она заполнена множеством волшебных и загадочных мест, а также их обитателей…")
                .buttons(List.of(btn34_1))
                .build();
        levelRepository.create(level34);
        levels.add(level34);

        // Level - 35
        Button btn35_1 = Button.builder()
                .id(53L)
                .mainDescription("Достать сверток")
                .mainLevelId(36L)
                .build();
        buttonRepository.create(btn35_1);

        Level level35 = Level.builder()
                .id(35L)
                .gameId(gameTombId)
                .name("Саркофаг")
                .image("tomb.jpg")
                .description("Вы спускаетесь и обнаруживаете в центре этого помещения открытый гроб с останками внутри. Диадема и наряд натолкнули на мысль, что перед вами находится принцесса. Однако, вам не понятно столь странное расположение и причины произошедшего…\n" +
                        " Всматриваясь, обнаруживаете в одной из рук клочок бумаги, похожий на письмо и рядом лежащий клинок…")
                .buttons(List.of(btn35_1))
                .build();
        levelRepository.create(level35);
        levels.add(level35);

        // Level - 36
        Button btn36_1 = Button.builder()
                .id(54L)
                .mainDescription("Продолжить")
                .mainLevelId(37L)
                .build();
        buttonRepository.create(btn36_1);

        Level level36 = Level.builder()
                .id(36L)
                .gameId(gameTombId)
                .name("Письмо")
                .image("scroll.jpg")
                .description("""
                        Сверток представлял из себя записку, оставленную после своей смерти. В ней описываются чувства, которые она испытывала к своему возлюбленному. Её переживания за него, и что он был в постоянном поиске некого сокровища…
                        Она не понимала столь ослепленного желания найти его, ведь они были счастливы вместе, но ему было всего мало, имея при этом кучи драгоценностей и власти…
                        После его смерти она не видела больше смысла жизни и покончила с собой, в надежде воссоединиться со своим возлюбленным.""")
                .buttons(List.of(btn36_1))
                .build();
        levelRepository.create(level36);
        levels.add(level36);

        // Level - 37
        Button btn37_1 = Button.builder()
                .id(55L)
                .mainDescription("Уйти")
                .mainLevelId(34L)
                .build();
        buttonRepository.create(btn37_1);

        Level level37 = Level.builder()
                .id(37L)
                .gameId(gameTombId)
                .name("Финальное слово")
                .image("final_word.jpg")
                .description("Заканчивая читать письмо, вы осматриваетесь вокруг, но ничего интересного больше не находите. У вас на уме остаются лишь мысли что же искал этот человек. Почему он так жаждал достичь его, забывая о своей любви. А также сокровища, которое вы нигде не смогли обнаружить…\n" +
                        "Вам ничего больше не остается как покинуть это место…")
                .buttons(List.of(btn37_1))
                .build();
        levelRepository.create(level37);
        levels.add(level37);

        game_tomb.setLevels(levels);
        gameRepository.create(game_tomb);
    }
}
