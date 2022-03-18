package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import cinemamanagementsystem.Models.MovieModel;

public interface IHomeController {
	
	public abstract ArrayList<MovieModel> getAllMoviesByStatus(String Status);

}
