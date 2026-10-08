package com.javaquiz.servlet;

import com.javaquiz.dao.QuestionDAO;
import com.javaquiz.exception.QuizException;
import com.javaquiz.model.Question;
import com.javaquiz.service.AttemptService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

/** Receives the exact question IDs shown to the user and persists the result. */
@WebServlet("/api/submit")
public class SubmitServlet extends HttpServlet {
    private final AttemptService service = new AttemptService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int userId = Integer.parseInt(required(req, "userId"));
            String topic = req.getParameter("topicId");
            Integer topicId = (topic == null || topic.isBlank() || "mixed".equals(topic)) ? null : Integer.valueOf(topic);

            String[] ids = req.getParameterValues("questionId");
            if (ids == null || ids.length == 0) throw new QuizException("No quiz questions were submitted.");
            List<Integer> questionIds = new ArrayList<>();
            for (String id : ids) questionIds.add(Integer.valueOf(id));

            List<Question> qs = new QuestionDAO().findByIds(questionIds);
            if (qs.size() != questionIds.size()) throw new QuizException("One or more quiz questions no longer exist.");

            Map<Integer,Integer> answers = new HashMap<>();
            for (Question q : qs) {
                String a = req.getParameter("q_" + q.getId());
                answers.put(q.getId(), a == null ? -1 : Integer.parseInt(a));
            }

            int[] s = service.score(userId, topicId, qs, answers);
            res.setContentType("application/json;charset=UTF-8");
            res.getWriter().printf(Locale.ROOT,
                    "{\"score\":%d,\"right\":%d,\"wrong\":%d,\"skipped\":%d,\"total\":%d}",
                    s[0], s[0], s[1], s[2], qs.size());
        } catch (NumberFormatException e) {
            res.sendError(400, "Invalid numeric quiz data.");
        } catch (QuizException e) {
            res.sendError(400, e.getMessage());
        } catch (Exception e) {
            res.sendError(500, "Unable to submit quiz.");
        }
    }

    private String required(HttpServletRequest req, String name) throws QuizException {
        String value = req.getParameter(name);
        if (value == null || value.isBlank()) throw new QuizException(name + " is required.");
        return value;
    }
}
