package cinemamanagementsystem.Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import cinemamanagementsystem.Controllers.AddProjectionController;
import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.MovieModel;
import cinemamanagementsystem.Models.ProjectionModel;
import cinemamanagementsystem.Models.TheaterModel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddProjectionView extends JFrame {
	JFrame thisView = this;
	JSpinner date = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE));
	JLabel dAndT = new JLabel("Date and Time");
	JPanel panel = new JPanel();
	String types[] = { "2D", "3D" };
	ArrayList<TheaterModel> theaters = new ArrayList<TheaterModel>();
	ArrayList<MovieModel> movies = new ArrayList<MovieModel>();
	ArrayList<ProjectionModel> projections = new ArrayList<ProjectionModel>();
	JComboBox<MovieModel> movieBox;
	JComboBox<TheaterModel> theaterBox;
	JLabel movieLabel = new JLabel("Movie");
	JLabel theaterLabel = new JLabel("Theater");
	JLabel priceLabel = new JLabel("Price");
	JLabel type = new JLabel("Type");
	JComboBox<String> typesBox = new JComboBox<String>(types);
	AddProjectionController addProjectionController = ControllerInjector.getAddProjectionController(this);
	JSpinner priceSpinner = new JSpinner(new SpinnerNumberModel(10, 0, 100, 0.1));
	JButton submit = new JButton("Submit");
	JScrollPane scrollBar;
	JPanel scrollContent = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProjectionView window = new AddProjectionView();
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
	public AddProjectionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel();

		JLabel label_1 = new JLabel("Movies");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addProjectionController.switchView(GlobalVariables.ADMINHOMEPAGE);
				
			}
		});
		label_1.setFont(label_1.getFont().deriveFont(15f));

		JLabel label_2 = new JLabel("Projections");
		label_2.setFont(label_2.getFont().deriveFont(15f));
		label_2.setForeground(Color.RED);
	

		JLabel label_3 = new JLabel("Employees");
		label_3.setFont(label_3.getFont().deriveFont(15f));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addProjectionController.switchView(GlobalVariables.ADMINEMPLOYEES);
				
			}
		});
		JLabel label_4 = new JLabel("Logout");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addProjectionController.switchView(GlobalVariables.LOGIN);
				
			}
		});
		label_4.setFont(label_4.getFont().deriveFont(15f));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 444, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(label).addGap(600)
						.addComponent(label_1).addGap(146).addComponent(label_2).addGap(146).addComponent(label_3)
						.addGap(146).addComponent(label_4).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 117, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(label))
								.addGroup(gl_panel.createSequentialGroup().addGap(85)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
												.addComponent(label_3).addComponent(label_2).addComponent(label_4))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		body();
	}

	private void body() {
		movies = addProjectionController.getMovies();
		theaters = addProjectionController.getTheaters();
		projections = addProjectionController.getProjections();
		movieBox = new JComboBox<MovieModel>();
		movieBox.setModel(new DefaultComboBoxModel<MovieModel>(movies.toArray(new MovieModel[movies.size()])));
		theaterBox = new JComboBox<TheaterModel>(theaters.toArray(new TheaterModel[theaters.size()]));
		panel.setLayout(new BorderLayout());
		dAndT.setBounds(50, 150, 150, 25);
		date.setBounds(50, 200, 150, 25);
		movieLabel.setBounds(50, 250, 150, 25);
		movieBox.setBounds(50, 300, 150, 25);
		theaterLabel.setBounds(50, 350, 150, 25);
		theaterBox.setBounds(50, 400, 150, 25);
		priceLabel.setBounds(50, 550, 150, 25);
		priceSpinner.setBounds(50, 600, 150, 25);
		type.setBounds(50, 450, 150, 25);
		typesBox.setBounds(50, 500, 150, 25);
		submit.setBounds(50, 650, 150, 25);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MovieModel movie = movieBox.getItemAt(movieBox.getSelectedIndex());
				TheaterModel theater = theaterBox.getItemAt(theaterBox.getSelectedIndex());
				String type = typesBox.getItemAt(typesBox.getSelectedIndex());
				double price = (double) priceSpinner.getValue();
				Date valueOfSpinner = (Date) date.getValue();
				java.sql.Timestamp time = new java.sql.Timestamp(valueOfSpinner.getTime());
				ProjectionModel projection = new ProjectionModel();
				projection.setMovieId(movie.getId());
				projection.setPrice(price);
				projection.setProjectionTime(time);
				projection.setTheaterId(theater.getId());
				projection.setType(type);
				if (addProjectionController.addProjection(projection)) {
					movie.setStatus("Now Showing");
					addProjectionController.editMovie(movie);
					addProjectionController.switchView(GlobalVariables.ADMINPROJECTION);

				} else {
					JOptionPane.showMessageDialog(null, "Can't Add Projection, please try again later");

				}
			}
		});
		scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));
		for (ProjectionModel p : projections) {
			JLabel label = new JLabel(
					"Movie: " + p.getMovieId() + " Theater: " + p.getTheaterId() + " " + p.getProjectionTime());
			label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			JButton delete = new JButton("Delete");
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!addProjectionController.deleteProjection(p))
						JOptionPane.showMessageDialog(null, "Can't Delete Projection, please try again later");
					else
						addProjectionController.switchView(GlobalVariables.ADMINPROJECTION);

				}
			});
			scrollContent.add(label);
			scrollContent.add(delete);

		}
		scrollBar = new JScrollPane(scrollContent);
		scrollBar.setBounds(900, 150, 500, 800);
		this.add(dAndT);
		this.add(date);
		this.add(movieLabel);
		this.add(movieBox);
		this.add(theaterLabel);
		this.add(theaterBox);
		this.add(type);
		this.add(typesBox);
		this.add(type);
		this.add(priceLabel);
		this.add(priceSpinner);
		this.add(submit);
		this.add(scrollBar);
		this.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
