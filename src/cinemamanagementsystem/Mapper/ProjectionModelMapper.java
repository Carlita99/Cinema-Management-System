/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.ProjectionModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProjectionModelMapper implements IMapper<ProjectionModel>{

    @Override
    public ProjectionModel mapModel(ResultSet rs) throws SQLException {
        ProjectionModel projection = new ProjectionModel();
        rs.next();
        projection.setId(rs.getInt("id"));
        projection.setMovieId(rs.getInt("movieId"));
        projection.setTheaterId(rs.getInt("theaterId"));
        projection.setPrice(rs.getDouble("price"));
        projection.setProjectionTime(rs.getTimestamp("projectionTime"));
        projection.setType(rs.getString("type"));
        return projection;
    }

    @Override
    public ArrayList<ProjectionModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<ProjectionModel> projectionList = new ArrayList<>();
        while (rs.next()) {
            ProjectionModel projection = new ProjectionModel();
            projection.setId(rs.getInt("id"));
            projection.setMovieId(rs.getInt("movieId"));
            projection.setTheaterId(rs.getInt("theaterId"));
            projection.setPrice(rs.getDouble("price"));
            projection.setProjectionTime(rs.getTimestamp("projectionTime"));
            projection.setType(rs.getString("type"));
            projectionList.add(projection);
        }    
        return projectionList;
    }
    
}
