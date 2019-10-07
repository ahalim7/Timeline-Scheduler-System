/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseClasses.databaseInterface;

import java.sql.ResultSet;

/**
 *
 * @author Abdelhalim
 */
public interface IdatabaseCommand {
    
    // select method
    public ResultSet selectDataFromTable();
    // insert method
    public void insertDataIntoTable();
    // update method
    public void updateDataIntoTable();
    // delete method
    public void deleteDataFromTable();
}
