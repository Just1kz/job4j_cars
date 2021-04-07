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
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
                <a class="nav-link" href="<%=request.getContextPath()%>/addItem.jsp"><h4>Добавить объявление</h4></a>
            </li>
        </ul>
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/start.jsp"><h4>Выход</h4></a>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="row">
        <c:if test="${not empty error}">
            <div style="color:red; font-weight: bold; margin-left:20px ">
                    ${error}
            </div>
        </c:if>
    </div>
</div>

<div class="container">
    <div class="row">
        <form action="<%=request.getContextPath()%>/baseFilters" method="post">
            <div>
                <label style="margin-left:20px; margin-top:20px;">Выберите фильтр</label>
                <div>
                    <select class="form-group custom-select" name="filter" id="filter" style="margin-left:20px; width: 280px" placeholder="Выберите фильтр">
                        <option value="my" selected>Только мои</option>
                        <option value="noSold" selected>Не проданные</option>
                        <option value="lastDay" selected>За последний день</option>
                        <option value="withPhoto" selected>С фото</option>
                        <option value="all" selected>Все объявления</option>
                    </select>
                </div>
                <s>
                    <button type="submit" id = "button1" class="btn btn-primary" style="margin-left:20px" onclick="validateFilter()">Показать</button>
                </s>
            </div>
        </form>
<%--        onclick="return validate()"--%>
        <form action="<%=request.getContextPath()%>/markFilters" method="post">
            <div style="margin-left:20px">
                <label style="margin-left:20px; margin-top:20px;">Выберите марку</label>
                <div>
                    <select class="form-group custom-select" name="mark" id="mark" style="margin-left:20px; width: 280px" placeholder="Выберите марку">
                        <option value="" selected></option>
                    </select>
                </div>
                <s>
                    <button type="submit" id = "button2" class="btn btn-primary" style="margin-left:20px" onclick="validateMarkFilter()">Показать</button>
                </s>
            </div>
        </form>
<%--        onclick="return validate()"--%>
        <form action="<%=request.getContextPath()%>/sold" method="post">
            <div class="form-group" style="margin-left:20px">
                <label style="margin-left:20px; margin-top:20px;">Выберите объявление </label>
                <div>
                    <input type="text" class="form-control" style="margin-left:20px; width: 280px" name="id_to_sold" id="id_to_sold" placeholder="Введите ID объявления">
                </div>

                <div>
                    <button type="submit" id = "button3" class="btn btn-primary" style="margin-left:20px; margin-top:18px" onclick="validateIdToSold()">Продано</button>
                </div>
            </div>
        </form>
<%--        onclick="return validate()"--%>
    </div>
</div>

<%--<form action="<%=request.getContextPath()%>/allItem" method="get">--%>
<%--    action="<%=request.getContextPath()%>/baseFilters" method="get"--%>
<div class="table table-sm table-bordered" >
    <table class="table" id = "table" style="margin-left:400px">
        <thead style="font-size:14px;">
        <tr style="background-color: rgb(0,150,350)">
            <th scope="col" style="text-align: center;">Фото</th>
            <th scope="col" style="text-align: center;">Объявление</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td style="image-orientation: flip">
                    <center>
                        <img src="<c:url value='/download?name=${item.photo.title}'/>" width="300px" height="250px"/>
                    </center>

                </td>
                <td style="text-align: left">
                    <table class="table">
                        <thead style="font-size:14px;">
                        <th scope="col" style="text-align: center; background-color: rgb(0,150,350)">Параметр</th>
                        <th  scope="col" style="text-align: center; background-color: rgb(0,150,350)">Показатель</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td style="text-align: right;">
                                Статус:
                            </td>
                            <td style="text-align: center;">
                                <c:if test="${item.sold == false}">
                                    Продаётся
                                </c:if>
                                <c:if test="${item.sold == true}">
                                    Продано
                                </c:if>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Дата объявления:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.created}"/>
                            </td>
                        </tr>

                        <tr >
                            <td style="text-align: right;">
                                ID:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.id}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Марка:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.mark.name}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Модель:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.model.name}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Трансмиссия:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.transmission}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Привод:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.drive}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Тип кузова:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.typeBody.name}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Подробное описание:
                            </td>
                            <td style="text-align: center;">
                                <c:out value="${item.description}"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="text-align: right;">
                                Продавец:
                            </td>
                            <td style="text-align: center;">
                                Имя: <c:out value="${item.user.name}"/> |
                                Телефон: <c:out value="${item.user.phone}"/>
                            </td>
                        </tr>

                        </td>
                        </tbody>
                    </table>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

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
    })

    function validateFilter() {
        let result = true;
        let answer = '';
        let elements = [$("#filter")];
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

    function validateMarkFilter() {
        let result = true;
        let answer = '';
        let elements = [$("#mark")];
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

    function validateIdToSold() {
        let result = true;
        let answer = '';
        let elements = [$("#id_to_sold")];
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

<script>
    function showDesc() {

    }
</script>

<style>
    #button1 {
        /*background-position: 1px 1px; !* Position the search icon *!*/
        width: 45%; /* Full-width */
        font-size: 16px; /* Increase font-size */
        padding: 7px 7px 7px 7px; /* Add some padding */
        /*border: 1px solid #ddd; !* Add a grey border *!*/
        /*margin-bottom: 15px; !* Add some space below the input *!*/
        align-items: center;
    }
    #button2 {
        /*background-position: 1px 1px; !* Position the search icon *!*/
        width: 45%; /* Full-width */
        font-size: 16px; /* Increase font-size */
        padding: 7px 7px 7px 7px; /* Add some padding */
        /*border: 1px solid #ddd; !* Add a grey border *!*/
        /*margin-bottom: 15px; !* Add some space below the input *!*/
        align-items: center;
    }
    #button3 {
        /*background-position: 1px 1px; !* Position the search icon *!*/
        width: 45%; /* Full-width */
        font-size: 16px; /* Increase font-size */
        padding: 7px 7px 7px 7px; /* Add some padding */
        /*border: 1px solid #ddd; !* Add a grey border *!*/
        /*margin-bottom: 15px; !* Add some space below the input *!*/
        align-items: center;
    }

    #button4 {
        /*background-position: 1px 1px; !* Position the search icon *!*/
        height: 17px;
        width: 50%; /* Full-width */
        font-size: 10px; /* Increase font-size */
        padding: 0px 0px 0px 0px; /* Add some padding */
        /*border: 1px solid #ddd; !* Add a grey border *!*/
        /*margin-bottom: 15px; !* Add some space below the input *!*/
        align-items: center;
    }

    #button5 {
        /*background-position: 1px 1px; !* Position the search icon *!*/
        height: 17px;
        width: 50%; /* Full-width */
        font-size: 10px; /* Increase font-size */
        padding: 0px 0px 0px 0px; /* Add some padding */
        /*border: 1px solid #ddd; !* Add a grey border *!*/
        /*margin-bottom: 15px; !* Add some space below the input *!*/
        align-items: center;
    }

    #table{
        width: 49%;
        align-items: center;
        margin: auto;
        height: 50%;
        font-size: 10px;
    }
    tr {
        padding: 10px 15px;
    }
</style>

</body>
</html>