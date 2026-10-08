package com.javaquiz.model;
public class TimedQuiz extends Quiz { private final int secondsPerQuestion; public TimedQuiz(java.util.List<Question> q,int secondsPerQuestion){super(q);this.secondsPerQuestion=secondsPerQuestion;} public int getTotalSeconds(){return getQuestions().size()*secondsPerQuestion;} }
