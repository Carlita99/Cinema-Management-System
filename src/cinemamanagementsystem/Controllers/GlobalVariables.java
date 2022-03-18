package cinemamanagementsystem.Controllers;

import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.UserModel;

public class GlobalVariables {
	
	// Views
	
	public final static String HOMEACTION = "Home";
	public final static String RESERVATIONACTION = "Reservation";
	public final static String AllRESERVATIONSACTION = "All Reservations";
	
	//Admin Views
	public static final String ADMINHOMEPAGE = "Admin Home Page";
	public static final String LOGIN = "Login";
	public static final String ADMINPROJECTION = "Projections";
	public static final String ADMINEMPLOYEES = "Employees";
	public static final String ADDMOVIE="Add Movie";

	
	//Movie Status
	
	public final static String NOWSHOWING = "Now Showing";
	public final static String COMINGSOON = "Coming Soon";
	public final static String NOTSHOWING = "Not Showing";
	
	// saved variables
	
	public static MovieModel movie;
	public static UserModel user;
	
	// Reservation Status
	
	public final static String PAID = "Paid";
	public final static String NOTPAID = "Not paid";
	
	// Roles

	public final static String EMPLOYE = "Employe";
	public final static String CLIENT = "Client";
	public final static String ADMIN = "Admin";
	public final static int EMPLOYECODE = 2;
	public final static int CLIENTCODE = 3;
	public final static int ADMINCODE = 1;
}
