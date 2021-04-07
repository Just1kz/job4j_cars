# job4j_cars
[![Build Status](https://travis-ci.org/Just1kz/job4j_cars.svg?branch=master)](https://travis-ci.org/Just1kz/job4j_cars)
[![codecov](https://codecov.io/gh/Just1kz/job4j_cars/branch/master/graph/badge.svg)](https://codecov.io/gh/Just1kz/job4j_cars)

Добро пожаловать на площадку с объявлениями о продаже автомобилей.
Данное приложение позволяет ознакомится с объявлениями, устанавливая разные фильтры, 
а также самостоятельно разместить объявление о продаже.

В данном проекте использовались следующие технологии:
- Servlets (работа с сессиями и атрибутами)
- JSP (+JSTL)
- Simple HTML/JS(JQueue|Ajax)/CSS
- Hibernate (HQL) + PostgreSQL
- Apache Tomcat (локальный запуск)
- OOP
- MVC Pattern
- Mockito/JUnit4
- slf4j/log4j
- Travis CI / CodeCov / CheckStyle

Функциональность приложения предусматривает:

- Аутентификацию и регистрацию мользователей (валидацию наличия заполненных полей)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img.png)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_1.png)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_2.png)
  
- Общий список объявлений
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_3.png)
    
- Различные фильтры (Все/Не проданные/Свои объявления/С фото/За последний день)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_4.png)

- Отдельный фильтр по маркам автомобилей (+валидация)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_5.png)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_6.png)  
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_13.png)

- Возможность отметить машину как проданную (с учётом валидации автора объявления) указав ID объявления (доступное в общей информации)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_7.png)  
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_8.png)  
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_9.png)  
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_10.png)
    
- Возможность разместить своё объявление (с возможностью загрузить фото на сервер и валидацией заполнения полей)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_11.png)
![ScreenShot](./src/main/java/ru/job4j/cars/images/img_12.png)
