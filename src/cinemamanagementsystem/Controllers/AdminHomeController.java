package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Views.AddMovieView;
import cinemamanagementsystem.Views.AdminHomeView;
import cinemamanagementsystem.Views.ViewFactory;

public class AdminHomeController implements IAdminHomeController {
	private MovieRepository moviesRepository;
	private AdminHomeView view;

	public AdminHomeController(JFrame view, MovieRepository movieRepository) {
		this.moviesRepository = movieRepository;
		this.view = (AdminHomeView) view;
	}

	@Override
	public ArrayList<MovieModel> nowShowingMovies() {
		return moviesRepository.getMovieByStatus("Now Showing");
	}
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setVisible(false);
	}

	@Override
	public ArrayList<MovieModel> upcomingMovies() {
		return moviesRepository.getMovieByStatus("Coming Soon");

	}

	@Override
	public boolean deleteMovie(MovieModel movie) {
		boolean b =  moviesRepository.deleteMovie(movie);
		System.out.println(b);
		return b;
	}
}
