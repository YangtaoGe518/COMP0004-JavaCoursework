package view.panels;

import javax.swing.*;

public class SearchPanel extends JPanel {
    public JTextField searchKeyword;
    public JButton searchButton;
    public JComboBox cmbSearchList;

    public SearchPanel(){
        init();

        setupPanel();
        setupLayout();
    }

    private void init(){
        searchButton = new JButton("Search");
        searchKeyword = new JTextField();

        String[] searchStrings = {"id", "birthdate", "deathdate", "ssn", "drivers", "passport",
                                    "prefix", "first", "last", "suffix", "maiden",
                                    "marital", "race", "ethnicity", "gender",
                                    "birthplace" , "address", "city", "state", "zip"};
        cmbSearchList = new JComboBox(searchStrings);
    }

    private void setupPanel(){
        this.setSize(1280,720);
        searchKeyword.setColumns(20);
        this.add(searchButton);
        cmbSearchList.setSelectedItem(null);
        this.add(cmbSearchList);
        this.add(searchKeyword);
    }

    private void setupLayout(){

    }

}
