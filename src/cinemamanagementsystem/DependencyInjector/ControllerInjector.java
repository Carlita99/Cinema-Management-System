package cinemamanagementsystem.DependencyInjector;

import javax.swing.JFrame;

import cinemamanagementsystem.Controllers.AddMovieController;
import cinemamanagementsystem.Controllers.AddProjectionController;
import cinemamanagementsystem.Controllers.AdminHomeController;
import cinemamanagementsystem.Controllers.AllReservationsController;
import cinemamanagementsystem.Controllers.EmployeesController;
import cinemamanagementsystem.Controllers.HomeController;
import cinemamanagementsystem.Controllers.LoginController;
import cinemamanagementsystem.Controllers.ReservationController;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Repositories.ProjectionRepository;
import cinemamanagementsystem.Repositories.TheaterRepository;

public class ControllerInjector {

	private static HomeController homeController = null;
	private static ReservationController reservationController = null;
	private static AllReservationsController allReservationController = null;
	private static AdminHomeController adminHomeController = null;
	private static LoginController loginController = null;
	private static AddMovieController addMovieController = null;
	private static AddProjectionController addProjectionController = null;
	private static EmployeesController employeesController = null;

	public static HomeController getHomeController(JFrame view) {
		if (homeController == null)
			homeController = new HomeController(view, RepositoryInjector.getMovieRepository());
		return homeController;
	}

	public static ReservationController getReservationController(JFrame view, int movieId) {
		if (reservationController == null)
			reservationController = new ReservationController(view, movieId,
					RepositoryInjector.getProjectionRepository(), RepositoryInjector.getSeatRepository(),
					RepositoryInjector.getRoleRepository(), RepositoryInjector.getReservationRepository());
		return reservationController;
	}

	public static AllReservationsController getAllReservationsController(JFrame view) {
		if (allReservationController == null)
			allReservationController = new AllReservationsController(view,
					RepositoryInjector.getReservationRepository(), RepositoryInjector.getSeatRepository(),
					RepositoryInjector.getProjectionRepository(), RepositoryInjector.getMovieRepository(),
					RepositoryInjector.getRoleRepository(), RepositoryInjector.getTheaterRepository());
		return allReservationController;
	}

	public static LoginController getLoginController(JFrame view) {
		if (loginController == null)
			loginController = new LoginController(view, RepositoryInjector.getUserRepository());
		return loginController;
	}

	// Admin Controllers
	public static AdminHomeController getAdminHomeController(JFrame view) {
		if (adminHomeController == null) {
			adminHomeController = new AdminHomeController(view, RepositoryInjector.getMovieRepository());
		}
		return adminHomeController;
	}

	public static AddProjectionController getAddProjectionController(JFrame v) {
		if (addProjectionController == null)
			addProjectionController = new AddProjectionController(v,RepositoryInjector.getProjectionRepository(),
					RepositoryInjector.getTheaterRepository(), RepositoryInjector.getMovieRepository());
		return addProjectionController;
	}

	public static AddMovieController getAddMovieController(JFrame view) {
		if (addMovieController == null) {
			addMovieController = new AddMovieController(view, RepositoryInjector.getMovieRepository());
		}
		return addMovieController;
	}

	public static EmployeesController getEmployeesController(JFrame view)

	{
		if (employeesController == null)
			employeesController = new EmployeesController(view, RepositoryInjector.getUserRepository());
		return employeesController;
	}

}
