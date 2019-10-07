/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectUserInterfaceWithDatabase;

import databaseClasses.databaseCommand.TaskCategory;
import java.util.ArrayList;

/**
 *
 * @author Abdelhalim
 */
public class TaskCategoryBridge {

    /**
     * declare TaskCategory object
     */
    TaskCategory taskCategoryObject = new TaskCategory();

    /**
     * class constructor
     */
    public TaskCategoryBridge() {
    }

    /**
     * get all the task category names
     */
    public ArrayList<String> getTaskCategoryNames() {
        return taskCategoryObject.getAllTaskCategoryNames();
    }
}
