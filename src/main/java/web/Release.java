package web;

import dao.ReleaseDao;
import util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Release", value = "/Release")
public class Release extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    ReleaseDao releaseDao = new ReleaseDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //获取前端传来的发布主题和内容
        String news = request.getParameter("zt");
        String content = request.getParameter("nr");
        //新建连接
        Connection con=null;
        try {
            response.setContentType("text/html;charset=utf-8");
            //获取Session,判断用户是否登录
            HttpSession session = request.getSession();
            //定义userName获取登录的user
            String userName = (String) session.getAttribute("user");
            //判断user或pass为空，若为空，则跳转到未登录界面，提示用户登录
            if(session.getAttribute("user")==null|| session.getAttribute("pass") == null){
                response.sendRedirect("/HomeWork_war_exploded/NoLogins.html");
            }
            else{
                //连接数据库
                con= dbUtil.getCon();
                //传入连接和用户名密码
                int i =releaseDao.Release(con,news,content,userName);
                if(i>0){
                    //插入成功
                    response.sendRedirect("/HomeWork_war_exploded/releasesuccess.html");
                }
                else if(i==-1) {
                    //插入失败
                    response.sendRedirect("/HomeWork_war_exploded/releaserror.html");
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
