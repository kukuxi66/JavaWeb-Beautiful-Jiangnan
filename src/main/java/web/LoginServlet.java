package web;

import com.alibaba.fastjson.JSON;
import dao.UserDao;
import model.User;
import util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Connection con=null;
        try {
            User user = new User(userName,passWord);
            con= dbUtil.getCon(); //连接数据库
            User currentUser=userDao.login(con,user); //将数据库连接、用户名密码实体类传送到Dao层执行数据库查询
            if(currentUser==null){//返回为空则未查到
                response.getWriter().write("用户名或密码错误");
            }
            else{//否则设置Session保持登录成功状态，并返回登录成功
                HttpSession session = request.getSession();
                session.setAttribute("user",userName);
                session.setAttribute("pass",passWord);
                response.getWriter().write("登录成功");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
