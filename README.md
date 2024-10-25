## Настройка Kafka

#### PATH=D:\Programs\kafka

1) В файле $PATH$\config\server.properties установить log.dirs=$PATH$/kafka-logs

2) В файле $PATH$\config\zookeeper.properties установить dataDir=$PATH$/zookeeper-data

3) $$Запуск Zookeeper$$ В отдельном $cmd$ перейти в cd $PATH$ и ввести .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

4) $$Запуск Kafka$$ В отдельном $cmd$ перейти в cd $PATH$ и ввести .\bin\windows\kafka-server-start.bat .\config\server.properties

5) Создание топиков (пример): kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partition 1 --topic test

## Команды для работы с Kafka

### 1. Producer (Отправка сообщений в Kafka)
Для отправки данных в Kafka, используйте следующую команду. Она отправит сообщения в топик `test` через указанный Kafka broker.

```bash
kafka-console-producer.bat --broker-list localhost:9092 --topic test
```
#### Пример данных:
 Вы можете отправить в топик test следующие JSON-сообщения:
````
"Name": "John", "Age": "31", "Gender": "Male"}
{"Name": "Emma", "Age": "27", "Gender": "Female"}
{"Name": "Ronald", "Age": "17", "Gender": "Male"}
````
### 2. Consumer (Чтение сообщений из Kafka)
 Для того чтобы прочитать все сообщения из топика test, начиная с самого первого, используйте следующую команду:
````
 kafka-console-consumer.bat --topic test --bootstrap-server localhost:9092 --from-beginning
````
### 3. Остановка ZooKeeper
Для корректного завершения работы ZooKeeper, выполните следующую команду:
```
.\bin\windows\zookeeper-server-stop.bat .\config\zookeeper.properties
```
### 4. Остановка Kafka
Чтобы остановить Kafka-брокер, выполните следующую команду:
````
.\bin\windows\kafka-server-stop.bat .\config\server.properties
````