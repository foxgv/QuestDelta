# QuestDelta

Ребята и девчата, всем привет!

На этот раз у нас более сложный проект, который будет трудно объединить в один общий проект со всем зависимостями.
Поэтому поступим просто. Тут первоначально лежит абсолютно пустой проект. Заготовка, такая же как может быть
сгенерирована в IDEA.
Договоримся, что Java у нас будет 17-я. У всех. Привыкайте использовать только LTS.
Вот прямо без каких-либо плюшек, так что POM.xml в любом случае надо будет заменить на свой.

## Что нужно сделать.

1. Сделайте fork этого репозитория.
2. Создайте в нем ветку со своей фамилией, например, ivanov (я же тут тоже сделаю такие ветки).
3. Размещайте в этой ветке свое решение.
4. В конце вам нужно будет сделать pull request из своей ветки (в своем fork-е) в такую же точно ветку (в этом удаленном
   репозитории) и как обычно заполнить форму проектов
5. После сдачи ваших проектов я положу в **master/main** тот пример, который буду параллельно с вами разрабатывать на
   факультативах. На этот раз код копипастить не получится, смотрите видео, разбирайтесь, почему что и где сделано. Не
   копируйте, нужно ВАШЕ решение. Но мы уже и не совсем зеленые, правда ведь ;)
6. Проверять проекты по итогам третьего модуля буду я, скорее всего быстро не получится ;).
7. Планируйте время так, первые две недели - основной функционал. Последняя неделя - плюшки, рефакторинг, тесты,
   красоты.
8. Если будут какие-то моменты - я обновлю это README. Поглядывайте периодически.

2022 JRU Delta, Александр Хмелев.

## By Bogdanov

Портал для квестов, функционал:

1. Главная страница с описанием приложения
2. Раздел квестов с информацией по ним и кнопкой перехода к игре
3. Раздел создать не реализован
4. В разделе играть по умолчанию первый квест, если какой-то уже начат, то его состояние сохраняется до окончания
5. Статистика по всем сыгранным играм
6. Список пользователей (если роль админ можно создать пользователя и их редактировать)
7. Авторизация, дающая доступ к игре и другим функциям в зависимости от роли

TODO-list

1. Сделать раздел для создания своих квестов
2. Добавить тесты
3. Добавить логирование
4. Отследить ошибку, когда игра слетает из сессии (предположительно), и статистика падает с 500 exception
5. Добавить image service для работы с картинками
6. Добавить фильтр для установления кодировок на страницы jsp для корректного отображения русских символов
7. Перенести базу данных в файл
8. Решить проблему с добавлением префикса к uri при развертывании приложения через веб-сервер tomcat
9. Запустить приложение на публичном сервере для удаленного доступа к нему через браузер
10. Вынести все js скрипты в отдельный файл