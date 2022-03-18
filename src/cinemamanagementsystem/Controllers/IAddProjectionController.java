package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.TheaterModel;

public interface IAddProjectionController {
	public ArrayList<MovieModel> getMovies() ;
	public ArrayList<TheaterModel> getTheaters();
	public ArrayList<ProjectionModel> getProjections();
	public boolean editMovie (MovieModel movie);
	public boolean addProjection(ProjectionModel projection) ;
	public boolean deleteProjection(ProjectionModel projection);
	
}
