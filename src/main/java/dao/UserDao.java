package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {

    public User login(Connection con,User user) throws Exception {
        User resultUser=null;
        String sql="select * from user where userName=? and passWord=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getUserName());
        ps.setString(2, user.getPassWord());
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            resultUser = new User();
            resultUser.setUserName(resultSet.getString("userName"));
            resultUser.setPassWord(resultSet.getString("passWord"));
        }
        return resultUser;

    }

}
