package dao;

import model.NewsInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class NesinfoDao {

    public ArrayList<NewsInfo> Select(Connection con) throws Exception{
        String sql = "Select * from news";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        NewsInfo ns1=null;
        //创建List集合ns2
        ArrayList<NewsInfo> ns2 = new ArrayList<>();
        while (resultSet.next()){
            //遍历数据库
            String news = resultSet.getString("news");
            String date = resultSet.getString("date");
            String content = resultSet.getString("content");
            String userName = resultSet.getString("userName");
            //创建ns1，并将数据库查询到的内容添加进去
            ns1 = new NewsInfo();
            ns1.setNews(news);
            ns1.setDate(date);
            ns1.setContent(content);
            ns1.setUserName(userName);
            //全部添加到ns2中
            ns2.add(ns1);
        }
        //返回ns2集合
        return ns2;
    }



}
