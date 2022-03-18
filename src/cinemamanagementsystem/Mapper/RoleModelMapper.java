/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.RoleModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleModelMapper implements IMapper<RoleModel>{

    @Override
    public RoleModel mapModel(ResultSet rs) throws SQLException {
        RoleModel role = new RoleModel();
        rs.next();
        role.setId(rs.getInt("id"));
        role.setDescription(rs.getString("description"));
        return role;
    }

    @Override
    public ArrayList<RoleModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<RoleModel> roleList = new ArrayList<>();
        while (rs.next()) {
            RoleModel role = new RoleModel();
            role.setId(rs.getInt("id"));
            role.setDescription(rs.getString("description"));
            roleList.add(role);
        }    
        return roleList;
    }
    
}
