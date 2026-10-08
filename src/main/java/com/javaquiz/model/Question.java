package com.javaquiz.model;
public class Question { private int id,topicId,correctOption; private String text,a,b,c,d,explanation;
 public Question(int id,int topicId,String text,String a,String b,String c,String d,int correctOption,String explanation){this.id=id;this.topicId=topicId;this.text=text;this.a=a;this.b=b;this.c=c;this.d=d;this.correctOption=correctOption;this.explanation=explanation;}
 public int getId(){return id;} public int getTopicId(){return topicId;} public String getText(){return text;} public String[] getOptions(){return new String[]{a,b,c,d};} public int getCorrectOption(){return correctOption;} public String getExplanation(){return explanation;}}
