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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = TasklistDBUtil.createEntityManager();

        // 該当のIDのタスクを１件のみをデータベースから取得
        TasklistDTO tdto = em.find(TasklistDTO.class, Integer.parseInt(request.getParameter("id")));
        em.close();

        // タスク情報とセッションIDをリクエストスコープに登録
        request.setAttribute("TasklistDTO",tdto);
        request.setAttribute("jobs", request.getSession().getId());

        // タスクIDをセッションスコープに登録
        request.getSession().setAttribute("Tasklitst",tdto.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
        rd.forward(request, response);
    }

}