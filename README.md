# Randomity BE application

1) POST http://localhost:8080/registration  
Регистрация. Поля: username, email, password   
Ответ: username, email, role, isConfirmed
2) POST http://localhost:8080/login
Авторизация. Поля: username, password  
Отве: username, email, role, isConfirmed
3) GET http://localhost:8080/getIntegers
Запрос к рандом.орг. Поля: min, max, count, replacement (TRUE если можно повторяющиеся, иначе FALSE)  
Ответ: Массив int
4) GET http://localhost:8080/generators
Показать все существующие генераторы. Поля: -  😇  
Ответ: List<{id, nameOfGenerator}>
5) GET http://localhost:8080/generators/my
Показать доступные пользователю генераторы. Поля: -  
Ответ: List<{id, nameOfGenerator}>
6) POST http://localhost:8080/generators/buy
Добавить пользователю генератор. Поля: idOfGenerator  
Ответ: Http.Status.Ok
7) POST http://localhost:8080/generators/new
Создать новый генератор (только от ADMIN). Поля: nameOfGenerator  
Ответ: id, nameOfGenerator