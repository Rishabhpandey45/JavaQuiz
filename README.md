# Java Quiz — Java Web-Based Project

A Java Servlet + JDBC + MySQL upgrade of the original Java Quiz browser project.

## Rubric-focused features
- Problem understanding and layered solution design
- Core Java: encapsulation, inheritance, polymorphism, interfaces, collections, generics and exception handling
- Multithreading: `QuizTimer extends Thread`
- Synchronization: synchronized timer state and synchronized attempt scoring
- Database operation classes using DAO/repository interfaces
- JDBC with `PreparedStatement` and try-with-resources
- Jakarta Servlets for user registration, question retrieval and quiz submission
- MySQL persistence for users, topics, questions and attempts
- Original quiz workflow retained: topic selection, mixed quiz, 30-second-per-question timing, previous/next navigation, scoring and skipped answers

## Project structure
```text
src/main/java/com/javaquiz/
├── model/        User, Question, Quiz, TimedQuiz
├── dao/          UserDAO, QuestionDAO, AttemptDAO
├── dao/api/      repository interfaces
├── service/      AttemptService, QuizTimer
├── service/api/  ScoringService
├── servlet/      UserServlet, QuizServlet, SubmitServlet
├── exception/    QuizException
└── util/         DBConnection
src/main/webapp/  frontend + WEB-INF/web.xml
sql/              schema.sql + seed.sql
```

## Requirements
- JDK 17+
- Maven 3.9+
- MySQL 8+
- Apache Tomcat 10.1+

## Database setup
1. Start MySQL.
2. Run `sql/schema.sql`.
3. Run `sql/seed.sql`.
4. Configure `DB_URL`, `DB_USER`, and `DB_PASSWORD` if your credentials differ from the defaults.

## Build and run
```bash
mvn clean package
```
Deploy `target/java-quiz.war` to Tomcat 10.1+ and open:
`http://localhost:8080/java-quiz/`

## JDBC design
All SQL is isolated in DAO classes. Database resources use try-with-resources and parameterized `PreparedStatement`s.

## Important testing note
The project source has been statically checked for core Java compilation in this environment. Full Maven/Tomcat/MySQL integration testing requires those external runtime tools and a live MySQL database.

## Rubric mapping
- **Problem Understanding & Solution Design:** layered Browser → Servlet → Service → DAO → JDBC → MySQL architecture.
- **Core Java Concepts:** model classes, inheritance, polymorphism, interfaces, collections, generics and custom exceptions.
- **Database Integration (JDBC):** `DBConnection`, repository interfaces and DAO implementations.
- **Servlets & Web Integration:** `UserServlet`, `QuizServlet`, `SubmitServlet` and frontend `fetch()` calls.
- **Multithreading & Synchronization:** `QuizTimer` background thread and synchronized timer/scoring methods.
