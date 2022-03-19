# Randomity BE application

1) POST http://localhost:8080/registration  
Регистрация. Поля: username, email, password
2) POST http://localhost:8080/login
Авторизация. Поля: username, password
3) GET http://localhost:8080/getIntegers
Запрос к рандом.орг. Поля: min, max, count, replacement (TRUE если можно повторяющиеся, иначе FALSE)
4) GET http://localhost:8080/generators
Показать все существующие генераторы. Поля: -
5) GET http://localhost:8080/generators/my
Показать доступные пользователю генераторы. Поля: -
6) POST http://localhost:8080/generators/buy
Добавить пользователю генератор. Поля: idOfGenerator
7) POST http://localhost:8080/generators/new
Создать новый генератор (только от ADMIN). Поля: nameOfGenerator