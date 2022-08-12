package dao;

import model.RegisterUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {

    public int register(Connection con, RegisterUser registerUser) throws Exception {
        String cxsql="Select * from user";
        PreparedStatement cxps = con.prepareStatement(cxsql);
        ResultSet resultSet = cxps.executeQuery();
        //先查询再数据库中是否存在这个用户名，若存在则直接返回-1，注册失败
        while(resultSet.next()){
            if(registerUser.getUserName().equals(resultSet.getString("userName"))){
                return -1;
            }
        }
        //注册
        String sql="insert into user values (?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,registerUser.getUserName());
        ps.setString(2, registerUser.getPassWord());
        ps.setString(3, registerUser.getEmail());
        int i = ps.executeUpdate();
        //返回插入条数
        return i;

    }

}
