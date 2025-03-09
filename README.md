# Controle de Sonda Marciana - API Spring Boot

API para controle de movimentação de uma sonda marciana, desenvolvida em Spring Boot.

## 📋 Descrição

Esta aplicação permite controlar os movimentos de uma sonda em um plano cartesiano através de comandos HTTP. A sonda
inicia na posição (0, 0, N) e pode receber comandos de movimento e rotação.

## 🛠 Tecnologias

- Java 17
- Spring Boot 3.x
- Maven

## ⚙️ Pré-requisitos

- JDK 17 instalado
- Maven 3.8+
- IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

## 🚀 Instalação e Execução

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/mars-rover-springboot.git
   ```
2. **Construir o projeto**
   ```bash 
   mvn clean install 
   ```
3. **Executar a aplicação**
   Via Maven (para ambiente de desenvolvimento):
    ```bash 
    mvn spring-boot:run 
    ```
   Via JAR (para ambiente de produção):
    ```bash 
    java java -jar target/rover-1.0.0.jar
    ```