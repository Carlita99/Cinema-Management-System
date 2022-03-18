/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Models.ReservationModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReservationModelMapper implements IMapper<ReservationModel>{

    @Override
    public ReservationModel mapModel(ResultSet rs) throws SQLException {
        ReservationModel reservation = new ReservationModel();
        rs.next();
        reservation.setId(rs.getInt("id"));
        reservation.setSeatId(rs.getInt("seatId"));
        reservation.setProjectionId(rs.getInt("projectionId"));
        reservation.setUserId(rs.getInt("userId"));
        reservation.setStatus(rs.getString("status"));
        return reservation;
    }

    @Override
    public ArrayList<ReservationModel> mapList(ResultSet rs) throws SQLException {
        ArrayList<ReservationModel> reservationList = new ArrayList<>();
        while (rs.next()) {
            ReservationModel reservation = new ReservationModel();
            reservation.setId(rs.getInt("id"));
            reservation.setSeatId(rs.getInt("seatId"));
            reservation.setProjectionId(rs.getInt("projectionId"));
            reservation.setUserId(rs.getInt("userId"));
            reservation.setStatus(rs.getString("status"));
            reservationList.add(reservation);
        }    
        return reservationList;
    }
    
}
