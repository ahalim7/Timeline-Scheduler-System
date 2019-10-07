/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import helperClasses.DigitalClockClass;
import helperClasses.OptionsButtonClass;
import helperClasses.ScreenSizeClass;
import jFrameUserInterface.TimeLineComponents.TimelineHorizontalComponents;
import jFrameUserInterface.TimeLineComponents.TimelineMiddleComponents;
import jFrameUserInterface.TimeLineComponents.TimelineVerticalComponents;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class MainScreenJFrame extends JFrame implements ICommonInterface,
        ICommonLayoutMethods {

    /**
     * declare objects from helper classes
     */
    DigitalClockClass digitalClockClass;
    OptionsButtonClass optionsButtonClass;
    /**
     * declare objects from Timeline components
     */
    TimelineHorizontalComponents timelineHorizontalComponents;
    TimelineMiddleComponents timelineMiddleComponents;
    TimelineVerticalComponents timelineVerticalComponents;
    /**
     * set JFrame components
     */
    /**
     * layout declaration
     */
    GridBagLayout layout;
    GridBagConstraints constraints;
    /**
     * declare clockJPanel that will contains a Digital Clock, declare
     * timelineJPanel that will contains a time line view. actionJPanel that
     * will contains the option buttons.
     */
    JPanel clockJPanel,
            timelineJPanel,
            actionJPanel;
    /**
     * declare digitalClockJLabel to hold the time
     */
    JLabel digitalClockJLabel;

    /**
     * Class Constructor
     */
    public MainScreenJFrame() {
        /**
         * set size for the JFrame to be 50% from screen width and 25% from
         * screen height.
         */
        this.setSize(ScreenSizeClass.getWidth(100),
                ScreenSizeClass.getHeight(100));
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
         * first add component on to JPanel
         */
        addChildren();

        /**
         * set color to the panels
         */
        setComponentColor();

        /**
         * set size to the components
         */
        setComponentSize();
    }

    /**
     * Initialize all the global components
     */
    @Override
    public void initialization() {

        // initialize objects from helper classes
        digitalClockClass = new DigitalClockClass();
        optionsButtonClass = new OptionsButtonClass();
        // initialize timeline components
        timelineHorizontalComponents = new TimelineHorizontalComponents();
        timelineMiddleComponents = new TimelineMiddleComponents();
        timelineVerticalComponents = new TimelineVerticalComponents();
        // initialize layout and its constraints
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        // set mainScreenJFrame layout
        this.setLayout(layout);
        //Set default close operation for JFrame  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // initialize JPanels
        clockJPanel = new JPanel();
        timelineJPanel = new JPanel();
        actionJPanel = new JPanel();
        // initialize timeline components layout 
        timelineJPanel.setLayout(new BorderLayout());
        // initialize JLabels
        digitalClockJLabel = new JLabel();
    }

    @Override
    public void buttonActionsIntialization() {
        // initialize actionlister for each JButton
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * set size to all the global components
     */
    @Override
    public void setComponentSize() {

        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JFrame components (JLabels, JPanels) and here we assign
         * fill property.
         */
        constraints.fill = GridBagConstraints.BOTH;

        /**
         * call this method to set the size and location for each component will
         * be exists on the JFrame and here we pass the component and its row
         * and column to the method addComponent.
         */
        constraints.weightx = 0.2;
        constraints.weighty = 0.5;
        constraints.gridwidth = 3;
        addComponent(clockJPanel, 0, 0, constraints);
        constraints.gridwidth = 1;
        addComponent(actionJPanel, 1, 0, constraints);
        constraints.weightx = 2;
        constraints.weighty = 2;
        timelineMiddleComponents.updateTimeLine(5, 15);
        timelineMiddleComponents.updateTimeLine(3, 5);
        timelineMiddleComponents.updateTimeLine(6, 4);
        timelineMiddleComponents.updateTimeLine(1, 20);
        timelineMiddleComponents.updateTimeLine(0, 23);
        timelineMiddleComponents.updateTimeLine(1, 3);
        timelineMiddleComponents.updateTimeLine(0, 6);
        timelineMiddleComponents.updateTimeLine(1, 7);
        timelineMiddleComponents.updateTimeLine(0, 9);
        timelineMiddleComponents.updateTimeLine(2, 13);
        timelineMiddleComponents.updateTimeLine(2, 15);
        timelineMiddleComponents.updateTimeLine(3, 1);
        timelineMiddleComponents.updateTimeLine(3, 9);
        timelineMiddleComponents.updateTimeLine(5, 11);
        timelineMiddleComponents.updateTimeLine(4, 17);
        timelineMiddleComponents.updateTimeLine(2, 19);
        timelineMiddleComponents.updateTimeLine(4, 5);
        timelineMiddleComponents.updateTimeLine(4, 2);
        timelineMiddleComponents.updateTimeLine(0, 0);
        timelineMiddleComponents.updateTimeLine(2, 5);
        timelineMiddleComponents.updateTimeLine(2, 2);
        timelineMiddleComponents.updateTimeLine(2, 0);
        addComponent(timelineJPanel, 1, 2, constraints);
    }

    /**
     * set color to the needed global components
     */
    @Override
    public void setComponentColor() {

        // set panels color
        clockJPanel.setBackground(Color.black);
        timelineJPanel.setBackground(Color.gray);
        actionJPanel.setBackground(Color.DARK_GRAY);
    }

    /**
     * set text to components
     */
    @Override
    public void setComponentText() {

        // set mainScreenJFrame title
        this.setTitle("Timeline Scheduler System");
        // set digitalClockJLabel text
        digitalClockJLabel = digitalClockClass.getDigitalClock();
    }

    /**
     * add components to be children to the JFrame
     */
    @Override
    public void addChildren() {

        // add digitalClockJLabel to clockJPanel
        clockJPanel.add(digitalClockJLabel);
        // add actions button on action panel
        actionJPanel = optionsButtonClass;
        // add timeline components
        timelineJPanel.add(timelineHorizontalComponents, BorderLayout.NORTH);
        timelineJPanel.add(timelineVerticalComponents, BorderLayout.WEST);
        timelineJPanel.add(timelineMiddleComponents, BorderLayout.CENTER);
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
