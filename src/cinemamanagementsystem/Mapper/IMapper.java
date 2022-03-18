/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public interface IMapper <T>{
    /**
     * maps to a single object
     * @param rs
     * @return
     * @throws SQLException 
     */
    public T mapModel(ResultSet rs) throws SQLException;
    /**
     * maps to a list of objects
     * @param rs
     * @return
     * @throws SQLException 
     */
    public ArrayList<T> mapList(ResultSet rs) throws SQLException;
    
}
