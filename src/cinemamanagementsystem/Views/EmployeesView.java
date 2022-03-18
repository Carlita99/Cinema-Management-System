package cinemamanagementsystem.Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cinemamanagementsystem.Controllers.EmployeesController;
import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.UserModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EmployeesView extends JFrame {

	private EmployeesController employeesController = ControllerInjector.getEmployeesController(this);
	private ArrayList<UserModel> employees = employeesController.getAdminsAndEmployees();
	JLabel firstName = new JLabel("First Name");
	JLabel lastName = new JLabel("Last Name");
	JLabel email = new JLabel("Email");
	JLabel password = new JLabel("Password");
	JLabel role = new JLabel("Role");
	JTextField name = new JTextField();
	JTextField last = new JTextField();
	JTextField mail = new JTextField();
	JPasswordField pass = new JPasswordField();
	String[] roleValues = { GlobalVariables.ADMIN, GlobalVariables.EMPLOYE };
	JComboBox<String> roles = new JComboBox<String>(roleValues);
	JButton submit = new JButton("Submit");
	JScrollPane scroll;
	JPanel scrollContent = new JPanel();
	JFrame thisView = this;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeesView window = new EmployeesView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel();

		JLabel label_1 = new JLabel("Home");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				employeesController.switchView(GlobalVariables.ADMINHOMEPAGE);
				
			}
			
		});
		label_1.setFont(label_1.getFont().deriveFont(15f));

		JLabel lblProjections = new JLabel("Projections");
		lblProjections.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				employeesController.switchView(GlobalVariables.ADMINPROJECTION);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		lblProjections.setFont(lblProjections.getFont().deriveFont(15f));
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setForeground(Color.RED);
		lblEmployees.setFont(lblEmployees.getFont().deriveFont(15f));
		JLabel label_3 = new JLabel("Logout");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				employeesController.switchView(GlobalVariables.LOGIN);
				
			}
		});
		label_3.setFont(label_3.getFont().deriveFont(15f));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 444, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(label).addGap(600)
						.addComponent(label_1).addGap(146).addComponent(lblProjections).addGap(146)
						.addComponent(lblEmployees).addGap(146).addComponent(label_3)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 115, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(label))
								.addGroup(gl_panel.createSequentialGroup().addGap(85)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
												.addComponent(label_3).addComponent(lblProjections)
												.addComponent(lblEmployees))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		body();
	}

	private void body() {

		firstName.setBounds(50, 150, 150, 25);
		name.setBounds(50, 200, 150, 25);
		lastName.setBounds(50, 250, 150, 25);
		last.setBounds(50, 300, 150, 25);
		email.setBounds(50, 350, 150, 25);
		mail.setBounds(50, 400, 150, 25);
		password.setBounds(50, 450, 150, 25);
		pass.setBounds(50, 500, 150, 25);
		role.setBounds(50, 550, 150, 25);
		roles.setBounds(50, 600, 150, 25);
		pass.setEchoChar('*');
		submit.setBounds(50, 650, 150, 25);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String fn = name.getText();
				String ln = last.getText();
				String pw = new String(pass.getPassword());
				String email = mail.getText();
				String role = roles.getItemAt(roles.getSelectedIndex());
				int roleId = -1;
				if (role == GlobalVariables.ADMIN)
					roleId = 1;
				else
					roleId = 2;
				if (fn != "" && ln != "" && pw != "" && email != "" && roleId > 0) {
					UserModel employee = new UserModel();
					employee.setEmail(email);
					employee.setFirstName(fn);
					employee.setLastName(ln);
					employee.setRoleId(roleId);
					employee.setPassword(pw);
					if (employeesController.addEmployee(employee)) {

						employeesController.switchView(GlobalVariables.ADMINEMPLOYEES);

					} else {
						JOptionPane.showConfirmDialog(null, "Please Try Again");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please Fill all The Fields");

				}
			}
		});
		scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));
		for (UserModel e : employees) {
			String rl;
			JButton b;
			if (e.getRoleId() == 1) {
				rl = "Admin";
				b = new JButton("Demote");
				b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ev) {
						if (GlobalVariables.user.getRoleId() == 1) {
							e.setRoleId(2);
							employeesController.editEmployee(e);

						} else {
							JOptionPane.showConfirmDialog(null, "You do not have this Authority");
						}
					}
				});
			} else {
				rl = "Employee";
				b = new JButton("Promote");
				b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ev) {
						if (GlobalVariables.user.getRoleId() == 1) {
							e.setRoleId(2);
							employeesController.editEmployee(e);

						} else {
							JOptionPane.showConfirmDialog(null, "You do not have this Authority");
						}
					}
				});
			}
			JLabel lbl = new JLabel(e.getFirstName() + " " + e.getLastName() + " - " + rl);
			lbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);

			scrollContent.add(lbl);
			scrollContent.add(b);
			scrollContent.add(Box.createRigidArea(new Dimension(0, 25)));

		}
		scroll = new JScrollPane(scrollContent);
		scroll.setBounds(808, 200, 500, 800);

		this.add(firstName);
		this.add(name);
		this.add(lastName);
		this.add(last);
		this.add(email);
		this.add(mail);
		this.add(password);
		this.add(pass);
		this.add(role);
		this.add(roles);
		this.add(submit);
		this.add(scroll);
		this.add(new JPanel());
	}
}
