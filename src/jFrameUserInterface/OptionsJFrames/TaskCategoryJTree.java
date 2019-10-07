/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.OptionsJFrames;

import commonInterfaces.IJTreeMethod;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Abdelhalim
 */
public class TaskCategoryJTree extends JScrollPane implements IJTreeMethod{
    
    DefaultMutableTreeNode treeRootCategory,
            treeNode;
    JTree jTreeTaskView;
    
    /**
     * class constructor
     */
    public TaskCategoryJTree(){
        // call this method to initalize all the JTree parent and child
        createJTreeComponent();
        
    }
    
    @Override
    public final void createJTreeComponent() {
        // initialize the JTree component
        treeRootCategory = new DefaultMutableTreeNode("Task Category");
        // initialize all tree nodes
        treeNode = new DefaultMutableTreeNode("Visiting with Arkan Egyptain Forces");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("Meeting with Stuff");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("Office meeting with  manager");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("watch task");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("Second Army visiting");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("Third Army visiting");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("Compition with second army");
        treeRootCategory.add(treeNode);
        treeNode = new DefaultMutableTreeNode("compition with third army");
        treeRootCategory.add(treeNode);
        jTreeTaskView = new JTree(treeRootCategory);
        this.getViewport().add(jTreeTaskView);
    }
}
