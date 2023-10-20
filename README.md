# Описание
Данная реализация REST API вычисляет частоту символов по заданной строке.


# Запуск приложения
Перейдите в каталог проекта:
1. cd t1ConsaltingTest
2. Введите команду ./mvnw clean package
3. java -jar target/t1ConsaltingTest-0.0.1-SNAPSHOT.jar


# GET Request
http://localhost:8080/calculate

Запрос должен содержать параметр запроса input 
Пример:
http://localhost:8080/calculate?input=aaaddbd
Запрос вернет JSON: 
{
"a": 3,
"d": 3,
"b": 1
}
