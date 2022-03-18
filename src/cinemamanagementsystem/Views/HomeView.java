package cinemamanagementsystem.Views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.Controllers.HomeController;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.UserModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class HomeView extends JFrame implements ActionListener{

	public JFrame frame;
	private ArrayList<MovieModel> movies;
	private HomeController homeController;
	private int itemNb = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView window = new HomeView();
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
	public HomeView() {
		
		//b3den bs a3ml login bshiloun 
		GlobalVariables.user = new UserModel();
		GlobalVariables.user.setId(2);
		GlobalVariables.user.setRoleId(3);
		// shiloun
		
		homeController = ControllerInjector.getHomeController(this);
		movies = homeController.getAllMoviesByStatus(GlobalVariables.NOWSHOWING);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.white);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/cinema.png").getImage().getScaledInstance(200, 160, java.awt.Image.SCALE_SMOOTH)));
		
		home = new JLabel("Home");
		home.setForeground(Color.RED);
		home.setFont (home.getFont ().deriveFont (15.0f));
		home.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				homeController.switchView(GlobalVariables.HOMEACTION);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		logout = new JLabel("Logout");
		logout.setFont (logout.getFont ().deriveFont (15.0f));
		
		about = new JLabel("All Reservations");
		about.setFont (about.getFont ().deriveFont (15.0f));
		about.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				homeController.switchView(GlobalVariables.AllRESERVATIONSACTION);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(logo)
					.addGap(600)
					.addComponent(home)
					.addGap(146)
					.addComponent(about)
					.addGap(146)
					.addComponent(logout)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(logo))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(home)
								.addComponent(logout)
								.addComponent(about))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		body(frame);
		
	}
	
	public void body(JFrame frame) {
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		nowshowing = new JLabel("Now Showing");
		nowshowing.setFont (nowshowing.getFont ().deriveFont (15.0f));
		nowshowing.setBounds(10, 11, 150, 25);
		panel_2.add(nowshowing);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1345, 200);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,1));
		pan.setBackground(Color.white);
		for(int i=0; movies!=null && i <movies.size() ; i++) {
			JLabel lb = new JLabel("   " + movies.get(i).getTitle());
			JLabel logo2 = new JLabel();
			logo2.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + movies.get(i).getPicture()).getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
			
			final int f = i;
			logo2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					itemNb=f;
					GlobalVariables.movie = movies.get(itemNb);
					selectedPicture.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + movies.get(itemNb).getPicture()).getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
					description.setText(movies.get(itemNb).getDescription());
					panel_4.removeAll();
					panel_4.repaint();
					panel_4.revalidate();
					MovieDetailsView mdv = new MovieDetailsView(movies.get(itemNb), panel_4);
					mdv.insertDetails();
					panel_4.repaint();
					panel_4.revalidate();
				}
			});
			pan.add(logo2);
			pan.add(lb);
		}
		scrollPane.setViewportView(pan);

		panel_2.add(scrollPane);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setBackground(Color.WHITE);
		
		selectedPicture = new JLabel();
		selectedPicture.setVerticalAlignment(SwingConstants.TOP);
		selectedPicture.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + movies.get(0).getPicture()).getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
		
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(new GridLayout(0 , 1));
		MovieDetailsView mdv = new MovieDetailsView(movies.get(0), panel_4);
		mdv.insertDetails();
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 65));
		panel_3.add(selectedPicture);
		panel_3.add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_3.add(panel_5);
		
		description = new JMultilineLabel(movies.get(itemNb).getDescription());
		
		addReservation = new JButton("Add Reservation");
		addReservation.addActionListener(this);
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(0)
					.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(addReservation))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(75)
					.addComponent(addReservation))
		);
		panel_5.setLayout(gl_panel_5);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addReservation)) {
			homeController.switchView(GlobalVariables.RESERVATIONACTION);
		}
		
	}
	
	private JPanel panel;
	private JLabel logo;
	private JLabel logout;
	private JLabel home;
	private JLabel about;
	private JPanel panel_2;
	private JLabel nowshowing;
	private JScrollPane scrollPane;
	private JLabel selectedPicture;
	private JPanel panel_3 ;
	private JPanel panel_4;
	private JMultilineLabel description;
	private JButton addReservation;
	private JPanel panel_5;

	
}
