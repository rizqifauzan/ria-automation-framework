# Automation Testing Framework: Web UI & API

Automation framework ini dibuat untuk melakukan pengujian **Web UI** dan **API** dalam satu repositori, menggunakan pendekatan **Behavior-Driven Development (BDD)** dengan **Cucumber** dan **Gherkin**.

# Tools & Libraries

- **Java**
- **Gradle**
- **Cucumber**
- **Selenium WebDriver** (untuk Web UI testing)
- **Rest Assured** (untuk API testing)
- **JUnit**
- **GitHub Actions** (CI/CD)
- **Gherkin syntax** (untuk feature file)

# Struktur Project

automation-framework/
├── build.gradle
├── settings.gradle
├── README.md
├── .github/workflows/
│ └── ci.yml (GitHub Actions Workflow)
├── src/test/java/
│ ├── api/
│ │ ├── stepdefinitions/
│ │ └── pages/
│ ├── web/
│ │ ├── stepdefinitions/
│ │ └── pages/
├── src/test/resources/
│ ├── api_features/
│ │ └── user.feature
│ ├── web_features/
│ │ └── login.feature

# Cara Menjalankan Test

### 1. Jalankan semua test (Web UI & API)
```bash
./gradlew clean test

Jalankan hanya test @web
./gradlew testWeb

Jalankan hanya test @api
./gradlew testApi

# Report Test
build/reports/tests/
├── testWeb/
│   ├── web-cucumber.html
│   └── web-cucumber.json
├── testApi/
    ├── api-cucumber.html
    └── api-cucumber.json

# GitHub Actions
Test akan otomatis dijalankan melalui GitHub Actions pada:
Manual trigger (via tab Actions)
Setiap kali terjadi Pull Request
File workflow CI berada di:
.github/workflows/ci.yml

# Fitur Test Web UI (menggunakan saucedemo.com)
- Login dengan kredensial valid
- Validasi login gagal (password salah & user tidak ada)
- Logout setelah login berhasil
- Menambahkan item ke cart
- Validasi item muncul di cart

# Fitur Test API (menggunakan Reqres.in)
- Get user
- Create user
- Update user
- Delete user








