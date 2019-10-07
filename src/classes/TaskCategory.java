/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseClasses.databaseCommand;

import databaseClasses.ConvertBetweenDataTypes;
import databaseClasses.databaseConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class TaskCategory {

    /**
     * declare object from ConvertBetweenDataTypes class
     */
    ConvertBetweenDataTypes convertBetweenDataTypes;
    /**
     * Statement object and CallableStatement object
     */
    Statement statement;
    CallableStatement callableStatement;
    /**
     * declare ArrayList
     */
    ArrayList<String> resultTaskCategoryNames;

    /**
     * class constructor
     */
    public TaskCategory() {

        // initialize objects
        convertBetweenDataTypes = new ConvertBetweenDataTypes();
    }
    /**
     * get all the task category
     */
    private ResultSet resultSetTaskCategoryNames;

    public ArrayList<String> getAllTaskCategoryNames() {
        resultTaskCategoryNames = new ArrayList<>();
        try {
            DBConnection.openConnection();
            String procedureCall = "CALL GetAllTaskCategoryNames";
            callableStatement = DBConnection.getConnection().prepareCall(procedureCall);
            resultSetTaskCategoryNames = callableStatement.executeQuery();
            resultTaskCategoryNames =
                    convertBetweenDataTypes.convertResultSetIntoArrayList(
                    resultSetTaskCategoryNames, new String[]{"categoryName"});
            //DBConnection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TaskCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultTaskCategoryNames;
    }
}
