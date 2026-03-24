# Kafka Order Producer

[![GitHub](https://img.shields.io/badge/Java-21-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-green)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-4.1.2-red)](https://kafka.apache.org/)

Продюсер для асинхронной обработки заказов. Принимает REST-запросы и отправляет сообщения в Kafka.

## Функциональность

- REST API для создания заказов
- Отправка сообщений в топик `orders-v2`
- Сериализация в JSON

## API

### Создание заказа

```http
POST http://localhost:8081/orders
Content-Type: application/json

{
    "orderId": "123",
    "product": "book",
    "quantity": 2
}
```

**Ответ:** `200 OK` с текстом "Order sent"

## Сборка

```bash
mvn clean package
```

## Запуск

```bash
java -jar target/order-service-0.0.1-SNAPSHOT.jar
```

Сервис будет доступен на порту 8081.

## Конфигурация

`src/main/resources/application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
      properties:
        spring.json.add.type.headers: true

server:
  port: 8081
```

## Связанные репозитории

| Репозиторий | Описание | Ссылка |
|-------------|----------|--------|
| **Главный репозиторий** | Документация и инфраструктура | [kafka-order-processing](https://github.com/antonmalov/kafka-order-processing) |
| **common-dto** | Общие DTO | [kafka-order-common-dto](https://github.com/antonmalov/kafka-order-common-dto) |
| **consumer** | Консьюмер с ретраями и DLT | [kafka-order-consumer](https://github.com/antonmalov/kafka-order-consumer) |
| **e2e-tests** | E2E тесты | [kafka-order-e2e-tests](https://github.com/antonmalov/kafka-order-e2e-tests) |

## Лицензия

MIT