package cinemamanagementsystem.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

import cinemamanagementsystem.Controllers.AddProjectionController;
import cinemamanagementsystem.Controllers.AdminHomeController;
import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.MovieModel;

import javax.swing.JScrollPane;

public class AdminHomeView extends JFrame {

	
	private AdminHomeController adminHomeController;
	JLabel pic = new JLabel();
	JMultilineLabel description;
	JPanel movieDetails = new JPanel();
	JButton deleteButton = new JButton("Delete");
	JButton addProjectionButton = new JButton("AddProjection");
	JLabel addMovie = new JLabel("Add Movie");

	JLabel name = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AdminHomeView window = new AdminHomeView();
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
	public AdminHomeView() {

		adminHomeController = ControllerInjector.getAdminHomeController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		addMovie.setFont(addMovie.getFont().deriveFont(25f));
		addMovie.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				adminHomeController.switchView(GlobalVariables.ADDMOVIE);
			}

		});

		this.setResizable(false);
		this.setBounds(0, 0, 450, 300);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		movieDetails.setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setSize(1920, 300);
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel);

		JLabel label_2 = new JLabel();

		JLabel label_3 = new JLabel("Movies");
		label_3.setForeground(Color.RED);
		label_3.setFont(label_3.getFont().deriveFont(15f));

		JLabel label_4 = new JLabel("Projections");
		label_4.setFont(label_4.getFont().deriveFont(15f));
		label_4.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				adminHomeController.switchView(GlobalVariables.ADMINPROJECTION);
			}

		});

		JLabel label_5 = new JLabel("Employees");
		label_5.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				adminHomeController.switchView(GlobalVariables.ADMINEMPLOYEES);
			}

		});

		label_5.setFont(label_5.getFont().deriveFont(15f));
		JLabel label_6 = new JLabel("Logout");
		label_6.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Login

				adminHomeController.switchView(GlobalVariables.LOGIN);
			}

		});

		label_6.setFont(label_5.getFont().deriveFont(15f));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 444, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(label_2).addGap(600)
						.addComponent(label_3).addGap(146).addComponent(label_4).addGap(146).addComponent(label_5)
						.addGap(146).addComponent(label_6).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 115, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(label_2))
								.addGroup(gl_panel.createSequentialGroup().addGap(85)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
												.addComponent(label_5).addComponent(label_4).addComponent(label_6))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.add(addMovie);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.white);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		JLabel now_showing = new JLabel("Now Showing");
		now_showing.setSize(200, 50);
		now_showing.setFont(label_5.getFont().deriveFont(25f));
		panel_1.add(now_showing);
		ArrayList<MovieModel> movies = adminHomeController.nowShowingMovies();
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.white);

		panel_4.setBackground(Color.white);
		panel_4.setLayout(new GridLayout(1, 1));
		for (int i = 0; i < movies.size(); i++) {
			JPanel x = new JPanel();
			x.setLayout(new FlowLayout());
			JLabel name = new JLabel(movies.get(i).getTitle());
			JLabel logo = new JLabel();
			logo.setIcon(new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + movies.get(i).getPicture())
					.getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
			x.add(logo);
			x.add(name);
			x.setBackground(Color.white);
			int index = i;
			x.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					int ind = index;
					pic.setIcon(new ImageIcon(
							new ImageIcon("src/cinemamanagementsystem/Images/" + movies.get(ind).getPicture())
									.getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
					JLabel name = new JLabel(movies.get(ind).getTitle());
					description = new JMultilineLabel(movies.get(ind).getDescription());
					movieDetails.removeAll();
					movieDetails.setLayout(new FlowLayout());
					movieDetails.add(pic);
					movieDetails.add(name);
					movieDetails.add(description);

					for (ActionListener al : addProjectionButton.getActionListeners()) {
						addProjectionButton.removeActionListener(al);
					}

					for (ActionListener al : deleteButton.getActionListeners()) {
						deleteButton.removeActionListener(al);
					}
					addProjectionButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							adminHomeController.switchView(GlobalVariables.ADMINPROJECTION);

						}
					});
					deleteButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (adminHomeController.deleteMovie(movies.get(ind)) == true) {
								panel_4.remove(x);
								panel_4.revalidate();
								panel_4.repaint();
								movieDetails.removeAll();

								movieDetails.revalidate();

								movieDetails.repaint();
							} else {
								JOptionPane.showMessageDialog(null, "You Can't delete this movie");

							}

						}
					});
					movieDetails.add(deleteButton);
					movieDetails.add(addProjectionButton);
					movieDetails.revalidate();
					movieDetails.repaint();
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
			panel_4.add(x);
		}
		JScrollPane scroll = new JScrollPane(panel_4);
		scroll.setBackground(Color.white);
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout());
		panel_3.setBackground(Color.white);
		panel_3.add(scroll, BorderLayout.NORTH);
		panel_1.add(panel_3);
		this.add(panel_1);

		JPanel panel_5 = new JPanel();
		panel_1.setBackground(Color.white);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		JLabel upcoming = new JLabel("Upcoming Movies");
		upcoming.setSize(200, 50);
		upcoming.setFont(label_5.getFont().deriveFont(25f));
		panel_5.add(upcoming);
		ArrayList<MovieModel> upmovies = adminHomeController.upcomingMovies();
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.white);

		panel_6.setBackground(Color.white);
		panel_6.setLayout(new GridLayout(1, 1));
		for (int i = 0; i < upmovies.size(); i++) {
			JPanel x = new JPanel();
			x.setLayout(new FlowLayout());
			JLabel name = new JLabel(upmovies.get(i).getTitle());
			JLabel logo = new JLabel();
			logo.setIcon(
					new ImageIcon(new ImageIcon("src/cinemamanagementsystem/Images/" + upmovies.get(i).getPicture())
							.getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
			x.add(logo);
			x.add(name);
			x.setBackground(Color.white);
			int index = i;
			x.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					int ind = index;
					pic.setIcon(new ImageIcon(
							new ImageIcon("src/cinemamanagementsystem/Images/" + upmovies.get(ind).getPicture())
									.getImage().getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH)));
					JLabel name = new JLabel(upmovies.get(ind).getTitle());
					description = new JMultilineLabel(upmovies.get(ind).getDescription());
					movieDetails.removeAll();

					movieDetails.setLayout(new FlowLayout());
					movieDetails.add(pic);
					movieDetails.add(name);
					movieDetails.add(description);
					for (ActionListener al : deleteButton.getActionListeners()) {
						deleteButton.removeActionListener(al);
					}
					deleteButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (adminHomeController.deleteMovie(movies.get(ind)) == true) {
								panel_4.remove(x);
								panel_4.revalidate();
								panel_4.repaint();
								movieDetails.removeAll();

								movieDetails.revalidate();

								movieDetails.repaint();
							} else {
								JOptionPane.showMessageDialog(null, "You Can't delete this movie");

							}

						}
					});
					movieDetails.add(deleteButton);

					movieDetails.revalidate();

					movieDetails.repaint();

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
			panel_6.add(x);
		}
		JScrollPane scroll2 = new JScrollPane(panel_6);
		scroll2.setBackground(Color.white);
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(new BorderLayout());
		panel_7.setBackground(Color.white);
		panel_7.add(scroll2, BorderLayout.NORTH);
		panel_5.add(panel_7);
		this.add(panel_5);
		this.add(movieDetails);

	}
}
