package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import cinemamanagementsystem.Models.UserModel;
import cinemamanagementsystem.Repositories.UserRepository;
import cinemamanagementsystem.Views.EmployeesView;
import cinemamanagementsystem.Views.ViewFactory;

public class EmployeesController implements IEmployeesController {
	EmployeesView employeesView;
	UserRepository userRepository;

	public EmployeesController(JFrame view, UserRepository userRepository) {
		this.employeesView = (EmployeesView) view;
		this.userRepository = userRepository;
	}

	@Override
	public ArrayList<UserModel> getAdminsAndEmployees() {
		return userRepository.getAdminsAndEmployees();
	}

	@Override
	public boolean addEmployee(UserModel employee) {
		return userRepository.createUser(employee);
	}

	@Override
	public boolean editEmployee(UserModel employee) {
		return userRepository.editUser(employee);
	}

	public void switchView(String action) {
		JFrame nextView = ViewFactory.getView(action);
		nextView.setVisible(true);
		nextView.setExtendedState(JFrame.MAXIMIZED_BOTH);
		employeesView.setVisible(false);
		employeesView.dispose();
	}
}
