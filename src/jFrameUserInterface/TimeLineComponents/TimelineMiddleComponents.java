/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.TimeLineComponents;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class TimelineMiddleComponents extends JPanel
        implements ICommonInterface, ICommonLayoutMethods, ActionListener {

    /**
     * declare JPanel layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare JButtons
     */
    JPanel jPanelPosition;
    JButton jButtonPosition;

    /**
     * class constructor
     */
    public TimelineMiddleComponents() {
        start();
    }

    public void updateTimeLine(int row, int column) {

        for (Component c : this.getComponents()) {
            if (c instanceof JButton) {
                if (c.getName().equals("jButton" + column + row)) {
                    c.setEnabled(true);
                    if (column < 10 && row < 3) {
                        c.setBackground(Color.cyan);
                    } else {
                        c.setBackground(Color.yellow);
                    }
                }
            }
        }
    }

    @Override
    public final void start() {
        // call this method to initialize the JPanel components
        initialization();
        // call this method to set color to specific components
        setComponentColor();
    }

    @Override
    public void initialization() {

        // initialize JPanel layout and its constraints 
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        this.setLayout(layout);
        // initialize constraints properties
        constraints.insets = new Insets(30, 2, 30, 2);
        constraints.fill = GridBagConstraints.BOTH;

        //initialize JButtons positions
        for (int columnHours = 0; columnHours < 24; columnHours++) {
            for (int rowDays = 0; rowDays < 7; rowDays++) {
                jButtonPosition = new JButton("!");
                jButtonPosition.setName("jButton" + columnHours + rowDays);
                jButtonPosition.setEnabled(false);
                buttonActionsIntialization();
                addComponent(jButtonPosition, rowDays, columnHours, constraints);
            }
        }
    }

    @Override
    public void buttonActionsIntialization() {
        jButtonPosition.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TimelineMiddleActionJFrame().show();
    }

    @Override
    public void setComponentSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentColor() {
        // set gray color to this JPanel
        this.setBackground(Color.GRAY);
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
