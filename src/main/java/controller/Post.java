package controller;

import model.persistence.ConPool;
import model.persistence.Specification;
import model.post.PostDAO;
import model.post.PostSpecificationBuilder;
import model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/post")
public class Post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("id");
        if(postId != null){
            try (Connection con = ConPool.getConnection()){
                PostSpecificationBuilder psb = new PostSpecificationBuilder();
                HttpSession session = req.getSession(true);
                if ((session != null && session.getAttribute("loggedUserId") != null)) {
                    int id = (Integer) session.getAttribute("loggedUserId");
                    System.out.println(id);
                    psb.loggedUser(id);
                }

                psb.byId(Integer.parseInt(postId));
                Specification s2 = psb.build();
                PostDAO service = new PostDAO(con);
                List<model.post.Post> posts = service.fetch(s2);
                if(posts.get(0)!= null){
//                    System.out.println(posts.get(0).getAuthor().getUsername());
//                    System.out.println(posts.get(0).getSection().getName());
//                    System.out.println(posts.get(0).getSection().getId());
                    System.out.println("get vote "+posts.get(0).getVote());
                    System.out.println("get votes "+posts.get(0).getVotes());
                    req.setAttribute("post", posts.get(0));
                    req.getRequestDispatcher("/WEB-INF/views/section/post.jsp").forward(req,resp);
                } else{
                    resp.sendRedirect("./home");
                }
            } catch(SQLException  e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
