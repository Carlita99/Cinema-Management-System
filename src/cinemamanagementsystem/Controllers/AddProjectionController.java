package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.TheaterModel;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Repositories.ProjectionRepository;
import cinemamanagementsystem.Repositories.TheaterRepository;
import cinemamanagementsystem.Views.AddProjectionView;
import cinemamanagementsystem.Views.ViewFactory;

public class AddProjectionController implements IAddProjectionController {
	MovieRepository moviesRepository;
	ProjectionRepository projectionRepository;
	TheaterRepository theaterRepository;
	AddProjectionView addProjectionView;

	public AddProjectionController(JFrame v, ProjectionRepository p, TheaterRepository t, MovieRepository m) {
		this.moviesRepository = m;
		this.projectionRepository = p;
		this.theaterRepository = t;
		this.addProjectionView = (AddProjectionView) v;

	}

	@Override
	public ArrayList<MovieModel> getMovies() {
		return moviesRepository.getMovies();
	}

	@Override
	public ArrayList<TheaterModel> getTheaters() {
		return theaterRepository.getTheaters();
	}

	@Override
	public ArrayList<ProjectionModel> getProjections() {
		return projectionRepository.getProjections();
	}

	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		addProjectionView.setVisible(false);
		addProjectionView.dispose();
	}

	@Override
	public boolean editMovie(MovieModel movie) {
		return moviesRepository.EditMovie(movie);
	}

	@Override
	public boolean addProjection(ProjectionModel projection) {
		return projectionRepository.createProjection(projection);
	}

	@Override
	public boolean deleteProjection(ProjectionModel projection) {
		return projectionRepository.deleteProjection(projection);
	}
}
