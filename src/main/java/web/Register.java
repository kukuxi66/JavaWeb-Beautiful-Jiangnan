package web;

import dao.RegisterDao;
import model.RegisterUser;
import model.User;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
@WebServlet("/Register")
public class Register extends HttpServlet {

    DbUtil dbUtil = new DbUtil();
    RegisterDao registerDao = new RegisterDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传来的账号密码、电子邮箱
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        String Email = req.getParameter("Email");
        Connection con=null;
        try {
            RegisterUser registerUser = new RegisterUser(userName,passWord, Email);
            con= dbUtil.getCon();
            //将连接、用户名密码邮箱注册实体类传到到Dao层执行
            int i =registerDao.register(con,registerUser);
            if(i>0){
                //若返回为大于0，则执行插入成功
                resp.sendRedirect("/HomeWork_war_exploded/Regitsuccess.html");
            }
            else if(i==-1) {
                resp.sendRedirect("/HomeWork_war_exploded/RegitError.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
