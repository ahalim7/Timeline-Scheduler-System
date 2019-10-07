/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import connectUserInterfaceWithDatabase.TaskCategoryBridge;
import jFrameUserInterface.OptionsJFrames.CreateJFrame;
import jFrameUserInterface.OptionsJFrames.DeleteJFrame;
import jFrameUserInterface.OptionsJFrames.EditJFrame;
import jFrameUserInterface.OptionsJFrames.ManageJFrame;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class OptionsButtonClass extends JPanel implements ICommonInterface,
        ICommonLayoutMethods, ActionListener {

    /**
     * layout declaration
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare the system's option that will enable be exists in the program
     */
    JButton createButton,
            editButton,
            deleteButton,
            searchButton,
            refreshButton;

    public OptionsButtonClass() {
        /**
         * start declare and initialize the frame components
         */
        start();
    }

    /**
     * call all the methods in one method to be called in constructor
     */
    @Override
    public final void start() {
        /**
         * initialize what we declared
         */
        initialization();
        /**
         * set text to components
         */
        setComponentText();
        /**
         * set size to the components
         */
        setComponentSize();
        //addChildren();
    }

    @Override
    public void initialization() {

        /**
         * Initialize JPanel layout and its constraints
         */
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        /**
         * initialize JPanel layout
         */
        this.setLayout(layout);
        /**
         * initialize all option buttons
         */
        createButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        searchButton = new JButton();
        refreshButton = new JButton();


        // call this method to assign actionlister for each JButton
        buttonActionsIntialization();
    }

    @Override
    public void buttonActionsIntialization() {

        createButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        refreshButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // implement for each JButton its determined action
        JButton tempButton = (JButton) e.getSource();
        switch (tempButton.getText()) {
            case "Create":
                new CreateJFrame().show();
                break;
            case "Edit":
                new EditJFrame().show();
                break;
            case "Delete":
                new DeleteJFrame().show();
                break;
            case "Manage":
                new ManageJFrame().show();
                break;
            case "Refresh":
                break;
        }
    }

    @Override
    public void setComponentSize() {

//        createButton.setSize(50,50);
//        editButton.setSize(50,50);
//        deleteButton.setSize(50,50);
//        searchButton.setSize(50,50);
//        refreshButton.setSize(50,50);
        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JFrame components (JLabels, JPanels) and here we assign
         * constant values to weightx, weighty, and fill property.
         */
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipady = 1;
        constraints.fill = GridBagConstraints.BOTH;
        /**
         * set option buttons size and location add the option buttons to the
         * container JPanel
         */
        addComponent(createButton, 0, 0, constraints);
        addComponent(new JLabel(""), 1, 0, constraints);
        addComponent(editButton, 2, 0, constraints);
        addComponent(new JLabel(""), 3, 0, constraints);
        addComponent(deleteButton, 4, 0, constraints);
        addComponent(new JLabel(""), 5, 0, constraints);
        addComponent(searchButton, 6, 0, constraints);
        addComponent(new JLabel(""), 7, 0, constraints);
        addComponent(refreshButton, 8, 0, constraints);
        addComponent(new JLabel(""), 9, 0, constraints);
    }

    @Override
    public void setComponentColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentText() {

        /**
         * set button text
         */
        createButton.setText("Create");
        editButton.setText("Edit");
        deleteButton.setText("Delete");
        searchButton.setText("Manage");;
        refreshButton.setText("Refresh");

    }

    @Override
    public void addChildren() {
    }

    @Override
    public void addComponent(Component component, int row, int column, GridBagConstraints gridBagConstraints) {
        /**
         * implement here the gridx and gridy property to the constraints that
         * will applied on the passed component to be set in the JFrame
         * according to the GridBagLayout and after that we add the passed
         * component and its constraints to the JFrame.
         */
        constraints.gridx = column;
        constraints.gridy = row;
        this.add(component, gridBagConstraints);
    }
}
