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

/**
 *
 * @author Abdelhalim
 */
public class UpdateJFrame extends JFrame implements
        ICommonInterface, ICommonLayoutMethods,
        ActionListener {

    /**
     * declare the layout variables and its constrains.
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare the JFrame components.
     */
    CommonCreateTaskJPanel commonCreateTaskJPanel;
    JButton jButtonUpdate,
            jButtonCancel;

    /**
     * class constructor
     */
    public UpdateJFrame() {
        
        super("Update an existing task");
        /**
         * set location for the JFrame to be 25% from screen width and height.
         */
        this.setLocation(ScreenSizeClass.getWidth(25),
                ScreenSizeClass.getHeight(25));
        /**
         * set size for the JFrame to be 50% from screen width and 25% from
         * screen height.
         */
        this.setSize(ScreenSizeClass.getWidth(50),
                ScreenSizeClass.getHeight(25));
        // call override final method that will call other medthods 
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

        // initial the CommonCreateTaskJPanel object
        commonCreateTaskJPanel = new CommonCreateTaskJPanel();

        // initial the JButtons components 
        jButtonUpdate = new JButton();
        jButtonCancel = new JButton();


        // call this method to assign actionlister for each JButton on the JFrame
        buttonActionsIntialization();
    }

    @Override
    public void buttonActionsIntialization() {

        // initialize actionlister for each JButton
        jButtonUpdate.addActionListener(this);
        jButtonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // implement for each JButton its determined action
        JButton tempButton = (JButton) e.getSource();
        switch (tempButton.getText()) {
            case "Update":
                // update action

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
        constraints.gridwidth = 4;
        addComponent(commonCreateTaskJPanel, 0, 0, constraints);
        constraints.gridwidth = 1;
        addComponent(jButtonUpdate, 1, 1, constraints);
        addComponent(jButtonCancel, 2, 1, constraints);
    }

    @Override
    public void setComponentColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComponentText() {

        // set text to JButtons components on the JFrame
        jButtonUpdate.setText("Update");
        jButtonCancel.setText("Cancel");
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
