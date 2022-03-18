package cinemamanagementsystem.Views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cinemamanagementsystem.Controllers.LoginController;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginView extends JFrame{

	private JFrame frame;
	private JPasswordField passField;
	private JTextField emailField;
	private LoginController loginController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		loginController = ControllerInjector.getLoginController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel image = new JLabel();
		image.setVerticalAlignment(SwingConstants.TOP);
		image.setHorizontalAlignment(SwingConstants.LEFT);
		image.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/cinema.png").getImage().getScaledInstance(200, 160, java.awt.Image.SCALE_SMOOTH)));
		panel.add(image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel email = new JLabel("Email");
		email.setBounds(450, 100, 150, 23);
		panel_1.add(email);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(450, 200, 150, 23);
		panel_1.add(pass);
		
		emailField = new JTextField();
		emailField.setBounds(600, 100, 200, 25);
		panel_1.add(emailField);		

		passField = new JPasswordField();
		passField.setBounds(600, 200, 200, 25);
		panel_1.add(passField);
		passField.setColumns(10);
		emailField.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont (lblLogin.getFont ().deriveFont (33.0f));
		lblLogin.setBounds(585, 0, 150, 30);
		panel_1.add(lblLogin);
		
		JButton loginBt = new JButton("LOGIN");
		loginBt.setBounds(711, 283, 89, 23);
		
		loginBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if((loginController.login(emailField.getText(), passField.getText())) == false) {
					JOptionPane.showMessageDialog(null, "Incorrect username or password ");
				}
			}
		});
		
		panel_1.add(loginBt);
		
		frame.setBounds(100, 100, 989, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
