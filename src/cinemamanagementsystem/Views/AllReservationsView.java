package cinemamanagementsystem.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

import cinemamanagementsystem.Controllers.AllReservationsController;
import cinemamanagementsystem.Controllers.CreateTicketsPdf;
import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.ReservationModel;
import cinemamanagementsystem.Models.SeatModel;
import cinemamanagementsystem.Models.TheaterModel;

public class AllReservationsView extends JFrame{

	private JFrame frame;
	private AllReservationsController allReservationsController;
	private ArrayList<ReservationModel> allReservations;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AllReservationsView window = new AllReservationsView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	 /**
	 * Create the application.
	 */
	public AllReservationsView() {
		allReservationsController = ControllerInjector.getAllReservationsController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.white);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/cinema.png").getImage().getScaledInstance(200, 160, java.awt.Image.SCALE_SMOOTH)));
		
		home = new JLabel("Home");
		home.setFont (home.getFont ().deriveFont (15.0f));
		home.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				allReservationsController.switchView(GlobalVariables.HOMEACTION);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
		about.setForeground(Color.RED);
		about.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				allReservationsController.switchView(GlobalVariables.AllRESERVATIONSACTION);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
		reservationsListBody(frame);
		
	}
	
	public void reservationsListBody(JFrame frame) {

		allReservations = allReservationsController.getReservationsForUser(GlobalVariables.user.getId());
		
		reservationsList = new JPanel();
		reservationsList.setBackground(Color.WHITE);
		reservationsList.setLayout(new GridLayout(0,3, 10 , 10));
		
		for(int i=0; i<allReservations.size(); i++) {
			final int f =i ;
			SeatModel seat = allReservationsController.getSeatById(allReservations.get(i).getSeatId());
			ProjectionModel proj = allReservationsController.getProjectionById(allReservations.get(i).getProjectionId());
			MovieModel movie = allReservationsController.getMovieById(proj.getMovieId());
			TheaterModel theater = allReservationsController.getTheatreById(proj.getTheaterId());
			
			JPanel pan = new JPanel();
			pan.setLayout(new FlowLayout());
			pan.setBackground(Color.WHITE);
			JLabel lb0 = new JLabel();
			lb0.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + movie.getPicture()).getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
			
			JPopupMenu menu = new JPopupMenu();
			JMenuItem printTicket = new JMenuItem("Print Ticket");
			printTicket.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
//					CreateTicketsPdf pdf = new CreateTicketsPdf(movie.getTitle(), theater.getDescription(), proj.getProjectionTime(), seat.getSeatRow(), seat.getSeatColumn(), proj.getPrice());
//					pdf.createPdf();
				}
				
			});
			menu.add(printTicket);
			JMenuItem cancelReserv = new JMenuItem("Cancel Reservation");
			cancelReserv.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to cancel this reservation ?" ,"Attention",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						allReservationsController.cancelReservation(allReservations.get(f));
						JOptionPane.showMessageDialog(null, "Reservation Cancelled");
						allReservationsController.switchView(GlobalVariables.AllRESERVATIONSACTION);
					}
				}
				
			});
			menu.add(cancelReserv);
			
			if(allReservationsController.employe(GlobalVariables.user.getRoleId())) {
				JMenuItem confirmReserv = new JMenuItem("Confirm Reservation");
				confirmReserv.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to confirm this reservation ?" ,"Attention",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION){
							if(allReservationsController.reservationConfirmed(allReservations.get(f))) {
								JOptionPane.showMessageDialog(null, "Reservation already confirmed!");
							}
							else {
								allReservations.get(f).setStatus(GlobalVariables.PAID);
								if(allReservationsController.confirmReservation(allReservations.get(f)))
									JOptionPane.showMessageDialog(null, "Reservation successfully confirmed!");
							}
						}
						
					}
					
				});
				menu.add(confirmReserv);
			}
			
			lb0.setComponentPopupMenu(menu);
			JPanel pan2 = new JPanel(new GridLayout(0,1));
			pan2.setBackground(Color.white);
			JLabel lb1 = new JLabel(movie.getTitle());
			JLabel lb2 = new JLabel(proj.getProjectionTime().toString());
			JLabel lb3 = new JLabel("Seat : " + seat.getSeatRow() + seat.getSeatColumn());
			JLabel lb4 = new JLabel("Price : " + proj.getPrice() + " $");
			
			pan.add(lb0);
			pan2.add(lb1);
			pan2.add(lb2);
			pan2.add(lb3);
			pan2.add(lb4);
			pan.add(pan2);
			
			reservationsList.add(pan);
		}
		
		scrollPane = new JScrollPane(reservationsList);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}


	private JPanel panel;
	private JLabel logo;
	private JLabel logout;
	private JLabel home;
	private JLabel about;
	private JPanel reservationsList;
	private JScrollPane scrollPane;
	
}
