/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrameUserInterface.OptionsJFrames;

import commonInterfaces.ICommonInterface;
import commonInterfaces.ICommonLayoutMethods;
import helperClasses.ScreenSizeClass;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Abdelhalim
 */
public class ManageJFrame extends JFrame implements
        ICommonInterface, ICommonLayoutMethods, ActionListener {

    /**
     * declare JFrame layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints,
            jPanelSearchConstraints,
            jPanelViewConstraints;
    /**
     * declare JPanel components
     */
    JPanel jPanelSearch,
            jPanelView;
    /**
     * declare JPanelSearch components
     */
    JLabel jLabelKeyword,
            jLabelSearchTarget;
    JTextField jTextFieldKeyword;
    JComboBox<String> jComboSearchTarget;
    JButton jButtonSearch,
            jButtonPostpone,
            jButtonFinish;

    /**
     * class constructor
     */
    public ManageJFrame() {
        // set title to JFrame
        super("Manage Tasks");
        /**
         * set location for the JFrame to be 25% from screen width and height.
         */
        this.setLocation(ScreenSizeClass.getWidth(20),
                ScreenSizeClass.getHeight(15));
        /**
         * set size for the JFrame to be 50% from screen width and 25% from
         * screen height.
         */
        this.setSize(ScreenSizeClass.getWidth(70),
                ScreenSizeClass.getHeight(70));
        // call override final method that will call other medthods 
        start();
    }

    @Override
    public final void start() {
        // initialize JFrame components
        initialization();
        // set text to JFrame components
        setComponentText();
        // set color to JFrame components
        setComponentColor();
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
        // initialize JPanel  and its layout
        jPanelSearch = new JPanel(new GridBagLayout());
        jPanelView = new JPanel(new GridBagLayout());
        // initialize all the JPanelSearch and JPanelView components
        createJPanelSearch();
        createJPanelView();
        // call this method to assign actionlister for each JButton on the JFrame
        buttonActionsIntialization();
    }

    @Override
    public void buttonActionsIntialization() {
        // intialize JButton actionlister
        jButtonSearch.addActionListener(this);
        jButtonPostpone.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // implement for each JButton its determined action
        JButton tempButton = (JButton) e.getSource();
        switch (tempButton.getText()) {
            case "Search":
                // action
                break;
            case "Postpone":
                // action
                break;
            case "Finish":
                // action
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
        addComponent(jPanelSearch, 0, 0, constraints);
        addComponent(jPanelView, 2, 0, constraints);
    }

    @Override
    public void setComponentColor() {
        // set color to JPanel components
        jPanelSearch.setBackground(Color.orange);
        jPanelView.setBackground(Color.gray);
    }

    @Override
    public void setComponentText() {
        /**
         * set text to JPanelSearch components
         */
        jLabelKeyword.setText("Search Keyword");
        jLabelSearchTarget.setText("Search By");
        jComboSearchTarget.addItem("Name");
        jComboSearchTarget.addItem("Date");
        jComboSearchTarget.addItem("Time");
        jButtonSearch.setText("Search");
        jButtonPostpone.setText("Postpone");
        jButtonFinish.setText("Finish");
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

    // implement this method to organize components inside JPanels
    public void addJPanelComponent(Component component, int row, int column,
            GridBagConstraints gridBagConstraints, JPanel jPanel) {
        /**
         * implement here the gridx and gridy property to the constraints that
         * will applied on the passed component to be set in the JFrame
         * according to the GridBagLayout and after that we add the passed
         * component and its constraints to the JFrame.
         */
        constraints.gridx = column;
        constraints.gridy = row;
        jPanel.add(component, gridBagConstraints);
    }

    // implement this method to create all the JPanelSearch components
    private void createJPanelSearch() {

        // initialize JPanelSearch layout constraints
        jPanelSearchConstraints = new GridBagConstraints();
        /**
         * initialize JPanelSearch components
         */
        jLabelKeyword = new JLabel();
        jLabelSearchTarget = new JLabel();
        jTextFieldKeyword = new JTextField();
        jComboSearchTarget = new JComboBox<>();
        jButtonSearch = new JButton();
        jButtonPostpone = new JButton();
        jButtonFinish = new JButton();

        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JPanelSearch components (JLabels, JTextFields, JButtons,
         * JCheckBoxs) and here we assign constant values to weightx, weighty,
         * and fill property.
         */
        jPanelSearchConstraints.weightx = 0.5;
        jPanelSearchConstraints.weighty = 0.5;
        jPanelSearchConstraints.insets = new Insets(4, 4, 4, 4);
        jPanelSearchConstraints.fill = GridBagConstraints.HORIZONTAL;

        /**
         * call this method to set the size and location for each component will
         * be exists on the JPanelSearch and here we pass the component and its
         * row and column to the method addComponent.
         */
        addJPanelComponent(jLabelKeyword, 0, 0, jPanelSearchConstraints, jPanelSearch);
        jPanelSearchConstraints.gridwidth = 1;
        addJPanelComponent(jTextFieldKeyword, 0, 1, jPanelSearchConstraints, jPanelSearch);
        jPanelSearchConstraints.gridwidth = 1;
        addJPanelComponent(jLabelSearchTarget, 0, 2, jPanelSearchConstraints, jPanelSearch);
        addJPanelComponent(jComboSearchTarget, 0, 3, jPanelSearchConstraints, jPanelSearch);
        addJPanelComponent(jButtonSearch, 1, 0, jPanelSearchConstraints, jPanelSearch);
        addJPanelComponent(jButtonPostpone, 1, 1, jPanelSearchConstraints, jPanelSearch);
        addJPanelComponent(jButtonFinish, 1, 2, jPanelSearchConstraints, jPanelSearch);
    }
    // implement this method to create all the JPanelView components

    private void createJPanelView() {
        // initialize JPanelView layout constraints
        jPanelViewConstraints = new GridBagConstraints();
        /**
         * initialize JPanelView components
         */
        
        TableModel tableModelTask = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return 10;
            }

            @Override
            public int getColumnCount() {
                return 10;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return (rowIndex*columnIndex);
            }
        };
        JTable jTableTaskViewer = new JTable(tableModelTask);
        JScrollPane jScrollPaneTable = new JScrollPane(jTableTaskViewer);
        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JPanelSearch components (JLabels, JTextFields, JButtons,
         * JCheckBoxs) and here we assign constant values to weightx, weighty,
         * and fill property.
         */
        jPanelViewConstraints.weightx = 0.5;
        jPanelViewConstraints.weighty = 0.5;
        jPanelViewConstraints.insets = new Insets(4, 4, 4, 4);
        jPanelViewConstraints.fill = GridBagConstraints.HORIZONTAL;

        /**
         * call this method to set the size and location for each component will
         * be exists on the JPanelSearch and here we pass the component and its
         * row and column to the method addComponent.
         */
        addJPanelComponent(jScrollPaneTable, 0, 0, jPanelViewConstraints, jPanelView);
    }
}
