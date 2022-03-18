/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Models;

public class SeatModel {
    private int id;
    private int theaterId;
    private String seatRow;
    private int seatColumn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    
    @Override
    public boolean equals(Object o) {	
    	if(o instanceof SeatModel) {
    		SeatModel seat = (SeatModel) o;
    		return (seat.seatRow == this.seatRow && seat.seatColumn == this.seatColumn);
    	}
    	return false;
    }
    
}
