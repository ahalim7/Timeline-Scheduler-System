/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.OptionsJFrames;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import helperClasses.ScreenSizeClass;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdelhalim
 */
public class EditJFrame extends JFrame implements
        ICommonInterface, ICommonLayoutMethods, ActionListener {

    /**
     * declare layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare the JFrame components
     */
    TaskCategoryJTree taskCategoryJTree;
    JLabel jLabelTaskName;
    JButton jButtonEdit,
            jButtonSave,
            jButtonCancel;

    /**
     * class constructor
     */
    public EditJFrame() {
        super("Edit an existing Task");
        /**
         * set location for the JFrame to be 25% from screen width and height.
         */
        this.setLocation(ScreenSizeClass.getWidth(25),
                ScreenSizeClass.getHeight(15));
        /**
         * set size for the JFrame to be 50% from screen width and 25% from
         * screen height.
         */
        this.setSize(ScreenSizeClass.getWidth(50),
                ScreenSizeClass.getHeight(65));
        // call override final method that will call other medthods
        start();
    }

    @Override
    public final void start() {
        /**
         * call the initialization method to initialize the JFrame components
         */
        initialization();
        /**
         * call the setComponentSize to locate the components on the JFrame and
         * determine the size for each component
         */
        setComponentSize();
        /**
         * call the setComponentText to set text to specific components
         */
        setComponentText();
    }

    @Override
    public void initialization() {
        // initialize layout 
        layout = new GridBagLayout();
        this.setLayout(layout);
        // initialize the layout constraints object 
        constraints = new GridBagConstraints();
        // initialize the JLabel component
        jLabelTaskName = new JLabel();
        // initialize taskCategoryJTree object
        taskCategoryJTree = new TaskCategoryJTree();
        // initialize the JButtons component
        jButtonEdit = new JButton();
        jButtonSave = new JButton();
        jButtonCancel = new JButton();
        // call this method to assign actionlister for each JButton on the JFrame
        buttonActionsIntialization();
    }

    @Override
    public void buttonActionsIntialization() {
        // initialize actionlister for each JButton
        jButtonEdit.addActionListener(this);
        jButtonSave.addActionListener(this);
        jButtonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // implement for each JButton its determined action
        JButton tempButton = (JButton) e.getSource();
        switch (tempButton.getText()) {
            case "Edit":
                new UpdateJFrame().show();
                break;
            case "Save":
                // delete action
                JOptionPane.showMessageDialog(null, "Are you Sure ?",
                        "Confirmation Dialog", JOptionPane.QUESTION_MESSAGE);
                break;
            case "Cancel":
                // cancel action
                this.dispose();
                break;
        }
    }

    @Override
    public void setComponentSize() {
        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JFrame components (JLabels, JTextFields, JButtons,
         * JCheckBoxs) and here we assign constant values to weightx, weighty,
         * and fill property.
         */
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.fill = GridBagConstraints.BOTH;

        /**
         * call this method to set the size and location for each component will
         * be exists on the JFrame and here we pass the component and its row
         * and column to the method addComponent.
         */
        addComponent(jLabelTaskName, 0, 0, constraints);
        constraints.gridwidth = 5;
        constraints.gridheight = 4;
        addComponent(taskCategoryJTree, 0, 1, constraints);
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        addComponent(jButtonEdit, 4, 1, constraints);
        addComponent(jButtonSave, 4, 2, constraints);
        addComponent(jButtonCancel, 4, 3, constraints);
    }

    @Override
    public void setComponentColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentText() {
        // set the text for JLabel
        jLabelTaskName.setText("Choose the Task");
        // set text to jButton components
        jButtonEdit.setText("Edit");
        jButtonSave.setText("Save");
        jButtonCancel.setText("Cancel");
    }

    @Override
    public void addChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
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
