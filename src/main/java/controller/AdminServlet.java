package controller;


import model.persistence.ConPool;
import model.user.UserDAO;
import model.user.UserSpecificationBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection con = ConPool.getConnection()){
            UserDAO service = new UserDAO(con);
            req.setAttribute("count",service.count(new UserSpecificationBuilder().build()));
        } catch (SQLException throwables) {
            throw new ServletException(throwables);
        }
        req.getRequestDispatcher("/WEB-INF/views/crm/admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}