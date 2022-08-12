package web;

import com.alibaba.fastjson.JSON;
import dao.NewsDao;
import model.news;
import util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "SelectNews", value = "/SelectNews")
public class SelectNews extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    NewsDao newsdao = new NewsDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = null;
        String news = null;
        Connection con=null;
        try {
            news news1 = new news(date,news);
            con= dbUtil.getCon();
            ArrayList<news> currentUser = newsdao.Select(con);
            String jsonString = JSON.toJSONString(currentUser);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
