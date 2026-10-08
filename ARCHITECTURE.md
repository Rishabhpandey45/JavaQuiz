# Architecture
Browser -> Servlets -> Service Layer -> DAO Layer -> JDBC -> MySQL
                         |-> QuizTimer Thread
                         |-> synchronized AttemptService
Models: User, Question, Quiz, TimedQuiz
