# 🧪 Automation Testing Framework: Web UI & API

Framework ini dibuat untuk melakukan pengujian **Web UI** dan **API** dalam satu repositori, menggunakan pendekatan **BDD (Behavior-Driven Development)** dengan **Cucumber** dan **Gherkin**.

---

## 🔧 Tools & Libraries

- Java 23
- Gradle
- Cucumber
- Selenium WebDriver (untuk Web UI)
- Rest Assured (untuk API)
- JUnit
- GitHub Actions (CI/CD)
- Gherkin syntax (`.feature`)

---

## 📁 Struktur Project

```
automation-framework/
├── build.gradle
├── settings.gradle
├── README.md
├── .github/workflows/
│   └── main.yml
├── src/test/java/
│   ├── api/
│   │   ├── stepdefinitions/
│   │   └── pages/
│   ├── web/
│   │   ├── stepdefinitions/
│   │   └── pages/
├── src/test/resources/
│   ├── api_features/
│   │   └── user.feature
│   ├── web_features/
│   │   └── login.feature
```

---

## 🚀 Cara Menjalankan Test

### Jalankan semua test (Web UI & API)
```bash
./gradlew clean testApi testWeb
```

### Jalankan hanya test Web UI
```bash
./gradlew testWeb
```

### Jalankan hanya test API
```bash
./gradlew testApi
```

---

## 📊 Lokasi Report

Setelah test selesai, report berada di:
```
build/reports/tests/
├── testWeb/
│   ├── web-cucumber.html
│   └── web-cucumber.json
├── testApi/
│   ├── api-cucumber.html
│   └── api-cucumber.json
```

---

## ⚙️ GitHub Actions CI

Workflow otomatis dijalankan saat:
- Push ke branch `main`
- Pull request ke `main`

Lokasi workflow:
```
.github/workflows/main.yml
```

Setelah pipeline selesai, hasil test tersedia sebagai **Artifacts** di tab **Actions** di GitHub.

---

## 🧪 Fitur Test

### 🌐 Web UI Test (https://www.saucedemo.com/)
- Login dengan kredensial valid
- Validasi login gagal (password salah / user tidak ada)
- Logout setelah login berhasil
- Tambah item ke cart
- Validasi item muncul di cart

### 🔗 API Test (https://reqres.in/)
- Get user
- Create user
- Update user
- Delete user

---
