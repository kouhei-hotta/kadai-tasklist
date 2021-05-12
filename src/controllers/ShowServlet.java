package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TasklistDTO;
import utils.TasklistDBUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = TasklistDBUtil.createEntityManager();

        // 該当のIdのタスク１件のみをデータベースから取得
        TasklistDTO tdto = em.find(TasklistDTO.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // タスクデータをリクエストスコープにセットしてshow.jspを呼び出す
        request.setAttribute("TasklistDTO",tdto);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/show.jsp");
        rd.forward(request, response);
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

}
