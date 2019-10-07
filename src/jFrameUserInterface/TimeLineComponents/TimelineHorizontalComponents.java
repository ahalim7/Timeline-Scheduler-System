/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.TimeLineComponents;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class TimelineHorizontalComponents extends JPanel
        implements ICommonInterface, ICommonLayoutMethods {

// JPanel that will contains the Times JLabel
    /**
     * declare JPanel layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    // declare JLabel that will contains times
    JLabel jLabelTime;

    /**
     * class constructor
     */
    public TimelineHorizontalComponents() {

        start();
    }

    @Override
    public final void start() {
        // call this method to initialize all the JPanel components
        initialization();
        // call this method to set color to specific components
        setComponentColor();
    }

    @Override
    public void initialization() {
        // initialize layout and its constraints 
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        // initialize the JPanel layout
        this.setLayout(layout);
        // initialize all 24-JLabels to equal to 24-hours in day
        for (int hoursCounter = 1; hoursCounter <= 24; hoursCounter++) {
            if (hoursCounter == 1) {
                constraints.insets = new Insets(2, 0, 2, 0);
            } else {

                constraints.insets = new Insets(2, 14, 2, 0);
            }
            if (hoursCounter < 10) {
                jLabelTime = new JLabel("0" + hoursCounter + ":00");
            } else {
                jLabelTime = new JLabel(hoursCounter + ":00");
            }
            addComponent(jLabelTime, 0, hoursCounter, constraints);
        }
    }

    @Override
    public void buttonActionsIntialization() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentColor() {
        
        // set green color to this JPanel
        this.setBackground(Color.green);
    }

    @Override
    public void setComponentText() {
        throw new UnsupportedOperationException("Not supported yet.");
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
