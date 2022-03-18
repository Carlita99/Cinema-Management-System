/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.MovieModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieModelMapper implements IMapper<MovieModel>{

//Statuses
//	upcoming
//	outdated
//	now_showing
    @Override
    public MovieModel mapModel(ResultSet rs) throws SQLException {
        MovieModel movie = new MovieModel();
        rs.next();
        movie.setId(rs.getInt("id"));
        movie.setDescription(rs.getString("description"));
        movie.setTitle(rs.getString("title"));
        movie.setDuration(rs.getTime("duration"));
        movie.setPg(rs.getString("pg"));
        movie.setStatus(rs.getString("status"));
        movie.setPicture(rs.getString("picture"));
        return movie;
    }

    @Override
    public ArrayList<MovieModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<MovieModel> movieList = new ArrayList<>();
        while (rs.next()) {
            MovieModel movie = new MovieModel();
            movie.setId(rs.getInt("id"));
            movie.setDescription(rs.getString("description"));
            movie.setTitle(rs.getString("title"));
            movie.setDuration(rs.getTime("duration"));
            movie.setPg(rs.getString("pg"));
            movie.setStatus(rs.getString("status"));
            movie.setPicture(rs.getString("picture"));
            movieList.add(movie);
        }    
        return movieList;
    }
    
}
