package ute.isclass.controller.admin;

import ute.isclass.service.AdminService;
import ute.isclass.service_impl.AdminService_impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/login")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/admin/login/adminLogin.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminService_impl();
        boolean check = adminService.checkAdminLogin(username, password);
        if(check)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user_admin", username);
            session.setAttribute("password_admin", password);
            response.sendRedirect(request.getContextPath() + "/admin/home");
        }
        else
        {
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu sai!");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/login/adminLogin.jsp");
            rd.forward(request, response);
        }
    }
}
