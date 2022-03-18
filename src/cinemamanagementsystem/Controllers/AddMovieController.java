package cinemamanagementsystem.Controllers;

import javax.swing.JFrame;

import cinemamanagementsystem.Views.ViewFactory;
import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Views.AddMovieView;


public class AddMovieController implements IAddMovieController {
	private AddMovieView addMovieView;
	private MovieRepository movieRepository;
	public AddMovieController(JFrame view, MovieRepository movieRepository) {
		this.addMovieView=(AddMovieView) addMovieView;
		this.movieRepository=movieRepository;
	}
	
	@Override
	public boolean addMovie(MovieModel movie) {
		
		//TODO Image input
		return movieRepository.AddMovie(movie);
	}
	@Override

	public boolean saveMovie(MovieModel movie) {
		return movieRepository.AddMovie(movie);
		
	}
	
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		addMovieView.setVisible(false);
		addMovieView.dispose();
	}
}
