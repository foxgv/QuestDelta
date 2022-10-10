<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaQuest</title>
</head>
<body>
<h1><%= "Привет, давай пройдем квест!" %>
</h1>
<br/>
<h1><%= "История начинается неожиданно"%></h1>
<p>
    Ты стоишь в космическом порту и готов подняться на борт корабля.
    <br/>
    Разве ты не мечтал о приключениях? Похоже на то, но ты ничего не помнишь.
    <br/>
    Как ты тут оказался? Что происходит? Столько вопросов.
    <br/>
    Попробуй вспомнить хотя бы свое имя:
</p>
<form class="form-horizontal" action="create" method="get">
<div class="form-group">
    <label class="col-md-4 control-label" for="name">Вспомнил?</label>
    <div class="col-md-4">
        <input id="name" name="name" type="text" placeholder="Введи имя" class="form-control input-md">
    </div>
    <br/>
    <div class=" form-group">
        <label class="col-md-4 control-label" for="submit"></label>
        <div class="col-md-4">
            <button id="submit" class="btn btn-success">Играть</button>
        </div>
    </div>
</div>
</form>
</body>
</html>