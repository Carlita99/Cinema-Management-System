/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.SeatModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeatModelMapper implements IMapper<SeatModel>{

    @Override
    public SeatModel mapModel(ResultSet rs) throws SQLException {
        SeatModel seat = new SeatModel();
        rs.next();
        seat.setId(rs.getInt("id"));
        seat.setTheaterId(rs.getInt("theaterId"));
        seat.setTheaterId(rs.getInt("theaterId"));
        seat.setSeatRow(rs.getString("seatRow"));
        seat.setSeatColumn(rs.getInt("seatColumn"));
        return seat;
    }

    @Override
    public ArrayList<SeatModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<SeatModel> seatList = new ArrayList<>();
        while (rs.next()) {
            SeatModel seat = new SeatModel();
            seat.setId(rs.getInt("id"));
            seat.setTheaterId(rs.getInt("theaterId"));
            seat.setTheaterId(rs.getInt("theaterId"));
            seat.setSeatRow(rs.getString("seatRow"));
            seat.setSeatColumn(rs.getInt("seatColumn"));
            seatList.add(seat);
        }    
        return seatList;
    }
    
}
