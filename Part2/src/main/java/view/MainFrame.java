package view;

import controller.MainController;

import javax.swing.*;

public class MainFrame extends JFrame {
    /**
     * ref to the MainPanel
     */
    private MainPanel basePanel;

    /**
     * Create a MainFrame object passing a ref to the MainController for using by the MainFrame Object
     * @param baseController  The reference to the MainController
     */
    public MainFrame (MainController baseController){
        super("Patient Management System");

        basePanel = new MainPanel(baseController);
        setupFrame();
    }

    /**
     * Set the content Panel, size and makes the frame visible
     */
    private void setupFrame(){
        this.setContentPane(basePanel); //display when load the app
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setVisible(true);
    }

    public MainPanel getBasePanel() {
        return basePanel;
    }
}