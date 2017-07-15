package club.bestchu.servlet;

import club.bestchu.entity.Admin;
import club.bestchu.exception.UserNotExistException;
import club.bestchu.service.Adminservice;
import club.bestchu.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bestchu on 2017/7/14.
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private Adminservice adminservice = new AdminServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("register".equals(method)){
            register(request, response);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Admin ad = new Admin();
        ad.setUserName(userName);
        ad.setPassword(password);

        try{
            adminservice.register(ad);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }catch (UserNotExistException ue){
            request.setAttribute("message", "用户以存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }catch (Exception e){
            response.sendRedirect(request.getContextPath() + "error/error.jsp");
        }
    }
}
