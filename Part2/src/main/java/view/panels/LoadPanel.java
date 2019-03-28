package view.panels;

import javax.swing.*;

public class LoadPanel extends JPanel {
    public JButton loadFileButton;
    public JButton confirmButton;
    public JLabel filePath;

    private JLabel label;
    private SpringLayout loadLayout;  // use basic layout first

    public LoadPanel(){
        init();

        setupPanel();
        //setupLayout();
    }

    private void init(){
        loadFileButton = new JButton("LoadFile");
        confirmButton = new JButton("Confirm");
        filePath = new JLabel("");
        //filePath.setText("path");
        label = new JLabel("You Choose: ");
        //loadLayout = new SpringLayout();
    }

    private void setupLayout(){
        /* add Layout information*/
        //setHorizontal
        loadLayout.putConstraint(SpringLayout.NORTH, loadFileButton, 30, SpringLayout.NORTH, this);
        loadLayout.putConstraint(SpringLayout.NORTH, confirmButton, 30, SpringLayout.NORTH, this);
        loadLayout.putConstraint(SpringLayout.NORTH, label, 30, SpringLayout.NORTH, this);
        loadLayout.putConstraint(SpringLayout.NORTH, filePath, 30, SpringLayout.NORTH, this);
        //setVertical
        loadLayout.putConstraint(SpringLayout.WEST, loadFileButton, 10, SpringLayout.EAST, this);
        //loadFileButton is the Reference
        loadLayout.putConstraint(SpringLayout.EAST, loadFileButton, 10, SpringLayout.WEST, confirmButton);
        loadLayout.putConstraint(SpringLayout.EAST, confirmButton, 10, SpringLayout.WEST, label);
        loadLayout.putConstraint(SpringLayout.EAST, label, 10, SpringLayout.WEST, filePath);
    }

    private void setupPanel(){
        this.setSize(1280,720);
        //this.setLayout(loadLayout);
        this.add(loadFileButton);
        this.add(confirmButton);
        this.add(label);
        this.add(filePath);
    }

}
