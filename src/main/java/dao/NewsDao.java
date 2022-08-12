package dao;


import model.news;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NewsDao {

    public ArrayList<news> Select(Connection con) throws Exception{
        String sql = "Select * from news";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        news ns1=null;
        ArrayList<news> ns2 = new ArrayList<>();
        while (resultSet.next()){
            String news = resultSet.getString("news");
            String date = resultSet.getString("date");
            ns1 = new news();
            ns1.setNews(news);
            ns1.setDate(date);
            ns2.add(ns1);
        }
        return ns2;
    }

    public int update(Connection con, String neirong, String news,String userName) throws Exception {
        String sql="Update news SET content=? where news=? AND userName=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,neirong);
        ps.setString(2, news);
        ps.setString(3, userName);
        int i = ps.executeUpdate();
        return i;
    }

    public int updateAdmin(Connection con, String neirong, String news) throws Exception {
        String sql="Update news SET content=? where news=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,neirong);
        ps.setString(2, news);
        int i = ps.executeUpdate();
        return i;
    }

}
