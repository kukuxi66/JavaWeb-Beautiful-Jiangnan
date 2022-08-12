package web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOut", value = "/logout")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.getSession().invalidate();
        response.getWriter().write("<h1>您已经成功退出本系统，两秒后跳转回首页！</h1>");
        response.getWriter().write("<h1>如果没有跳转，请点击<a href='/HomeWork_war_exploded/index.html'>这里</a></h1>");
        response.setHeader("Refresh","2;URL=/HomeWork_war_exploded/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
