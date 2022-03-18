package cinemamanagementsystem.Controllers;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.UUID;

//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;

public class CreateTicketsPdf {
//	
//	String movieName, theatreName , row;
//	Timestamp movieTime;
//	int col;
//	double moviePrice;
//	
//	public CreateTicketsPdf(String movieName, String theatreName, Timestamp movieTime, String row, int col, double moviePrice) {
//		this.movieName = movieName;
//		this.theatreName = theatreName;
//		this.movieTime = movieTime;
//		this.row = row;
//		this.col = col;
//		this.moviePrice = moviePrice;
//	}
//
//	public void createPdf() {
//		
//		String uniqueID = UUID.randomUUID().toString();
//    	String FILE_NAME = "src/cinemamanagementsystem/Tickets/" + uniqueID + ".pdf";
//        Document document = new Document();
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
//            document.open();
//            
//            document.add(Image.getInstance("src/cinemamanagementsystem/Images/cinema.png"));
//            Font f2 = new Font();
//            f2.setStyle(Font.BOLDITALIC);
//            f2.setColor(BaseColor.DARK_GRAY);
//            f2.setSize(30);
//            Paragraph movie = new Paragraph(movieName +" \n\n", f2);
//            movie.setAlignment(Element.ALIGN_CENTER);
//            document.add(movie);
//            
//            Font f3 = new Font();
//            f3.setStyle(Font.BOLD);
//            f3.setColor(BaseColor.BLACK);
//            f3.setSize(18);
//            Paragraph time = new Paragraph(movieTime + "", f3);
//            time.setAlignment(Element.ALIGN_CENTER);
//            document.add(time);
//            Paragraph theatre = new Paragraph(theatreName, f3);
//            theatre.setAlignment(Element.ALIGN_CENTER);
//            document.add(theatre);
//            Paragraph seat = new Paragraph("Seat : " + row + col, f3);
//            seat.setAlignment(Element.ALIGN_CENTER);
//            document.add(seat);
//            Paragraph price = new Paragraph("Price : " +  moviePrice + " $ \n\n\n", f3);
//            price.setAlignment(Element.ALIGN_CENTER);
//            document.add(price);
//            
//            Font f4 = new Font();
//            f4.setStyle(Font.BOLDITALIC);
//            f4.setColor(BaseColor.DARK_GRAY);
//            f4.setSize(23);
//            Paragraph status = new Paragraph("Status : Not Paid", f4);
//            status.setAlignment(Element.ALIGN_CENTER);
//            document.add(status);
//
//            document.close();
//            File myfile = new File(FILE_NAME);
//            Desktop.getDesktop().open(myfile);
//            System.out.println("Done");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
               
}
