package cinemamanagementsystem.Views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cinemamanagementsystem.Models.MovieModel;

public class MovieDetailsView {
	
	private MovieModel movieModel;
	private JPanel panel1;
	
	public MovieDetailsView(MovieModel movieModel, JPanel panel1) {
		this.movieModel = movieModel;
		this.panel1 = panel1;
	}
	
	public void insertDetails() {
		JLabel title = new JLabel(movieModel.getTitle() + "\n\n");
		title.setFont (title.getFont ().deriveFont (18.0f));
		JLabel pg = new JLabel( "PG : " + movieModel.getPg());
		JLabel duration = new JLabel("Duration : " + movieModel.getDuration());
		JLabel status = new JLabel(movieModel.getStatus());
		panel1.add(title);
		panel1.add(pg);
		panel1.add(duration);
		panel1.add(status);
	}

}
