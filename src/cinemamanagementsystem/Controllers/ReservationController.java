package cinemamanagementsystem.Controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.ReservationModel;
import cinemamanagementsystem.Models.RoleModel;
import cinemamanagementsystem.Models.SeatModel;
import cinemamanagementsystem.Repositories.ProjectionRepository;
import cinemamanagementsystem.Repositories.ReservationRepository;
import cinemamanagementsystem.Repositories.RoleRepository;
import cinemamanagementsystem.Repositories.SeatRepository;
import cinemamanagementsystem.Views.ReservationView;
import cinemamanagementsystem.Views.ViewFactory;

public class ReservationController implements IReservationController{
	
	private ReservationView reservationView;
	private int movieId;
	private ProjectionRepository projectionRepository;
	private SeatRepository seatRepository;
	private RoleRepository roleRepository;
	private ReservationRepository reservationRepository;
	
	public ReservationController(JFrame view, int movieId, ProjectionRepository projectionRepository, SeatRepository seatRepository, RoleRepository roleRepository, ReservationRepository reservationRepository ) {
		this.reservationView = (ReservationView) view;
		this.movieId = movieId;
		this.projectionRepository = projectionRepository;
		this.seatRepository = seatRepository;
		this.roleRepository = roleRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public ArrayList<SeatModel> getAllSeatsByTheatreId(int theatreId){
		return seatRepository.getSeatsByTheaterId(theatreId);
	}
	
	public ArrayList<ProjectionModel> getUpcominProjectionsForMovie(int movieId){
		return projectionRepository.getUpcomingProjectionsByMovieId(movieId);
	}
	
	public LinkedHashSet<String> getAllSeatRows(ArrayList<SeatModel> seats){
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for(int i=0; i<seats.size(); i++) {
			set.add(seats.get(i).getSeatRow());
		}
		return set;
	}
	
	public LinkedHashSet<Integer> getAllSeatCols(ArrayList<SeatModel> seats){
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for(int i=0; i<seats.size(); i++) {
			set.add(seats.get(i).getSeatColumn());
		}
		return set;
	}
	
	public ArrayList<ReservationModel> getReservationsForProjection(int projectionId){
		return reservationRepository.getReservationsByProjectionId(projectionId);
	}
	
	public String seatReserved(int seatId, ArrayList<ReservationModel> res) {
		for(int i = 0; i<res.size(); i++) {
			if(seatId == res.get(i).getSeatId() && GlobalVariables.user.getId() == res.get(i).getUserId() && !employe(GlobalVariables.user.getRoleId()))
				return "BLUE";
			if(seatId == res.get(i).getSeatId())
				return "RED";
		}
		return "";
	}
	
	public boolean employe(int roleId) {
		RoleModel role = roleRepository.getRoleById(roleId);
		if(GlobalVariables.EMPLOYE.equals(role.getDescription()))
			return true;
		return false;
	}
	
	
	public boolean seatExists(ArrayList<SeatModel> seats, String row, int col) {
		for(int i =0; i<seats.size(); i++) {
			if(seats.get(i).getSeatColumn() == col && seats.get(i).getSeatRow().equalsIgnoreCase(row))
				return true;
		}
		return false;
	}
	
	public void addReservation(ArrayList<ReservationModel> reservations) {
		for(int i=0; i<reservations.size(); i++) {
			reservationRepository.createReservation(reservations.get(i));
		}
	}
	
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		reservationView.setVisible(false);
		reservationView.dispose();
	}

}
