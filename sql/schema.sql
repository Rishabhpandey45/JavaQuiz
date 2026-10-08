CREATE DATABASE IF NOT EXISTS java_quiz;
USE java_quiz;
CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  college VARCHAR(150) NOT NULL,
  age INT NOT NULL,
  branch VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS topics (
  topic_id INT PRIMARY KEY AUTO_INCREMENT,
  topic_name VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS questions (
  question_id INT PRIMARY KEY AUTO_INCREMENT,
  topic_id INT NOT NULL,
  question_text TEXT NOT NULL,
  option_a VARCHAR(255) NOT NULL,
  option_b VARCHAR(255) NOT NULL,
  option_c VARCHAR(255) NOT NULL,
  option_d VARCHAR(255) NOT NULL,
  correct_option INT NOT NULL,
  explanation TEXT,
  CONSTRAINT fk_question_topic FOREIGN KEY(topic_id) REFERENCES topics(topic_id)
);
CREATE TABLE IF NOT EXISTS attempts (
  attempt_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  topic_id INT NULL,
  score INT NOT NULL,
  total INT NOT NULL,
  correct_count INT NOT NULL,
  wrong_count INT NOT NULL,
  skipped_count INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY(user_id) REFERENCES users(user_id),
  FOREIGN KEY(topic_id) REFERENCES topics(topic_id)
);
