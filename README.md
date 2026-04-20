# 📱 Appium Automation - Mobile Test Project

Suíte de automação de testes mobile utilizando Appium, com geração de relatórios avançados via Allure e evidências automáticas em falhas.

## 🎯 Objetivo

Projeto de automação mobile utilizando Appium, estruturado com foco em boas práticas como Page Object Model, reutilização de código e organização em camadas.

## 📌 Sobre o projeto

Este projeto consiste em uma suíte de automação de testes mobile desenvolvida com **Appium** e **Java**, com foco na validação de funcionalidades em aplicações Android.

A automação foi construída utilizando boas práticas de mercado, como o padrão **Page Object Model (POM)** e abstrações como DSL, garantindo maior legibilidade, reutilização e facilidade de manutenção dos testes.

Além disso, o projeto conta com integração ao **Allure Reports**, permitindo a geração de relatórios detalhados, com evidências visuais (screenshots) e informações completas sobre a execução dos testes, tanto em casos de sucesso quanto de falha.

---

## 🛠️ Tecnologias e ferramentas utilizadas

* <p align="mid">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="20"/>
  Java
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/f04c4523-2c9e-4549-b1be-d47e0ccc215d" width="20"/>
  Appium
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/00aaeb9b-5347-453f-9d76-41f628e0eef9" width="20"/>
  Selenium WebDriver
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/7f08d15f-ea25-470e-8166-107b668a3119" width="20"/>
  JUnit 5
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/0d4cbba8-c416-452f-8e6b-9a3d12ed079e" width="20"/>
  Maven
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/a59a8fa0-6e78-4707-af50-f030575b909b" width="20"/>
  Allure reports
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/9cb99b7f-00d5-4bcb-adaa-c24af4e31b95" width="20"/>
  Android (emulador ou dispositivo físico)
</p>

* <p align="mid">
  <img src="https://github.com/user-attachments/assets/90bf6de5-1b8a-456f-9b4c-707fb8eaa4cc" width="20"/>
  Node.js (runtime utilizado pelo Appium Server)
</p>

---

## 📂 Estrutura do projeto

```bash
src/test/java
│
├── core
│   ├── BasePage.java
│   ├── BaseTest.java
│   ├── DriverFactory.java
│   └── DSL.java
│
├── helpers
│   └── ContaHelper.java
│
├── hooks
│   └── Hook.java
│
├── page
│   ├── AbasPage.java
│   ├── AlertasPage.java
│   ├── FormularioPage.java
│   ├── MenuPage.java
│   ├── SwipePage.java
│   └── ... (demais páginas)
│
├── test
│   ├── AbasTest.java
│   ├── AlertasTest.java
│   ├── FormularioTest.java
│   ├── SwipeTest.java
│   └── ... (demais testes)
│
└── utils
    └── ScreenshotWatcher.java
```

---

## 🧠 Arquitetura e padrões utilizados

### 🔹 Page Object Model (POM)

Cada tela da aplicação é representada por uma classe, centralizando os elementos e ações.
Assim promovendo reutilização de métodos e facilitando a manutenção dos testes. ⭐

### 🔹 DSL (Domain Specific Language)

Camada de abstração para facilitar a escrita dos testes e reduzir duplicação de código.

### 🔹 Base Test

Classe base responsável por inicializar e finalizar o driver.

### 🔹 Driver Factory

Gerencia a criação e configuração do Appium Driver.
Sendo assim com um único driver criado ele é compartilhado entre testes e páginas, evitando a necessidade de instanciar new AppiumDriver() em cada classe.

---

## 🚀 Como executar o projeto

### 📋 Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

* Java (JDK 8+)
* Maven
* Node.js
* Appium (global)

---

### Instalação do Allure

```bash
choco install allure
```

### Instalação do Appium

```bash
npm install -g appium
```

---

### ▶️ Executando toda a Suíte de teste

```bash
mvn clean test
```

### GIF da execução do teste:
<img width="1293" height="995" alt="lando-norris" src="https://github.com/user-attachments/assets/c13efa52-7fa2-4618-b1c1-a70411eb6f6e" />



---

## 📊 Relatórios com Allure

O Allure Report é utilizado para gerar uma visão executiva e técnica dos resultados:

Após a execução dos testes, execute o comando abaixo para gerar o relatório e abri-lo em seu navegador:

```bash
allure serve allure-results
```

### Resultados apresentados:

Esse é Overview apresentado ao entrar na página inicial após executado a Suíte de testes:


<img width="1919" height="948" alt="image" src="https://github.com/user-attachments/assets/fce5e101-b171-4490-b65f-232914e64d7e" />

<br>

Já dentro do menu Suíte, é possível visualizar cada classe de teste executada, incluindo evidências em imagem tanto para testes aprovados quanto para falhos, além das respectivas informações detalhadas de retorno:

<img width="1919" height="948" alt="image" src="https://github.com/user-attachments/assets/a4c67542-419f-4b44-a08f-f0de84d55c0e" />

---

## 📱 Funcionalidades automatizadas

* ✅ Login na aplicação
* ✅ Criação de contas
* ✅ Exclusão de contas
* ✅ Navegação entre telas
* ✅ Navegação e interação com páginas WebView
* ✅ Interações com elementos:

  * Cliques em geral
  * Swipe
  * Drag and Drop
  * Inputs de formulário
  * SeekBar
  * Scroll de listas

---

## ⚙️ Configuração do ambiente

* Necessário configurar Android SDK
* Utilizar um emulador Android ou dispositivo físico
* Garantir que o Appium Server esteja rodando

---

## 📌 Observações importantes

* O projeto utiliza arquivos `.apk` para execução dos testes, somente uma resalva que para utilizar a funcionalidade de WebView é necessário utilizar a apk CTAppium_1_2
* Algumas dependências e drivers podem variar conforme o ambiente
* Recomenda-se uso de `.gitignore` para evitar versionamento de arquivos desnecessários

---

## 👨‍💻 Autor

**Luiz Gustavo**

---




