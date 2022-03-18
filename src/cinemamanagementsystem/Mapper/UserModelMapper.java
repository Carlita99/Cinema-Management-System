/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserModelMapper implements IMapper<UserModel>{

    @Override
    public UserModel mapModel(ResultSet rs) throws SQLException {
        UserModel user = new UserModel();
        rs.next();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRoleId(rs.getInt("roleId"));
        return user;
    }

    @Override
    public ArrayList<UserModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<UserModel> userList = new ArrayList<>();
        while (rs.next()) {
            UserModel user = new UserModel();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getInt("roleId"));
            userList.add(user);
        }    
        return userList;
    }
    
}
