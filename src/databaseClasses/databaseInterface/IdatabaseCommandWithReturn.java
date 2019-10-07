/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseClasses.databaseInterface;

/**
 *
 * @author Abdelhalim
 */
public interface IdatabaseCommandWithReturn {
    
    // insert method
    public int insertDataIntoTable();
    // update method
    public boolean updateDataIntoTable();
    // delete method
    public boolean deleteDataFromTable();
}
