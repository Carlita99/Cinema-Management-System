package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Views.HomeView;
import cinemamanagementsystem.Views.ViewFactory;

public class HomeController implements IHomeController {

	private HomeView homeView;
	private MovieRepository movieRepository;
	
	public HomeController(JFrame view, MovieRepository movieRepository) {
		this.homeView = (HomeView) view;
		this.movieRepository = movieRepository;
	}
	
	public ArrayList<MovieModel> getAllMoviesByStatus(String status){
		return movieRepository.getMovieByStatus(status);
	}
	
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		homeView.setVisible(false);
		homeView.dispose();
		
	}
}
