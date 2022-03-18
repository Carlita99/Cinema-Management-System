package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.ReservationModel;
import cinemamanagementsystem.Models.RoleModel;
import cinemamanagementsystem.Models.SeatModel;
import cinemamanagementsystem.Models.TheaterModel;
import cinemamanagementsystem.Repositories.MovieRepository;
import cinemamanagementsystem.Repositories.ProjectionRepository;
import cinemamanagementsystem.Repositories.ReservationRepository;
import cinemamanagementsystem.Repositories.RoleRepository;
import cinemamanagementsystem.Repositories.SeatRepository;
import cinemamanagementsystem.Repositories.TheaterRepository;
import cinemamanagementsystem.Views.AllReservationsView;
import cinemamanagementsystem.Views.ViewFactory;

public class AllReservationsController implements IAllReservationsController{
	
	private AllReservationsView allReservationsView;
	private ReservationRepository reservationRepository;
	private SeatRepository seatRepository;
	private ProjectionRepository projectionRepository;
	private MovieRepository movieRepository;
	private RoleRepository roleRepository;
	private TheaterRepository theatreRepository;
	
	public AllReservationsController(JFrame view, ReservationRepository reservationRepository, SeatRepository seatRepository, ProjectionRepository projectionRepository, MovieRepository movieRepository, RoleRepository roleRepository, TheaterRepository theatreRepository) {
		allReservationsView = (AllReservationsView) view;
		this.reservationRepository = reservationRepository;
		this.seatRepository = seatRepository;
		this.projectionRepository = projectionRepository;
		this.movieRepository =  movieRepository;
		this.roleRepository = roleRepository;
		this.theatreRepository = theatreRepository;
	}
	
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		allReservationsView.setVisible(false);
	}
	
	public ArrayList<ReservationModel> getReservationsForUser(int userId){
		return reservationRepository.getReservationsByUserId(userId);
	}
	
	public SeatModel getSeatById(int seatId) {
		return seatRepository.getSeatById(seatId);
	}
	
	public ProjectionModel getProjectionById(int projectionId) {
		return projectionRepository.getProjectionById(projectionId);
	}
	
	public MovieModel getMovieById(int movieId) {
		return movieRepository.getMovieById(movieId);
	}
	
	public TheaterModel getTheatreById(int theaterId) {
		return theatreRepository.getTheaterById(theaterId);
	}
	
	public boolean employe(int roleId) {
		RoleModel role = roleRepository.getRoleById(roleId);
		if(GlobalVariables.EMPLOYE.equals(role.getDescription()))
			return true;
		return false;
	}
	
	public void cancelReservation(ReservationModel reservation) {
		reservationRepository.deleteReservation(reservation);
	}
	
	public boolean reservationConfirmed(ReservationModel reservation) {
		if(GlobalVariables.PAID.equalsIgnoreCase(reservation.getStatus()))
				return true;
		return false;
	}
	
	public boolean confirmReservation(ReservationModel reservation) {
		return reservationRepository.changeReservationStatus(reservation);
	}

}
