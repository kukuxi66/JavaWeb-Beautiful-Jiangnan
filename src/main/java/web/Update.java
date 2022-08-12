package web;

import dao.NewsDao;
import util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Update", value = "/update")
public class Update extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    NewsDao newsDao = new NewsDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String zt = request.getParameter("zt");
        String nr = request.getParameter("nr");
        Connection con=null;
        try {
            response.setContentType("text/html;charset=utf-8");
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("user");
            con = dbUtil.getCon();
            //获取Session判断是否登录
            if(session.getAttribute("user")==null){
                response.getWriter().write("请先登录！");
            }
            else{
                con = dbUtil.getCon();
                //判断是否为管理员
                if(userName.equals("admin")){
                    //是则执行管理员命令
                    int i = newsDao.updateAdmin(con,nr,zt);
                    if(i>0){
                        response.getWriter().write("修改成功！");
                    }
                    else{
                        response.getWriter().write("修改失败！不是你的留言");
                    }
                }
                else{
                    int i = newsDao.update(con,nr,zt,userName);
                    if(i>0){
                        response.getWriter().write("修改成功！");
                    }
                    else{
                        response.getWriter().write("修改失败！不是你的留言");
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
