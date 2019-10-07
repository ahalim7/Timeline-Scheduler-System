/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.TimeLineComponents;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class TimelineVerticalComponents extends JPanel
        implements ICommonInterface, ICommonLayoutMethods{
// JPanel class that will contains the Days JLabel
    
    /**
     * declare JPanel layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    
    // declare JLabels for days
    JLabel dayOne,
            dayTwo,
            dayThree,
            dayFour,
            dayFive,
            daySix,
            daySeven;
    /**
     * class constructor 
     */
    public TimelineVerticalComponents() {
        
        start();
    }

    @Override
    public final void start() {
        // call this method to initialize the JPanel components
        initialization();
        // call this method to set text to specific components
        setComponentText();
        // call this method to set color to specific components
        setComponentColor();
        // call this method to set the size and location foreach component
        setComponentSize();
    }

    @Override
    public void initialization() {
        
        // initialize layout and its constaints 
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        // initialize JPanel Layout 
        this.setLayout(layout);
        
        // initialize JLabels
        dayOne = new JLabel();
        dayTwo = new JLabel();
        dayThree = new JLabel();
        dayFour = new JLabel();
        dayFive = new JLabel();
        daySix = new JLabel();
        daySeven = new JLabel();
    }

    @Override
    public void buttonActionsIntialization() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentSize() {
        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JFrame components (JLabels, JPanels) and here we assign
         * fill property.
         */
        constraints.insets = new Insets(15, 2, 12, 5);
        constraints.fill = GridBagConstraints.BOTH;

        /**
         * call this method to set the size and location for each component will
         * be exists on the JFrame and here we pass the component and its row
         * and column to the method addComponent.
         */
        addComponent(dayOne, 0, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 1, 0, constraints);
        addComponent(dayTwo, 2, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 3, 0, constraints);
        addComponent(dayThree, 4, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 5, 0, constraints);
        addComponent(dayFour, 6, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 7, 0, constraints);
        addComponent(dayFive, 8, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 9, 0, constraints);
        addComponent(daySix, 10, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 11, 0, constraints);
        addComponent(daySeven, 12, 0, constraints);
        addComponent(new JLabel("5/2/2013"), 13, 0, constraints);
    }

    @Override
    public void setComponentColor() {
        // set green color to this JPanel
        this.setBackground(Color.green);
    }

    @Override
    public void setComponentText() {
        
        // set text to all JLabels
        dayOne.setText("Saturday");
        dayTwo.setText("Sunday");
        dayThree.setText("Monday");
        dayFour.setText("Tuesday");
        dayFive.setText("Wednesday");
        daySix.setText("Thursday");
        daySeven.setText("Friday");
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
