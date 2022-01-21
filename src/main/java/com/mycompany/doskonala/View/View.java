package com.mycompany.doskonala.View;

/**
 *
 * @author
 * @version 1
 */

import com.mycompany.doskonala.Controller.ControllerExceptionHandler;
import com.mycompany.doskonala.Model.Model;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
    Class of model*/
public class View  extends JFrame  {

    //Tworzymy naszą ramkę widokową aplikacji
    private JFrame jFrame = new JFrame();
    private JButton buttonFindPerfectNumber = new JButton("Find Perfect Numbers");
    private JTextField jTextField1 = new JTextField("",JTextField.CENTER);
    private JTextField jTextField2 = new JTextField("",JTextField.CENTER);
    private JLabel jLabelWelcome = new JLabel("Welcome in program to calculate Perfect Numbers for you! ", JLabel.CENTER);
    private JLabel jLabelLowerValue = new JLabel("Please Type lower value of compartment: ", JLabel.CENTER);
    private JLabel jLabelHigherValue = new JLabel("Please Type higher value of compartment: ", JLabel.CENTER);
    private JLabel resultsLabel = new JLabel("Perfect Number are: ", JLabel.CENTER);
    private JLabel results = new JLabel("",JLabel.CENTER);
    private JTree jTree;
      /**
       Show dialog suggest to type lower compartment value*/

    public void initComponents(){
        /**
        Creating frame with close operation layout and visible */
        jFrame.setBounds(0,0,400,400);
        jFrame.setVisible(true);
        jFrame.setLayout(new GridLayout(9,1));
        jFrame.setDefaultCloseOperation(3);
        jFrame.setName("Perfect Numbers");
        /**
        Adding all elements on frame */
        jFrame.add(jLabelWelcome);
        jFrame.add(jLabelLowerValue);
        jFrame.add(jTextField1);
        jFrame.add(jLabelHigherValue);
        jFrame.add(jTextField2);
        jFrame.add(buttonFindPerfectNumber);
        jFrame.add(resultsLabel);
        jFrame.add(results);
        jFrame.getContentPane();
        buttonShowResults();

        /**
        Creating Tree **/
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("The Java Series");
        createNodes(top);
        jTree = new JTree(top);
        JScrollPane treeView = new JScrollPane(jTree);
        jFrame.add(treeView);
        jFrame.pack();

        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     Function create button , when we click on button we show results on JLabel */
    public void buttonShowResults()  {
        buttonFindPerfectNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model model = new Model();
                try {
                    model.setLower(model.checkLowerCompartments(Integer.valueOf(jTextField1.getText().toString())));
                    model.setHigher(model.checkHigherCompartments(Integer.valueOf(jTextField2.getText().toString())));
                    results.setText(model.findPerfectNumberBetweenLowerAndHigher(model.getLower(), model.getHigher()).toString());
                } catch (ControllerExceptionHandler ex) {
                    showErrorMessage();
                }
            }
        });
    }
    /**
     Function reaction for error that push error message */
    private void showErrorMessage(){
        JOptionPane.showMessageDialog(rootPane,"Wrong lower or higher value. Please correct.");
    }
    /**
     Function fill JTree */
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode project = null;
        category = new DefaultMutableTreeNode("Tree Example");
        top.add(category);
        project = new DefaultMutableTreeNode("The Java Tutorial: 1st Example");
        category.add(project);
        project = new DefaultMutableTreeNode("The Java Tutorial: 2nd Example");
        category.add(project);
        project = new DefaultMutableTreeNode("The Java Tutorial: 3rd Example");
        category.add(project);
    }
}