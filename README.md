# Event-Driven Kafka Store

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Kafka-Event%20Streaming-black.svg)](https://kafka.apache.org/)

---

## 📌 Overview
**Event-Driven Kafka Store** is a microservice-based application that demonstrates an **event-driven architecture** using **Apache Kafka** as the messaging backbone.  
The goal is to showcase **decoupled communication**, **asynchronous processing**, and **real-time data flow** between producers and consumers in a scalable system.

---

## ✅ Features
- **Event-Driven Design** – Fully based on publish-subscribe architecture using Kafka.
- **Microservices Pattern** – Producer and Consumer services built with **Spring Boot**.
- **Scalable Messaging** – Leverages Kafka topics for horizontal scaling.
- **Fault-Tolerant** – Resilient to failures using **idempotent consumers** and **retries**.
- **Configurable** – Easy to extend for any domain (e.g., e-commerce, inventory, billing).

---

## 🏗 Architecture

The system consists of:
- **Producer Service** – Publishes events to Kafka topics (e.g., `store-events`).
- **Kafka Broker** – Acts as the messaging backbone.
- **Consumer Service** – Subscribes to the topic and processes events.
- **Database Layer** – Stores processed events for persistence.

### 🔍 Mermaid Diagram
```mermaid
flowchart LR
    A[Client / API Request] --> B[Producer Service]
    B -->|Publishes Event| C[(Kafka Topic)]
    C --> D[Consumer Service]
    D -->|Processes & Stores| E[(Database)]
    
    classDef svc fill:#0f62fe,stroke:#fff,color:#fff;
    classDef kafka fill:#000000,stroke:#fff,color:#fff;
    class B,D svc;
    class C kafka;
