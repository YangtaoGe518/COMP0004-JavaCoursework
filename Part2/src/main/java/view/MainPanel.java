package view;

import controller.Listeners;
import controller.MainController;
import view.panels.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {
    private MainController baseController;
    private Listeners l;

    private SpringLayout baseLayout;

    private LoadPanel loadPanel;
    private SavePanel savePanel;
    private ListPanel listPanel;
    private DisplayPanel displayPanel;
    private SearchPanel searchPanel;
    private StatisticPanel statisticPanel;

    public MainPanel(MainController baseController){
        this.baseController = baseController;
        l = new Listeners(this.baseController); // controller contains in the listeners class
        init();

        setupPanel();
        setupLayout();
        setupListeners();
    }

    private void init(){
        loadPanel = new LoadPanel();
        savePanel = new SavePanel();
        listPanel = new ListPanel();
        displayPanel = new DisplayPanel();
        searchPanel = new SearchPanel();
        statisticPanel = new StatisticPanel();

        baseLayout = new SpringLayout();
    }

    /**
     * make setup for three perspectives
     */
    private void setupLayout(){
        /* add Layout information*/
        //loadPanel
        baseLayout.putConstraint(SpringLayout.NORTH, loadPanel, 10, SpringLayout.NORTH, this);
        baseLayout.putConstraint(SpringLayout.WEST, loadPanel, 5, SpringLayout.WEST, this);
        //savePanel
        baseLayout.putConstraint(SpringLayout.NORTH, savePanel, 10, SpringLayout.SOUTH, loadPanel);
        baseLayout.putConstraint(SpringLayout.WEST, savePanel, 5, SpringLayout.WEST, this);
        //listPanel
        baseLayout.putConstraint(SpringLayout.NORTH, listPanel, 10, SpringLayout.SOUTH, savePanel);
        baseLayout.putConstraint(SpringLayout.WEST, listPanel, 5, SpringLayout.WEST, this);
        //displayPanel
        baseLayout.putConstraint(SpringLayout.NORTH, displayPanel, 10, SpringLayout.SOUTH, loadPanel);
        baseLayout.putConstraint(SpringLayout.WEST, displayPanel, 20, SpringLayout.EAST, savePanel );
        //searchPanel
        baseLayout.putConstraint(SpringLayout.NORTH, searchPanel, 20, SpringLayout.SOUTH, displayPanel);
        baseLayout.putConstraint(SpringLayout.WEST, searchPanel, 20, SpringLayout.EAST, listPanel);
        //statisticPanel
        baseLayout.putConstraint(SpringLayout.NORTH, statisticPanel, 15, SpringLayout.SOUTH, searchPanel);
        baseLayout.putConstraint(SpringLayout.WEST, statisticPanel, 20, SpringLayout.EAST, listPanel);
    }

    private void setupPanel(){
        this.setSize(1280, 720); // same size as frame window
        this.setLayout(baseLayout);
        /* add all the component */
        this.add(loadPanel);
        this.add(savePanel);
        this.add(listPanel);
        this.add(displayPanel);
        this.add(searchPanel);
        this.add(statisticPanel);
    }

    /**
     * create the listener action function for buttons
     */
    private void setupListeners(){
        // add button listeners
        loadPanel.loadFileButton.addActionListener((ActionEvent e) -> l.loadFile());
        loadPanel.confirmButton.addActionListener((ActionEvent e) -> l.confirm());
        savePanel.convertButton.addActionListener((ActionEvent e) -> l.convert());
        savePanel.saveButton.addActionListener((ActionEvent e) -> l.save());
        listPanel.makeListButton.addActionListener((ActionEvent e) -> l.makeList());
        searchPanel.searchButton.addActionListener((ActionEvent e) -> l.search());
        statisticPanel.caculateButton.addActionListener((ActionEvent e) -> l.calculate());
        // add list selection listener
        listPanel.patientList.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> l.selectAll());
        listPanel.resultList.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> l.selectSearch());
    }


    /* getter */
    public LoadPanel getLoadPanel() {
        return loadPanel;
    }

    public SavePanel getSavePanel() {
        return savePanel;
    }

    public ListPanel getListPanel(){
        return listPanel;
    }

    public DisplayPanel getDisplayPanel(){
        return displayPanel;
    }

    public SearchPanel getSearchPanel(){
        return searchPanel;
    }

    public StatisticPanel getStatisticPanel(){
        return statisticPanel;
    }



}
