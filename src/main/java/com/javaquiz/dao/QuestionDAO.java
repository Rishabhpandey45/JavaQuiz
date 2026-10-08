package com.javaquiz.dao;
import com.javaquiz.model.Question; import com.javaquiz.util.DBConnection; import java.sql.*; import com.javaquiz.dao.api.QuestionRepository; import java.util.*;
public class QuestionDAO implements QuestionRepository { public List<Question> findByTopic(int topicId) throws SQLException {List<Question> out=new ArrayList<>(); String sql="SELECT * FROM questions WHERE topic_id=? ORDER BY question_id"; try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,topicId);try(ResultSet r=p.executeQuery()){while(r.next())out.add(map(r));}}return out;}
 public List<Question> findMixed(int limit) throws SQLException {List<Question> out=new ArrayList<>();String sql="SELECT * FROM questions ORDER BY RAND() LIMIT ?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,limit);try(ResultSet r=p.executeQuery()){while(r.next())out.add(map(r));}}return out;}
 public List<Question> findByIds(List<Integer> ids) throws SQLException {
  if (ids == null || ids.isEmpty()) return new ArrayList<>();
  String placeholders = String.join(",", Collections.nCopies(ids.size(), "?"));
  List<Question> out = new ArrayList<>();
  String sql = "SELECT * FROM questions WHERE question_id IN (" + placeholders + ")";
  try (Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)) {
    for (int i=0;i<ids.size();i++) p.setInt(i+1, ids.get(i));
    try (ResultSet r=p.executeQuery()) { while(r.next()) out.add(map(r)); }
  }
  Map<Integer,Question> byId = new HashMap<>();
  for (Question q: out) byId.put(q.getId(), q);
  List<Question> ordered = new ArrayList<>();
  for (Integer id: ids) if (byId.containsKey(id)) ordered.add(byId.get(id));
  return ordered;
 }
 private Question map(ResultSet r)throws SQLException{return new Question(r.getInt("question_id"),r.getInt("topic_id"),r.getString("question_text"),r.getString("option_a"),r.getString("option_b"),r.getString("option_c"),r.getString("option_d"),r.getInt("correct_option"),r.getString("explanation"));}}
