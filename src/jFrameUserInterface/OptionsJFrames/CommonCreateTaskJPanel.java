/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.OptionsJFrames;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import connectUserInterfaceWithDatabase.TaskCategoryBridge;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Abdelhalim
 */
public class CommonCreateTaskJPanel extends JPanel implements
        ICommonInterface, ICommonLayoutMethods, ActionListener {

    /**
     * declare the layout variables and its constrains.
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare the JPanel components.
     */
    JLabel jLabelTaskName,
            jLabelTaskDateAndTime,
            jLabelTaskCategory,
            jLabelEnableAlarm;
    JTextField jTextFieldTaskName,
            jTextFieldTaskDateAndTime;
    JButton jButtonDateAndTime;
    JCheckBox jCheckBoxEnableAlarm;
    JComboBox<String> jComboBoxTaskCategory;

    /**
     * class constructor.
     */
    public CommonCreateTaskJPanel() {
        start();
    }
    
    @Override
    public final void start() {
        /**
         * call method initialization to initialize all the JFrame components.
         */
        initialization();
        /**
         * call method setComponentSize to set for each component its size or
         * its location on the JFrame.
         */
        setComponentSize();
        /**
         * call method setComponentText to set text for each component on the
         * JFrame.
         */
        setComponentText();
    }
    
    @Override
    public void initialization() {

        // frist initial the layout that will be assign to the JFrame
        layout = new GridBagLayout();
        this.setLayout(layout);
        // initial the layout constraints object 
        constraints = new GridBagConstraints();

        // initial the JLabels component 
        jLabelTaskName = new JLabel();
        jLabelTaskDateAndTime = new JLabel();
        jLabelTaskCategory = new JLabel();
        jLabelEnableAlarm = new JLabel();

        // initial the JTextFields component 
        jTextFieldTaskName = new JTextField();
        jTextFieldTaskDateAndTime = new JTextField();

        // initial the JButtons components 
        jButtonDateAndTime = new JButton();

        // initial the JCheckBox component 
        jCheckBoxEnableAlarm = new JCheckBox();

        // initial the JComboBox component 
        jComboBoxTaskCategory = new JComboBox<>();

        // call this method to assign actionlister for each JButton on the JFrame
        buttonActionsIntialization();
    }
    
    @Override
    public void buttonActionsIntialization() {

        // initialize actionlister for each JButton
        jButtonDateAndTime.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        // implement for each JButton its determined action
        JButton tempButton = (JButton) e.getSource();
        switch (tempButton.getText()) {
            case "Open Calender":
                // open calender
                new DateAndTimeJFrame().show();
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
        addComponent(jTextFieldTaskName, 1, 0, constraints);
        addComponent(jLabelTaskDateAndTime, 0, 1, constraints);
        addComponent(jButtonDateAndTime, 1, 1, constraints);
        addComponent(jTextFieldTaskDateAndTime, 2, 1, constraints);
        addComponent(jLabelTaskCategory, 0, 2, constraints);
        addComponent(jComboBoxTaskCategory, 1, 2, constraints);
        addComponent(jLabelEnableAlarm, 0, 3, constraints);
        addComponent(jCheckBoxEnableAlarm, 1, 3, constraints);
    }
    
    @Override
    public void setComponentColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setComponentText() {

        // set text to JLabels components on the JFrame
        jLabelTaskName.setText("Task Name");
        jLabelTaskDateAndTime.setText("Task Date and Time");
        jLabelTaskCategory.setText("Task Category");
        jLabelEnableAlarm.setText("Enable Alarm");

        // set category in the jCombox
        ArrayList<String> comboItems = new TaskCategoryBridge().getTaskCategoryNames();
        for (int itemCounter = 0; itemCounter < comboItems.size(); itemCounter++) {
            jComboBoxTaskCategory.addItem(comboItems.get(itemCounter));
        }

        // set text to JButtons components on the JFrame
        jButtonDateAndTime.setText("Open Calender");
    }
    
    @Override
    public void addChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void addComponent(Component component, int column, int row, GridBagConstraints gridBagConstraints) {

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
