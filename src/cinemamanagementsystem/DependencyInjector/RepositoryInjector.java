package cinemamanagementsystem.DependencyInjector;

import cinemamanagementsystem.Repositories.*;

public class RepositoryInjector {
	private static MovieRepository movieRepository = null;
	private static ProjectionRepository projectionRepository = null;
	private static ReservationRepository reservationRepository = null;
	private static RoleRepository roleRepository = null;
	private static SeatRepository seatRepository = null;
	private static TheaterRepository theaterRepository = null;
	private static UserRepository userRepository = null;
	public static MovieRepository getMovieRepository() {
		if (movieRepository == null) {
			movieRepository = new MovieRepository();
		}
		return movieRepository;
	}
	
	
	public static ProjectionRepository getProjectionRepository() {
		if (projectionRepository == null) {
			projectionRepository = new ProjectionRepository();
		}
		return projectionRepository;
	}
	
	public static ReservationRepository getReservationRepository() {
		if (reservationRepository == null) {
			reservationRepository = new ReservationRepository();
		}
		return reservationRepository;
	}
	
	public static RoleRepository getRoleRepository() {
		if (roleRepository == null) {
			roleRepository = new RoleRepository();
		}
		return roleRepository;
	}
	
	public static SeatRepository getSeatRepository() {
		if (seatRepository == null) {
			seatRepository = new SeatRepository();
		}
		return seatRepository;
	}
	
	public static TheaterRepository getTheaterRepository() {
		if (theaterRepository == null) {
			theaterRepository = new TheaterRepository();
		}
		return theaterRepository;
	}
	
	public static UserRepository getUserRepository() {
		if (userRepository == null) {
			userRepository = new UserRepository();
		}
		return userRepository;
	}

}
