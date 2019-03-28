package view.panels;

import javax.swing.*;

public class SavePanel extends JPanel {
    public JButton convertButton;
    public JButton saveButton;
    public JTextArea JSONFile;
    public JScrollPane scroller;

    private SpringLayout loadLayout;  // use basic layout first

    public SavePanel(){
        init();

        setupPanel();
        //setupLayout();
    }

    private void init(){
        convertButton = new JButton("Convert");
        saveButton = new JButton("Save");
        JSONFile = new JTextArea("");
        JSONFile.setColumns(31);
        JSONFile.setRows(20);
        scroller = new JScrollPane(JSONFile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //loadLayout = new SpringLayout();
    }

    private void setupLayout(){
        /* add Layout information*/

    }

    private void setupPanel(){
        this.setSize(1280,720);
        //this.setLayout(loadLayout);
        this.add(convertButton);
        this.add(saveButton);
        this.add(scroller);
    }


}

