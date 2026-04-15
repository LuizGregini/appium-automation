# 📱 Appium Automation - Mobile Test Project

## 🎯 Objetivo

Projeto de automação mobile utilizando Appium, estruturado com foco em boas práticas como Page Object Model, reutilização de código e organização em camadas.

## 📌 Sobre o projeto

Este projeto consiste em uma suíte de automação de testes mobile desenvolvida com **Appium** e **Java**, com foco em validar funcionalidades de aplicações Android.
A automação foi construída utilizando boas práticas de mercado, como o padrão **Page Object Model (POM)** e abstrações como DSL.
Tendo em vista que com esses padrões definitivamente melhorar a legibilidade e manutenção dos testes.

---

## 🛠️ Tecnologias e ferramentas utilizadas

* ☕ Java
* 🤖 Appium
* 🌐 Selenium WebDriver
* 🧪 JUnit
* 📦 Maven
* 📱 Android (emulador ou dispositivo físico)
* 🟢 Node.js (necessário para execução do Appium Server, onde o Appium utiliza o protocolo WebDriver)

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
└── runners
    └── RunTestAppium.java
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

Instalar Appium:

```bash
npm install -g appium
```

---

### ▶️ Executando os testes

```bash
mvn clean test
```

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
