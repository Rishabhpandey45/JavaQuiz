package com.javaquiz.model;
public class User { private int id, age; private String name, college, branch;
 public User(int id,String name,String college,int age,String branch){this.id=id;this.name=name;this.college=college;this.age=age;this.branch=branch;}
 public User(String name,String college,int age,String branch){this(0,name,college,age,branch);}
 public int getId(){return id;} public void setId(int id){this.id=id;} public String getName(){return name;} public String getCollege(){return college;} public int getAge(){return age;} public String getBranch(){return branch;}}
