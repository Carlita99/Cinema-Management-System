/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem;

import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cinemamanagementsystem.Controllers.GlobalVariables;
import cinemamanagementsystem.Views.ViewFactory;


public class CinemaManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	JFrame nextView = ViewFactory.getView(GlobalVariables.ADDMOVIE);
    }
    
}
