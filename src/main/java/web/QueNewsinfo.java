package web;

import com.alibaba.fastjson.JSON;
import dao.NesinfoDao;
import model.NewsInfo;
import util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "QueNewsinfo", value = "/QueNewsinfo")
public class QueNewsinfo extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    NesinfoDao nesinfoDao = new NesinfoDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = null;
        String news = null;
        String content = null;
        String userName = null;
        Connection con=null;
        try {
            NewsInfo newsInfo = new NewsInfo(news,date,content,userName);
            con = dbUtil.getCon();
            //查询数据库
            ArrayList<NewsInfo> currentnews = nesinfoDao.Select(con);
            String jsonString = JSON.toJSONString(currentnews);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
