# SauceDemo Selenium Cucumber Framework

# 🧪 SauceDemo Selenium Cucumber Test Automation

This project is an end-to-end test automation framework built using **Selenium WebDriver, Cucumber (BDD), and Java**.  
It validates core user flows of the SauceDemo web application with a clean and scalable test architecture.

---

## 🎯 Project Purpose

The goal of this project is to:

- Automate critical user scenarios (login, cart, checkout)
- Apply **Behavior-Driven Development (BDD)** practices
- Build a **maintainable and scalable test framework**
- Simulate real-world automation testing workflows

---

## ⚙️ Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit**
- **Maven**
- **ChromeDriver**

---

## 🧱 Framework Architecture

The project follows the **Page Object Model (POM)** design pattern:

src
├── pages              # Page classes (LoginPage, ProductsPage, CheckoutPage)
├── stepdefinitions    # Step definitions for Cucumber
├── runners            # Test runner
├── utils              # DriverFactory and utilities
└── resources
└── features       # Gherkin feature files


---

## 🧪 Test Scenarios

### ✅ Login Tests
- Successful login with valid credentials
- Unsuccessful login with invalid credentials

### 🛒 Cart Flow
- Add product to cart
- Verify product in cart

### 💳 Checkout Flow
- Complete checkout process
- Validate successful order completion

---

## ▶️ How to Run Tests

Run all tests using Maven:

```bash
mvn clean test
