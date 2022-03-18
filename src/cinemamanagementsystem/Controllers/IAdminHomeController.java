package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import cinemamanagementsystem.Models.MovieModel;

public interface IAdminHomeController {
public abstract ArrayList <MovieModel> nowShowingMovies();
public abstract ArrayList <MovieModel> upcomingMovies();
public abstract boolean deleteMovie(MovieModel movie);

}
