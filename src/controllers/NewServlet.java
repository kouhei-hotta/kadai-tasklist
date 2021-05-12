package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TasklistDTO;
import utils.TasklistDBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = TasklistDBUtil.createEntityManager();

        // TasklistDTO（モデル）のインスタンスを生成
        TasklistDTO tdto = new TasklistDTO();

        // tdtoの各フィールドにデータを代入
        String content = "weeeee";
        tdto.setContent(content);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());    // 現在の日時を取得
        tdto.setCreated_at(currentTime);
        tdto.setUpdated_at(currentTime);

        // データベースに保存
        em.getTransaction().begin();
        em.persist(tdto);
        em.getTransaction().commit();

        // 自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(tdto.getId()).toString());

        em.close();
    }


}
