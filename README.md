Задание:

Необходимо разработать spring boot приложение.
 1. Технологии: spring, spring mvc, hibernate, spring boot, для хранения можно использовать любую бд (Postgres, Oracle).
 2. В базе данных хранится информация о клиентах и их счетах. У одного клиента может быть несколько счетов.
 3. Необходимо иметь возможность по rest получать список клиентов (/clients) клиента по его инн(/clients?inn=1234),
 сумму на всех счётах клиента в рублях  (/amount?inn=123)
 4. Кроме этого необходимо в лог писать время выполнения каждого rest метода.
 
 
Скрипт для создания и заполнения таблиц:
 
CREATE TABLE CLIENT ( 
   inn VARCHAR(20) NOT NULL,
   name VARCHAR(20) NOT NULL
);

CREATE TABLE ACCOUNT(
   id VARCHAR(4) NOT NULL,
   inn VARCHAR(20) NOT NULL,
   balance VARCHAR(20) NOT NULL,
   accountNumber VARCHAR(20) NOT NULL
);

INSERT INTO CLIENT VALUES ('1', 'Name Surname'); 
INSERT INTO CLIENT VALUES ('2', 'John Surname'); 
INSERT INTO CLIENT VALUES ('3', 'Ken Surname'); 

INSERT INTO ACCOUNT VALUES ('1','1', '1000', '8888'); 
INSERT INTO ACCOUNT VALUES ('2','2', '500', '5745'); 
INSERT INTO ACCOUNT VALUES ('3','3', '400.5', '5555'); 
INSERT INTO ACCOUNT VALUES ('4','1', '400.5', '3434'); 
INSERT INTO ACCOUNT VALUES ('5','2', '400.5', '5785'); 
INSERT INTO ACCOUNT VALUES ('6','3', '400.5', '1234'); 

COMMIT;

Запуск приложения:
1. Обновить настройки БД в файле application.yml (Path - sber\src\main\resources\application.yml).
3. Создать и заполнить таблицы (при необходимости обновить значения в файле application.yml).
2. Запустить выполнения метода Main класса Application в IDE.

Пример GET запроса (поиск клиента по ИНН):
http://localhost:8080/clients?inn=X , X - номер ИНН, по которому выполняется поиск клиента.
