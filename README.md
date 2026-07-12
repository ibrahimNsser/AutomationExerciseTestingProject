# 🚀 Automation Exercise Testing Project

This is a professional E-commerce Automation Testing Framework built to test the **Automation Exercise** website. The framework is designed using the **Page Object Model (POM)** pattern to ensure clean, maintainable, and scalable test scripts.

---

## 🛠️ Tech Stack & Tools Used
* **Language:** Java (JDK 25)
* **Automation Tool:** Selenium WebDriver (v4.43.0)
* **Testing Framework:** TestNG
* **Build Tool:** Maven
* **Data-Driven Testing:** Apache POI (Excel Reading) & Properties Files
* **Design Pattern:** Page Object Model (POM)

---

## 📁 Project Structure Highlights
* `src/test/java/tests`: Contains all test scenarios(e.g., Login, Registration, Add Products to cart, and Place Order, among other end-to-end scenarios).
* `src/test/java/pages`: Contains WebElements and actions using Page Object Model.
* `src/test/java/data`: Contains data-driven utilities for reading Excel (`.xlsx`) and Properties files.

---

## 🚀 How To Run The Tests

You can run the automation suite in two ways:

### 1. Via TestNG Suite (Recommended)
Right-click on the `TestingSuite.xml` file in the root directory and select:
`Run As` -> `TestNG Suite`

### 2. Via Maven Command Line
Open your terminal/command prompt in the project root folder and run:
```bash
mvn clean test
