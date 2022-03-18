package cinemamanagementsystem.Controllers;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.UserModel;
import cinemamanagementsystem.Repositories.UserRepository;
import cinemamanagementsystem.Views.LoginView;
import cinemamanagementsystem.Views.ViewFactory;

public class LoginController implements ILoginController{
	
	private LoginView loginView;
	private UserRepository userRepository;
	
	public LoginController(JFrame view, UserRepository userRepository) {
		this.loginView = (LoginView) view;
		this.userRepository = userRepository;
	}
	
	public boolean login(String email, String pass) {
		boolean exists = userRepository.login(email, pass);
		if(exists) {
			GlobalVariables.user = getUser(email);
			switchView(GlobalVariables.HOMEACTION);
			return true;
		}
		return false;
	}
	
	public UserModel getUser(String email) {
		return userRepository.getUserByEmail(email);
	}
	
	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginView.setVisible(false);
	}

}
