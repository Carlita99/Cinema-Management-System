package cinemamanagementsystem.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.Controllers.ReservationController;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.ReservationModel;
import cinemamanagementsystem.Models.SeatModel;

import javax.swing.GroupLayout.Alignment;

public class ReservationView extends JFrame implements ActionListener{

	public JFrame frame;
	private ReservationController reservationController;
	private int theatreId;
	private int projNb;
	private ArrayList<ProjectionModel> projections;
	private ArrayList<SeatModel> seats;
	private ArrayList<ReservationModel> reservations, createRes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationView window = new ReservationView();
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
	public ReservationView() {
		reservationController = ControllerInjector.getReservationController(this, GlobalVariables.movie.getId());
		projections = reservationController.getUpcominProjectionsForMovie(GlobalVariables.movie.getId());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
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
				reservationController.switchView(GlobalVariables.HOMEACTION);
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
		about.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				reservationController.switchView(GlobalVariables.AllRESERVATIONSACTION);
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
		getProjections(frame);
		centrePanel(frame);
	}
	
	public void getProjections(JFrame frame) {

		projectionsPanel = new JPanel();
		projectionsPanel.setBackground(Color.WHITE);
		projectionsPanel.setLayout(new GridLayout(0,1));
		
		JLabel l = new JLabel("  " + GlobalVariables.movie.getTitle() + " Projections");
		l.setFont (logout.getFont ().deriveFont (16.0f));
		projectionsPanel.add(l);
		
		radioGroup = new ButtonGroup();
		for(int i=0 ; i<projections.size() ; i++) {
			final int f =i;
			JRadioButton rb = new JRadioButton();
			rb.setBackground(Color.WHITE);
			rb.setText(projections.get(i).getProjectionTime() + " Type : " + projections.get(i).getType() + " Cost : " + projections.get(i).getPrice() + " $  ");
			radioGroup.add(rb);
			projectionsPanel.add(rb);

			rb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						projNb = f;
						theatreId = projections.get(f).getTheaterId();
						seats = reservationController.getAllSeatsByTheatreId(theatreId);
						reservations = reservationController.getReservationsForProjection(projections.get(f).getId());
						createRes = new ArrayList<>();
						changeSeats(frame);
				    }
				}
			});
			
			if(i == 0) {
				rb.setSelected(true);
				projNb = f;
				theatreId = projections.get(0).getTheaterId();
				seats = reservationController.getAllSeatsByTheatreId(theatreId);
				reservations = reservationController.getReservationsForProjection(projections.get(0).getId());
				changeSeats(frame);
			}
		}
		
		scrollPane2 = new JScrollPane(projectionsPanel);
		scrollPane2.setBorder(null);
		frame.getContentPane().add(scrollPane2, BorderLayout.WEST);
	}
	
	public void centrePanel(JFrame frame) {

		button = new JButton("Reserve");
		button.setBounds(46, 5, 150, 30);
		button.addActionListener(this);
		centrePanel = new JPanel();
		centrePanel.setBackground(Color.WHITE);
		centrePanel.setLayout(null);
		centrePanel.add(button);

		frame.getContentPane().add(centrePanel, BorderLayout.CENTER);
		
		lb1 = new JLabel();
		lb1.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/black_seat.png").getImage().getScaledInstance(45, 65, java.awt.Image.SCALE_SMOOTH)));
		lb1.setBounds(30, 110, 45, 65);
		centrePanel.add(lb1);
		
		available = new JLabel("Available");
		available.setBounds(85, 130, 150, 23);
		available.setFont (about.getFont ().deriveFont (12.0f));
		centrePanel.add(available);
		
		lb2 = new JLabel();
		lb2.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/red_seat.png").getImage().getScaledInstance(45, 65, java.awt.Image.SCALE_SMOOTH)));
		lb2.setBounds(30, 200, 45, 65);
		centrePanel.add(lb2);
		
		Reserved = new JLabel("Reserved");
		Reserved.setBounds(85, 220, 150, 23);
		Reserved.setFont (about.getFont ().deriveFont (12.0f));
		centrePanel.add(Reserved);
		
		lb3 = new JLabel();
		lb3.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/green_seat.png").getImage().getScaledInstance(45, 65, java.awt.Image.SCALE_SMOOTH)));
		lb3.setBounds(30, 290, 45, 65);
		centrePanel.add(lb3);
		
		yourSeats = new JLabel("Now Reserving");
		yourSeats.setBounds(85, 310, 150, 23);
		yourSeats.setFont (about.getFont ().deriveFont (12.0f));
		centrePanel.add(yourSeats);
		
		if(!reservationController.employe(GlobalVariables.user.getRoleId())) {
		
			lb4 = new JLabel();
			lb4.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/blue_seat.png").getImage().getScaledInstance(45, 65, java.awt.Image.SCALE_SMOOTH)));
			lb4.setBounds(30, 380, 45, 65);
			centrePanel.add(lb4);
			
			nowReserving = new JLabel("Your Reservations");
			nowReserving.setBounds(85, 400, 150, 23);
			nowReserving.setFont (about.getFont ().deriveFont (12.0f));
			centrePanel.add(nowReserving);
		}
	}
	
	public void changeSeats(JFrame frame) {
			
		if(scrollPane!=null)
			frame.getContentPane().remove(scrollPane);
		
		JPanel seatsPanel = new JPanel();
		seatsPanel.setBackground(Color.WHITE);
		
		Object [] rows = reservationController.getAllSeatRows(seats).toArray();
		Object [] cols = reservationController.getAllSeatCols(seats).toArray();
		
	
		seatsPanel.setLayout(new GridLayout(rows.length +1  ,cols.length + 1, 10, 10));
		seatsPanel.add(new JLabel("            "));
		for(int i=0; i<cols.length; i++) {
			seatsPanel.add(new JLabel("           " +cols[i].toString()));
		}

		JLabel label [];
		String color [] ;
		int index[];
		label = new JLabel [seats.size() + rows.length];
		color = new String [seats.size() + rows.length];
		index = new int[seats.size()];
		
		int k=0, p=0;
		for(int i=0;i< (seats.size() + rows.length);i++) {
			if(i % (cols.length +1 ) == 0) {
				seatsPanel.add(new JLabel("          " + rows[k]));
				k++;
				continue;
			}
			final int j =i, l=k;
			
			if("BLUE".equalsIgnoreCase(reservationController.seatReserved(seats.get(i-k).getId(), reservations))) {
				label[i] = new JLabel(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/blue_seat.png").getImage().getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH)));
				color[i] = "BLUE";
			}
			else if("RED".equalsIgnoreCase(reservationController.seatReserved(seats.get(i-k).getId(), reservations))) {
				label[i] = new JLabel(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/red_seat.png").getImage().getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH)));
				color[i] = "RED";
			}

			else {
				label[i] = new JLabel(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/black_seat.png").getImage().getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH)));
				color [i] = "BLACK";
			}
			
	        label[i].addMouseListener(new MouseAdapter() {
	    	    public void mouseClicked(MouseEvent e){  
	    	    	if("BLACK".equalsIgnoreCase(color[j])) {
	    	    		label[j].setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/green_seat.png").getImage().getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH)));
	    	    		color[j] = "GREEN";
	    	    		ReservationModel res = new ReservationModel();
	    	    		res.setProjectionId(projections.get(projNb).getId());
	    	    		res.setSeatId(seats.get(j-l).getId());
	    	    		res.setUserId(GlobalVariables.user.getId());
	    	    		res.setStatus(GlobalVariables.NOTPAID);
	    	    		createRes.add(res);
	    	    		index[j] = createRes.size()-1;
	    	    	}else 
	    	    		if("GREEN".equalsIgnoreCase(color[j])) {
	    	    			label[j].setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/black_seat.png").getImage().getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH))); 
	    	    			color[j]="BLACK";
		    	    		ReservationModel res = new ReservationModel();
		    	    		res.setProjectionId(projections.get(projNb).getId());
		    	    		res.setSeatId(seats.get(j-l).getId());
		    	    		res.setUserId(GlobalVariables.user.getId());
		    	    		res.setStatus(GlobalVariables.NOTPAID);
	    	    			createRes.remove(res);
	    	    		}
	    	    	} 
	        });
	       seatsPanel.add(label[i]);
		}
		
		scrollPane = new JScrollPane(seatsPanel);
		scrollPane.setBorder(null);
		frame.getContentPane().add(scrollPane, BorderLayout.EAST);
		frame.repaint();
		frame.revalidate();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to reserve those seats?\n Total Price = " + projections.get(projNb).getPrice() * createRes.size() + " $","Attention",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
	        reservationController.addReservation(createRes);
	        JOptionPane.showMessageDialog(null, "Your reservation has been made!");
	        reservationController.switchView(GlobalVariables.HOMEACTION);
		}
	}
	
	private JPanel panel;
	private JLabel logo;
	private JLabel logout;
	private JLabel home;
	private JLabel about;
	private ButtonGroup radioGroup;
	private JButton button;
	private JScrollPane scrollPane, scrollPane2;
	private JPanel projectionsPanel, centrePanel;
	private JLabel lb1;
	private JLabel available;
	private JLabel lb2;
	private JLabel Reserved;
	private JLabel lb3;
	private JLabel yourSeats;
	private JLabel lb4;
	private JLabel nowReserving;
}
