package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class ReleaseDao {

    public int Release(Connection con, String news,String content,String userName) throws Exception {
        //设置当前时间，年月日
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = (c.get(Calendar.MONTH) + 1);
        int day = c.get(Calendar.DATE);
        String ReleaseDate = year + "-" + month + "-" + day;
        //定义插入语句
        String sql="insert into news values (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        //设置新闻 日期 主题 用户名
        ps.setString(1,news);
        ps.setString(2, ReleaseDate);
        ps.setString(3, content);
        ps.setString(4, userName);
        int i = ps.executeUpdate();
        //返回插入成功条数
        return i;

    }


}
