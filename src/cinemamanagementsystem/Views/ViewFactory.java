package cinemamanagementsystem.Views;

import javax.swing.JFrame;

import cinemamanagementsystem.Controllers.GlobalVariables;

public class ViewFactory {
	
	
	public static JFrame getView(String action) {
		
		if(GlobalVariables.HOMEACTION.equalsIgnoreCase(action))
			return new HomeView();
		else if(GlobalVariables.RESERVATIONACTION.equalsIgnoreCase(action))
			return new ReservationView();
		else if(GlobalVariables.AllRESERVATIONSACTION.equalsIgnoreCase(action))
			return new AllReservationsView();
		else if(GlobalVariables.ADMINHOMEPAGE.equalsIgnoreCase(action))
			return new AdminHomeView();
		else if(GlobalVariables.ADDMOVIE.equalsIgnoreCase(action))
			return new AddMovieView();
		else if (GlobalVariables.ADMINPROJECTION.equalsIgnoreCase(action))
			return new AddProjectionView();
		else if (GlobalVariables.ADMINEMPLOYEES.equalsIgnoreCase(action))
			return new EmployeesView();
		return null;
	}

}
