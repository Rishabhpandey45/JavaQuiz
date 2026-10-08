package com.javaquiz.model;
import java.util.*;
public class Quiz { private final List<Question> questions; private final Map<Integer,Integer> answers=new HashMap<>();
 public Quiz(List<Question> questions){this.questions=new ArrayList<>(questions);} public List<Question> getQuestions(){return Collections.unmodifiableList(questions);} public void answer(int questionId,int option){answers.put(questionId,option);} public Map<Integer,Integer> getAnswers(){return Collections.unmodifiableMap(answers);}}
