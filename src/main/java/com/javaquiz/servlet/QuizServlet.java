package com.javaquiz.servlet;

import com.javaquiz.dao.QuestionDAO;
import com.javaquiz.model.Question;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

/** Returns quiz questions from MySQL as JSON. */
@WebServlet("/api/questions")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String mixed = req.getParameter("mixed");
            String topicParam = req.getParameter("topicId");
            List<Question> qs;
            if ("true".equalsIgnoreCase(mixed)) {
                qs = new QuestionDAO().findMixed(20);
            } else {
                if (topicParam == null || topicParam.isBlank()) throw new IllegalArgumentException("topicId is required");
                qs = new QuestionDAO().findByTopic(Integer.parseInt(topicParam));
            }
            res.setContentType("application/json;charset=UTF-8");
            res.getWriter().print(toJson(qs));
        } catch (NumberFormatException e) {
            res.sendError(400, "Invalid topic ID.");
        } catch (Exception e) {
            res.sendError(500, "Unable to load questions.");
        }
    }

    private String esc(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }

    private String toJson(List<Question> q) {
        StringBuilder b = new StringBuilder("[");
        for (int i=0;i<q.size();i++) {
            Question x=q.get(i);
            if(i>0)b.append(',');
            b.append("{\"id\":").append(x.getId()).append(",\"text\":\"").append(esc(x.getText())).append("\",\"options\":[");
            String[] o=x.getOptions();
            for(int j=0;j<4;j++){if(j>0)b.append(',');b.append('\"').append(esc(o[j])).append('\"');}
            b.append("]}");
        }
        return b.append(']').toString();
    }
}
