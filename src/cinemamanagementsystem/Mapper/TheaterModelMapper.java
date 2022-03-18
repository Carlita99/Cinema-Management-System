/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.TheaterModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TheaterModelMapper implements IMapper<TheaterModel>{

    @Override
    public TheaterModel mapModel(ResultSet rs) throws SQLException {
        TheaterModel theater = new TheaterModel();
        rs.next();
        theater.setId(rs.getInt("id"));
        theater.setDescription(rs.getString("description"));
        return theater;    
    }
 
    @Override
    public ArrayList<TheaterModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<TheaterModel> theaterList = new ArrayList<>();
        while (rs.next()) {
            TheaterModel theater = new TheaterModel();
            theater.setId(rs.getInt("id"));
            theater.setDescription(rs.getString("description"));
            theaterList.add(theater);
        }    
        return theaterList;
    }
    
}
