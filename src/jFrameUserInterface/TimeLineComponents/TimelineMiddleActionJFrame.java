/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.TimeLineComponents;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import helperClasses.ScreenSizeClass;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Abdelhalim
 */
public class TimelineMiddleActionJFrame extends JFrame implements
        ICommonInterface, ICommonLayoutMethods, ActionListener {

    /**
     * declare layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare JFrame components
     */
    JLabel jLabelTaskName,
            jLabelTaskDateAndTime,
            jLabelTaskCategory,
            jLabelTaskColor,
            jLabelTaskFinished,
            jLabelTaskPostpone,
            jLabelTaskAlarm;
    JButton jButtonOkay;

    /**
     * class constructor
     */
    public TimelineMiddleActionJFrame() {
        super("Task Information");
        /**
         * set location for the JFrame to be 30% from screen width and 35% from
         * screen height.
         */
        this.setLocation(ScreenSizeClass.getWidth(35),
                ScreenSizeClass.getHeight(35));
        /**
         * set size for the JFrame to be 30% from screen width and 35% from
         * screen height.
         */
        this.setSize(ScreenSizeClass.getWidth(40),
                ScreenSizeClass.getHeight(30));
        // call override final method that will call other medthods 
        start();
    }

    @Override
    public final void start() {
        // initialize all the JFrame components
        initialization();
        // set text for each JFrame component
        setComponentText();
        /**
         * call method setComponentSize to set for each component its size or
         * its location on the JFrame.
         */
        setComponentSize();
    }

    @Override
    public void initialization() {
        // initialize layout and its constraints
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        this.setLayout(layout);
        // initialize JLabel components
        jLabelTaskName = new JLabel();
        jLabelTaskDateAndTime = new JLabel();
        jLabelTaskCategory = new JLabel();
        jLabelTaskColor = new JLabel();
        jLabelTaskPostpone = new JLabel();
        jLabelTaskAlarm = new JLabel();
        jLabelTaskFinished = new JLabel();
        // initialize JButton component
        jButtonOkay = new JButton();
        // call this method to assign actionlister for each JButton on the JFrame
        buttonActionsIntialization();
    }

    @Override
    public void buttonActionsIntialization() {
        // initialize actionlister for  JButton
        jButtonOkay.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // implement action for JButton
        this.dispose();
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
        addComponent(new JLabel("Leader Queue"), 0, 1, constraints);
        addComponent(jLabelTaskDateAndTime, 1, 0, constraints);
        addComponent(new JLabel("20-MAR-2013 , 16:00 pm"), 1, 1, constraints);
        addComponent(jLabelTaskCategory, 2 , 0, constraints);
        addComponent(new JLabel("Inside unit"), 2, 1, constraints);
        addComponent(jLabelTaskColor, 3, 0, constraints);
        addComponent(new JLabel("Active"), 3, 1, constraints);
        addComponent(jLabelTaskPostpone, 4, 0, constraints);
        addComponent(new JLabel("OFF"), 4, 1, constraints);
        addComponent(jLabelTaskAlarm, 5, 0, constraints);
        addComponent(new JLabel("ON"), 5, 1, constraints);
        addComponent(jLabelTaskFinished, 6, 0, constraints);
        addComponent(new JLabel("Not Finished"), 6, 1, constraints);
        constraints.gridwidth=2;
        addComponent(jButtonOkay, 7, 0, constraints);
    }

    @Override
    public void setComponentColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentText() {
        // set text for JLabel components
        jLabelTaskName.setText("Task Name");
        jLabelTaskDateAndTime.setText("Task Date And Time");
        jLabelTaskCategory.setText("Task Category");
        jLabelTaskColor.setText("Task Status");
        jLabelTaskPostpone.setText("Task Postpone");
        jLabelTaskAlarm.setText("Task Alarm");
        jLabelTaskFinished.setText("Task Finished");
        // set text for JButton component
        jButtonOkay.setText("Ok");
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
