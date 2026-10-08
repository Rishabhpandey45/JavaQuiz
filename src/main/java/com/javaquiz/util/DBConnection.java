package com.javaquiz.util;
import java.sql.*;
public final class DBConnection { private DBConnection(){} public static Connection getConnection() throws SQLException { String url=System.getenv().getOrDefault("DB_URL","jdbc:mysql://localhost:3306/java_quiz"); String user=System.getenv().getOrDefault("DB_USER","root"); String pass=System.getenv().getOrDefault("DB_PASSWORD",""); return DriverManager.getConnection(url,user,pass); } }
