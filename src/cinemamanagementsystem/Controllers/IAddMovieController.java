package cinemamanagementsystem.Controllers;

import cinemamanagementsystem.Models.MovieModel;

public interface IAddMovieController {
	public boolean addMovie(MovieModel movie);
	public boolean saveMovie(MovieModel movie);
}
