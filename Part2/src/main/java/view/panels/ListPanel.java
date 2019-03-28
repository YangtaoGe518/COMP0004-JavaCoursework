package view.panels;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {
    public JButton makeListButton;
    public JList patientList;
    public JList resultList;

    private JScrollPane scroller1;
    private JScrollPane scroller2;

    public ListPanel() {
        init();

        setupPanel();
        setupLayout();
    }

    private void init() {
        makeListButton = new JButton("Make List");

        patientList = new JList();
        resultList = new JList();
        //set Height and Width
        patientList.setFixedCellWidth(180);
        patientList.setFixedCellHeight(30);
        resultList.setFixedCellWidth(180);
        resultList.setFixedCellHeight(30);
        //set selection mode
        patientList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //set visible row size
        patientList.setVisibleRowCount(8);
        resultList.setVisibleRowCount(8);

        scroller1 = new JScrollPane(patientList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller2 = new JScrollPane(resultList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void setupPanel() {
        this.setSize(1280, 720);
        this.add(makeListButton);
        this.add(scroller1);
        this.add(scroller2);
    }

    private void setupLayout() {
    }
}
