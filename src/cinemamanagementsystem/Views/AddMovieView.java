package cinemamanagementsystem.Views;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import cinemamanagementsystem.Controllers.AddMovieController;
import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.DependencyInjector.ControllerInjector;
import cinemamanagementsystem.Models.MovieModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddMovieView extends JFrame {

	AddMovieController addMovieController = ControllerInjector.getAddMovieController(this);
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label_2 = new JLabel("Projections");
	JLabel label_1 = new JLabel("Movies");
	JLabel label_4 = new JLabel("Logout");
	GroupLayout gl_panel = new GroupLayout(panel);
	JLabel label_3 = new JLabel("Employees");
	JPanel form = new JPanel();
	JTextField title;
	JLabel tit = new JLabel("Title");
	JTextArea description;
	JLabel desc = new JLabel("Description");
	SpinnerNumberModel model = new SpinnerNumberModel(13, 0, 21, 1);
	SpinnerNumberModel mins = new SpinnerNumberModel(100, 0, 360, 1);
	JSpinner minutes = new JSpinner(mins);
	String extension;
	JSpinner pg = new JSpinner(model);
	JLabel pgl = new JLabel("PG");
	JLabel dur = new JLabel("Duration");
	String statusValues[] = { "Now Showing", "Coming Soon" };
	JComboBox<String> status = new JComboBox<String>(statusValues);
	JLabel statyus = new JLabel("Status");
	JFileChooser pic = new JFileChooser();
	JLabel image = new JLabel("Image");
	// Fields for preview
	JLabel titleRes = new JLabel();
	JLabel pgRes = new JLabel();
	JMultilineLabel descRes;
	JLabel statusRes = new JLabel();
	JLabel imageRes = new JLabel();
	JLabel durationRes = new JLabel();
	JButton chooseImage = new JButton("Choose image");
	ImageIcon img = null;
	JButton submit = new JButton("Save");
	Image imgToSave = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovieView window = new AddMovieView();
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
	public AddMovieView() {
		// header init

		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		label_1.setForeground(Color.RED);
		label_1.setFont(label_1.getFont().deriveFont(15f));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addMovieController.switchView(GlobalVariables.ADDMOVIE);
				
			}
		});
		label_2.setFont(label_2.getFont().deriveFont(15f));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addMovieController.switchView(GlobalVariables.ADMINPROJECTION);
				
			}
		});
		label_3.setFont(label_3.getFont().deriveFont(15f));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addMovieController.switchView(GlobalVariables.ADMINEMPLOYEES);
				
			}
		});
		label_4.setFont(label_4.getFont().deriveFont(15f));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addMovieController.switchView(GlobalVariables.LOGIN);
				
			}
		});
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 444, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(label).addGap(600)
						.addComponent(label_1).addGap(146).addComponent(label_2).addGap(146).addComponent(label_3)
						.addGap(146).addComponent(label_4).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 115, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(label))
								.addGroup(gl_panel.createSequentialGroup().addGap(85)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
												.addComponent(label_3).addComponent(label_2).addComponent(label_4))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		body();
		initialize();

	}

	private void body() {
		form.setLayout(null);
		title = new JTextField(20);
		description = new JTextArea();

		tit.setBounds(50, 0, 150, 25);
		title.setBounds(50, 25, 200, 25);
		desc.setBounds(50, 75, 150, 25);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		description
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		description.setBounds(50, 100, 300, 100);
		pgl.setBounds(50, 225, 150, 25);
		pg.setBounds(50, 250, 150, 25);
		dur.setBounds(50, 300, 150, 25);
		minutes.setBounds(50, 325, 150, 25);
		statyus.setBounds(50, 375, 150, 25);
		status.setBounds(50, 400, 150, 25);
		image.setBounds(50, 450, 150, 25);
		chooseImage.setBounds(50, 475, 150, 25);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = "src\\cinemamanagementsystem\\Images\\" + title.getText() + extension;
				System.out.println(path);
				boolean result = false;
				if (tit.getText() != "" && desc.getText() != "" && durationRes.getText() != ""
						&& statusRes.getText() != "" && image != null) {
					try {
						BufferedImage bi = (BufferedImage) imgToSave;
						result = ImageIO.write(bi, extension.substring(1), new File(path));
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (result == true) {
						MovieModel movie = new MovieModel();
						movie.setTitle(title.getText());
						movie.setDescription(description.getText());
						movie.setPg(pgRes.getText());
						movie.setStatus(statusRes.getText());
						movie.setPicture(title.getText() + extension);
						int time = (int) minutes.getValue();
						movie.setDuration(new Time(time / 60, time % 60, 0));
						if(addMovieController.addMovie(movie)) {
							addMovieController.switchView(GlobalVariables.ADMINHOMEPAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Movie Not Added, please try again");

						}

					} else {
						JOptionPane.showMessageDialog(null, "Image not saved, please try again");

					}
				}

			}
		});
		submit.setBounds(50, 525, 150, 25);

		title.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				titleRes.setText(title.getText());

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				titleRes.setText(title.getText());

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		description.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				descRes.setText(description.getText());

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				descRes.setText(description.getText());

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				descRes = null;
				descRes = new JMultilineLabel(description.getText());

			}
		});

		// TODO add duration listener
		pg.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pgRes.setText(pg.getValue().toString());

			}
		});

		status.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				statusRes.setText(status.getItemAt(status.getSelectedIndex()));

			}
		});
		// TODO format, duration, image

		minutes.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int time = (int) minutes.getValue();
				NumberFormat formatter = new DecimalFormat("00");
				String res = "" + formatter.format(time / 60) + ":" + formatter.format(time % 60) + ":00";
				durationRes.setText(res);

			}
		});

		descRes = new JMultilineLabel("");
		titleRes.setBounds(1350, 50, 150, 25);
		descRes.setBounds(1220, 75, 500, 50);
		durationRes.setBounds(1350, 150, 150, 25);
		pgRes.setBounds(1350, 200, 150, 25);
		statusRes.setBounds(1350, 250, 150, 25);
		imageRes.setBounds(800, 50, 500, 500);
		chooseImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pic.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));

				pic.setAcceptAllFileFilterUsed(true);
				int returnVal = pic.showOpenDialog(new JFrame());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File(pic.getSelectedFile().getAbsolutePath());
					String filename = pic.getSelectedFile().getName();
					try {
						img = new ImageIcon(ImageIO.read(file));
						imgToSave = ImageIO.read(file);
						extension = filename.substring(filename.lastIndexOf("."), filename.length());

						System.out.println(extension);

						imageRes.setIcon(
								new ImageIcon(img.getImage().getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
						form.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}

		});
//		
//		pic.addChoosableFileFilter(new ImageFilter());
//
//		pic.setAcceptAllFileFilterUsed(true);
		form.add(titleRes);
		form.add(descRes);
		form.add(durationRes);
		form.add(pgRes);
		form.add(statusRes);
		form.add(imageRes);

		form.add(tit);
		form.add(title);
		form.add(desc);
		form.add(description);
		form.add(pgl);
		form.add(pg);
		form.add(dur);
		form.add(minutes);
		form.add(statyus);
		form.add(status);
		form.add(image);
		form.add(chooseImage);
		form.add(submit);
		form.setBackground(Color.WHITE);
	}

	private void initialize() {
		this.getContentPane().setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(form, BorderLayout.CENTER);
		this.setBounds(100, 100, 450, 300);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
