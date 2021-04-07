<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

    <title>Hello, Trade-cars!</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<div><label></label></div>
<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <h3>
                    Hello job4j, welcome to trade cars platform
                </h3>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/allItem"><h4>Главная</h4></a>
            </li>
        </ul>
    </div>
</div>

<div class="container">

    <div> <label><h5>Загрузите Фото</h5> </label> </div>
    <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
        <div class="checkbox" style="margin-top:1px">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-default">Загрузить фото</button>
    </form>

    <div> <label></label> </div>

    <form action="<%=request.getContextPath()%>/addItem" method="post">
        <div>
            <label>Марка/выпадающий список</label>
            <!--            <input type="text" class="form-control" name="mark" id="mark" placeholder="Выберите марку">-->
            <div style="width: 330px">
                <select class="form-group custom-select" id="mark" name="mark" placeholder="Выберите марку">
                    <option value="" selected></option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label>Модель</label>
            <select class="form-group custom-select" id="model" name="model" placeholder="Выберите модель">
                <option value="" selected></option>
            </select>
        </div>
        <div class="form-group">
            <label>Трансмиссия</label>
            <input type="text" class="form-control" name="transmission" id="transmission" placeholder="Введите трансмиссию">
        </div>
        <div class="form-group">
            <label>Привод</label>
            <input type="text" class="form-control" name="drive" id="drive" placeholder="Введите привод">
        </div>
        <div>
            <label>Тип кузова/выпадающий список</label>
            <!--            <input type="text" class="form-control" name="model" id="model" placeholder="Выберите модель">-->
            <div style="width: 330px">
                <select class="form-group custom-select" id="typeBody" name="typeBody" placeholder="Выберите тип кузова">
                    <option value="" selected></option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label>Описание</label>
            <div style="width: 330px">
                <textarea class="form-control" rows="4" id="description" name="description" placeholder="Введите описание..."></textarea>
            </div>
        </div>
        <div> <label></label> </div>
        <div class="form-group" hidden>
            <input type="text" class="form-control" name="photo_id" id="photo_id" placeholder="Загрузите фото">
        </div>
        <button type="submit" class="btn btn-primary" onclick="return validate()">Сохранить</button>
    </form>

</div>

<style>
    div {
        width: 30%
    }
</style>

<script>
    $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/cars/marks",
            dataType: 'json',
            success: function (data) {
                let mark = "";
                for (let i = 0; i < data.length; i++) {
                    mark += "<option value=" + data[i]['name'] + ">" + data[i]['name'] + "</option>";
                }
                $('#mark option:last').after(mark);
            }
        })
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/cars/typeBody",
            dataType: 'json',
            success: function (data) {
                let mark = "";
                for (let i = 0; i < data.length; i++) {
                    mark += "<option value=" + data[i]['name'] + ">" + data[i]['name'] + "</option>";
                }
                $('#typeBody option:last').after(mark);
            }
        })
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/cars/models",
            dataType: 'json',
            success: function (data) {
                let mark = "";
                for (let i = 0; i < data.length; i++) {
                    mark += "<option value=" + data[i]['name'] + ">" + data[i]['name'] + "</option>";
                }
                $('#model option:last').after(mark);
            }
        })
    })

    function validate() {
        let result = true;
        let answer = '';
        let elements = [$("#mark"), $("#model"), $("#transmission"),
            $("#drive"), $("#typeBody"), $("#description")];
        for (let i = 0; i < elements.length; i++) {
            if (elements[i].val() === '') {
                answer += elements[i].attr("placeholder") + "\n";
                result = false;
            }
        }
        if (!result) {
            alert(answer);
        }
        return result;
    }
</script>


</body>
</html>