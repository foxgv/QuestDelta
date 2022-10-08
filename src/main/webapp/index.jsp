<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Beginning</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="index">

<div class="block1">
    <h2>Пролог</h2>
    <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля.</p>
    <p>Разве ты не об этом мечтал? Стать капитаном галактического судна с экипажем, который будет совершать подвиги под
        твоим командованием.</p>
    <p>Так что вперед!</p>
</div>

<div class="block2">
    <h2>Знакомство с экипажем</h2>
    <p>Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:</p>
    <p>- Здравствуйте, командир! Я Зинаида - ваша помощница.</p>
    <p>Видите? Там в углу пьет кофе наш штурман – сержант Перегарный Шлейф,
        под штурвалом спит наш бортмеханик – Черный Богдан,
        а фотографирует его Сергей Стальная Пятка – наш навигатор.</p>
    <p>А как обращаться к вам?</p>
</div>

<form method="get" action="IndexServlet">
    <label>
        <input class="name" placeholder="Введите как к вам можно обращаться и нажмите кнопку Представиться" size="30" type="text" name="firstName" required>
    </label>
    <input class="button" type="submit" value="Представиться">
</form>

<h4>
    Меня зовут: <c:out value="${sessionScope.name}"/>
</h4>
<p><a href="question1.jsp" class="button_href">Начать игру</a></p>

</body>
</html>