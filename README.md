# warren-buffett

## Description

This project is a Spring Web Application used to publish messages in specific queues into RabbitMQ message broker.

Project that consumes this queues is the [ewallet](https://github.com/estevaowat/ewallet)

The goal for this project is to study AMQP protocol and implement using Spring AMQP.

## Pre-requisites

- Java 17
- Gradle 7.3.3
- Docker

## Usage

```bash
git clone https://github.com/estevaowat/warren-buffet
cd warren-buffet
gradle clean build
gradle bootrun
```

### Technologies used

- Spring
    - Spring Web
    - Spring AMQP
    - Spring JPA
- Liquibasge
- Junit 5 (Jupiter API)
- RabbitMQ