# OAuth2 Integration with GitHub & Google

A Spring Boot web application that integrates **OAuth2 Login** using **Google** and **GitHub**, allowing users to register, log in, and manage their profile (display name & bio).  
This project uses **Spring Boot**, **Spring Security**, **Spring Data JPA**, and **Thymeleaf** for rendering the frontend.

---

## 🧩 Features

- ✅ OAuth2 login with **Google** and **GitHub**
- ✅ Automatic user creation on first login
- ✅ Persistent user data using **JPA/H2 Database**
- ✅ Profile page with update functionality
- ✅ CSRF protection & secure logout
- ✅ H2 in-memory DB for development
- ✅ Ready for MySQL/PostgreSQL migration

---

## ⚙️ Technologies Used

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot 3.x, Spring Security (OAuth2 Client), Spring Data JPA |
| **Database** | H2 (In-memory for dev), MySQL/PostgreSQL (optional) |
| **Frontend** | Thymeleaf (server-rendered HTML) |
| **Build Tool** | Maven |
| **Language** | Java 17+ |

---

## 🧠 Architecture Diagram

```
                    ┌────────────────────────────┐
                    │        Web Browser         │
                    │ (Thymeleaf / HTML Views)   │
                    └──────────────┬─────────────┘
                                   │
                                   ▼
                    ┌────────────────────────────┐
                    │   Spring Boot Application  │
                    │────────────────────────────│
                    │ Controllers:               │
                    │  • HomeController          │
                    │  • ProfileController       │
                    │                            │
                    │ Services:                  │
                    │  • CustomOAuth2UserService │
                    │                            │
                    │ Security:                  │
                    │  • OAuth2 Login Config     │
                    │  • CSRF, Logout, H2 Rules  │
                    │                            │
                    │ Persistence:               │
                    │  • UserRepository          │
                    │  • AuthProviderRepository  │
                    └──────────────┬─────────────┘
                                   │
                                   ▼
                    ┌────────────────────────────┐
                    │       Database Layer       │
                    │   (H2 / MySQL / PostgreSQL)│
                    │ Tables:                    │
                    │  • users                   │
                    │  • auth_providers          │
                    └────────────────────────────┘
```

---

## 🗂️ Directory Structure

```
src/
 ├─ main/java/edu/cit/ryanbebiro/oauth2integration/
 │   ├─ Oauth2integrationApplication.java
 │   ├─ SecurityConfig.java
 │   ├─ controller/
 │   │   ├─ HomeController.java
 │   │   └─ ProfileController.java
 │   ├─ model/
 │   │   ├─ User.java
 │   │   └─ AuthProvider.java
 │   ├─ repository/
 │   │   ├─ UserRepository.java
 │   │   └─ AuthProviderRepository.java
 │   └─ service/
 │       └─ CustomOAuth2UserService.java
 ├─ main/resources/
 │   ├─ templates/
 │   │   ├─ home.html
 │   │   └─ profile.html
 │   └─ application.properties
 └─ test/
```

---

## 🚀 How to Run Locally

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/oauth2integration.git
cd oauth2integration
```

### 2️⃣ Configure OAuth2 Credentials
Create OAuth credentials for:
- **Google** → [Google Cloud Console](https://console.cloud.google.com/)
- **GitHub** → [GitHub Developer Settings](https://github.com/settings/developers)

Then set them as **environment variables**:

#### Windows (PowerShell)
```bash
setx GOOGLE_CLIENT_ID "your-google-client-id"
setx GOOGLE_CLIENT_SECRET "your-google-client-secret"
setx GITHUB_CLIENT_ID "your-github-client-id"
setx GITHUB_CLIENT_SECRET "your-github-client-secret"
```

#### macOS/Linux (bash)
```bash
export GOOGLE_CLIENT_ID=your-google-client-id
export GOOGLE_CLIENT_SECRET=your-google-client-secret
export GITHUB_CLIENT_ID=your-github-client-id
export GITHUB_CLIENT_SECRET=your-github-client-secret
```

---

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```

Then visit:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 🧑‍💻 Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/` | Home page with login buttons |
| `GET` | `/profile` | View authenticated user profile |
| `POST` | `/profile` | Update display name and bio |
| `GET` | `/logout` | Logout and redirect home |
| `GET` | `/h2-console` | Access H2 database console (dev only) |

---

## 🧱 Database Schema

**User Table (`users`)**
| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key |
| email | VARCHAR | Unique email |
| display_name | VARCHAR | User’s display name |
| avatar_url | VARCHAR | Profile image |
| bio | TEXT | Optional bio |
| created_at | DATETIME | Created timestamp |
| updated_at | DATETIME | Updated timestamp |

**AuthProvider Table (`auth_providers`)**
| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key |
| provider | VARCHAR | GOOGLE or GITHUB |
| provider_user_id | VARCHAR | Provider user ID |
| provider_email | VARCHAR | Email from provider |
| user_id | FK | Links to users.id |

---

## 🧩 Example Users
| Provider | Email | Display Name |
|-----------|--------|--------------|
| Google | johndoe@gmail.com | John Doe |
| GitHub | octocat@github.com | The Octocat |

---

## 🧠 Notes

- H2 Console → [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- Default JDBC URL: `jdbc:h2:mem:testdb`
- Login using your Google or GitHub account — new accounts will be auto-created.

---

## 👨‍🏫 Instructor Access

Add **Sir Eric Revilleza** as a collaborator:
- GitHub: [https://github.com/citu-ericrevilleza](https://github.com/citu-ericrevilleza)
- Email: `citu.ericrevilleza@gmail.com`

---

## 📽️ Submission Requirements

- ✅ GitHub Repository Link  
- ✅ Demo Video Link  
- ✅ Architecture Diagram (included above or external file)

---

## 🏆 Rubric

| Criteria | Points |
|-----------|--------|
| Integration Correctness (Google & GitHub) | 35 |
| User Provisioning & Persistence | 20 |
| Security & Access Control | 15 |
| Profile Module | 15 |
| Architecture Docs & Code Quality | 15 |
| **Total** | **100** |

---

### 🧾 Author
**Ryan Bebiro**  
`edu.cit.ryanbebiro.oauth2integration`
section:G2
