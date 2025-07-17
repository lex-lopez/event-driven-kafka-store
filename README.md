# Event-Driven Kafka Store

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Kafka-Event%20Streaming-black.svg)](https://kafka.apache.org/)

---

## 📌 Overview
**Event-Driven Kafka Store** demonstrates an **event-driven architecture** using **Apache Kafka** as the messaging backbone for a scalable microservice ecosystem.  
The application showcases:
- **Decoupled Communication** via events.
- **Multiple Consumers** (Order Processor & Email Service).
- **Real-time Notifications** using Kafka as a central message broker.

---

## ✅ Features
- **Event-Driven Design** with Kafka topics.
- **Microservices** for Producers, Consumers, and Email Notifications.
- **Asynchronous Communication** – Event fan-out to multiple services.
- **Fault-Tolerant & Scalable** architecture.
- **Dockerized Environment** for easy setup.
- **Ready for Real-World Use Cases** like e-commerce order processing.

---

## 🏗 Architecture

The system consists of:
- **Producer Service** – Publishes `OrderCreated` events to Kafka.
- **Kafka Broker** – Central event streaming backbone.
- **Consumer Service** – Persists order details into a database.
- **Email Service** – Sends confirmation emails upon order creation.
- **Database** – Stores order data.

---

### 🔍 Mermaid Diagram
```mermaid
flowchart LR
    A[Client / API Request] --> B[Producer Service]
    B -->|Publishes Event| C[(Kafka Topic)]
    C --> D[Consumer Service]
    D -->|Stores Data| E[(Database)]
    C --> F[Email Service]
    F -->|Send Email| G[SMTP / Email Provider]

    classDef svc fill:#0f62fe,stroke:#fff,color:#fff;
    classDef kafka fill:#000000,stroke:#fff,color:#fff;
    class B,D,F svc;
    class C kafka;
