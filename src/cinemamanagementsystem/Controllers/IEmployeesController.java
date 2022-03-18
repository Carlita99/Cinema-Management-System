package cinemamanagementsystem.Controllers;

import java.util.ArrayList;

import cinemamanagementsystem.Models.UserModel;

public interface IEmployeesController {
	public ArrayList<UserModel> getAdminsAndEmployees();

	public boolean addEmployee(UserModel employee);

	public boolean editEmployee(UserModel employee);
}
