package controller;

import model.Patient;
import view.SearchListModel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Listeners {

    private MainController controller;

    public Listeners(MainController controller) {
        this.controller = controller;
    }

    public void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        /* file path for current dir should be change -- for easy access*/
        File currentDir = new File("C:\\Users\\Yangtao Ge\\Desktop\\Computer Science\\COMP 0004\\Coursework\\COMP0004Data");
        // make a filter to access csv file only
        FileFilter filter = new FileNameExtensionFilter("Comma-Separated Values", "csv");
        fileChooser.setFileFilter(filter);

        //some setups
        fileChooser.setDialogTitle("Load Patients File");
        //fileChooser.setCurrentDirectory(currentDir);   // locate the dir when open the dialogue

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fileChooser.getSelectedFile();
            String path = selectFile.getAbsolutePath();

            if (checkLoadFile(path)) {  // avoid invalid input
                controller.getAppModel().readFile(path);
                controller.getAppModel().setFilePath(path);
                JOptionPane.showMessageDialog(controller.getAppFrame(), "you load: " + path);
            }
        }
        else {
            System.out.println("You cancelled the open operation !");
            JOptionPane.showMessageDialog(controller.getAppFrame(), "You cancelled the open operation !");
        }
    }
    /* help function for load file method */
    private boolean checkLoadFile(String path){
        boolean isValid = false;

        try{
            controller.getAppModel().readFile(path);  //-- if the Patient is successfully created then pass
            isValid = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "Invalid file");
        }

        return isValid;
    }

    public void confirm() {
        String filePath = controller.getAppModel().getFilePath();
        if (filePath == ""){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "You need to choose a file!(From ConfirmButton)");
        }else {
            //System.out.println(filePath);
            controller.getAppFrame().getBasePanel().getLoadPanel().filePath.setText(filePath);
        }
    }

    public void convert(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();

        try{
            patients.get(0);
            String json = controller.getAppModel().makeMultiJSON(patients);
            controller.getAppFrame().getBasePanel().getSavePanel().JSONFile.append(json);
        }catch (Exception e){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "Please Choose a File!(from ConvertButton)");
        }
    }

    public void save(){
        JFileChooser fileChooser = new JFileChooser();
        File currentDir = new File("C:\\Users\\Yangtao Ge\\Desktop\\Computer Science\\COMP 0004\\Coursework\\COMP0004Data");  // for easy access
        // make a filter to access csv file only
        FileFilter filter = new FileNameExtensionFilter("JavaScript Object Notation", "json");
        fileChooser.setFileFilter(filter);
        //some setups
        fileChooser.setDialogTitle("Save Patients in json Format");
        //fileChooser.setCurrentDirectory(currentDir);  //locate the dir when open the dialogue

        int result = fileChooser.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            File jsonfile = fileChooser.getSelectedFile();
            try{
                controller.getAppFrame().getBasePanel().getSavePanel().JSONFile.write(new FileWriter(jsonfile));
                JOptionPane.showMessageDialog(controller.getAppFrame(), "Successfully Saved");
            }catch (IOException ioe){
                JOptionPane.showMessageDialog(controller.getAppFrame(), "Save File Error");
            }

        }else{
            JOptionPane.showMessageDialog(controller.getAppFrame(), "You cancelled save operation");
        }
    }

    public void makeList(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();

        try{
            patients.get(0);
            DefaultListModel<Patient> listModel = new DefaultListModel<>();
            /* build Default list model */
            for(Patient p : patients){
                listModel.addElement(p);
            }
            listModel.remove(0);  // remove title

            controller.getAppFrame().getBasePanel().getListPanel().patientList.setModel(listModel);
        }catch (Exception e){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "Please Choose a File!(from makeFileButton)");
        }

    }

    public void selectAll(){
        /* this is a list selection listener*/
        Patient p  = (Patient) controller.getAppFrame().getBasePanel().getListPanel().patientList.getSelectedValue();
        /*
        id, birthdate, deathdate, ssn, drivers, passport,
        prefix, first, last, suffix, maiden,
        marital, race, ethnicity, gender,
        birthplace, address, city, state, zip */

        controller.getAppFrame().getBasePanel().getDisplayPanel().id.setText("id: " + p.getId());
        controller.getAppFrame().getBasePanel().getDisplayPanel().birthdate.setText("birthdate: " + p.getBirthdate());
        controller.getAppFrame().getBasePanel().getDisplayPanel().deathdate.setText("deathdate: " + p.getDeathdate());
        controller.getAppFrame().getBasePanel().getDisplayPanel().ssn.setText("ssn: " + p.getSsn());
        controller.getAppFrame().getBasePanel().getDisplayPanel().drivers.setText("driver: " + p.getDrivers());
        controller.getAppFrame().getBasePanel().getDisplayPanel().passport.setText("passport: " + p.getPassport());
        controller.getAppFrame().getBasePanel().getDisplayPanel().prefix.setText("prefix: " + p.getPrefix());
        controller.getAppFrame().getBasePanel().getDisplayPanel().first.setText("first: " + p.getFirst());
        controller.getAppFrame().getBasePanel().getDisplayPanel().last.setText("last: " + p.getLast());
        controller.getAppFrame().getBasePanel().getDisplayPanel().suffix.setText("suffix: " + p.getSuffix());
        controller.getAppFrame().getBasePanel().getDisplayPanel().maiden.setText("maiden: " + p.getMaiden());
        controller.getAppFrame().getBasePanel().getDisplayPanel().marital.setText("marital: " + p.getMarital());
        controller.getAppFrame().getBasePanel().getDisplayPanel().race.setText("race: " + p.getRace());
        controller.getAppFrame().getBasePanel().getDisplayPanel().ethnicity.setText("ethnicity: " + p.getEthnicity());
        controller.getAppFrame().getBasePanel().getDisplayPanel().gender.setText("gender: " + p.getGender());
        controller.getAppFrame().getBasePanel().getDisplayPanel().birthplace.setText("birthplace: " + p.getBirthplace());
        controller.getAppFrame().getBasePanel().getDisplayPanel().address.setText("address: " + p.getAddress());
        controller.getAppFrame().getBasePanel().getDisplayPanel().city.setText("city: " + p.getCity());
        controller.getAppFrame().getBasePanel().getDisplayPanel().state.setText("state: " + p.getState());
        controller.getAppFrame().getBasePanel().getDisplayPanel().zip.setText("zip: " + p.getZip());
    }

    public void search(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();
        String searchText = controller.getAppFrame().getBasePanel().getSearchPanel().searchKeyword.getText();
        String choice = (String) controller.getAppFrame().getBasePanel().getSearchPanel().cmbSearchList.getSelectedItem();
        try{
            patients.get(0);

            // get all correct input
            if (!searchText.isEmpty() && choice != null) {
                DefaultListModel<Patient> listModel = getSelectedMode();

                // check the result is empty or not
                if(!listModel.isEmpty()){
                    controller.getAppFrame().getBasePanel().getListPanel().resultList.setModel(listModel);
                }
                else{
                    JOptionPane.showMessageDialog(controller.getAppFrame(), "Nothing Found");
                }

            }
            else if(searchText.isEmpty()){
                JOptionPane.showMessageDialog(controller.getAppFrame(), "Type a keyword! (from SearchButton");
            }
            else if(choice == null){
                JOptionPane.showMessageDialog(controller.getAppFrame(), "Choose a mode! (from SearchButton");
            }
            else{
                JOptionPane.showMessageDialog(controller.getAppFrame(), "ERROR (from SearchButton");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "Please Choose a File!(from SearchButton)");
        }
    }

    /* help function for method search */
    private DefaultListModel getSelectedMode(){
        String choice = (String)controller.getAppFrame().getBasePanel().getSearchPanel().cmbSearchList.getSelectedItem();

        String searchText = controller.getAppFrame().getBasePanel().getSearchPanel().searchKeyword.getText();
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();
        SearchListModel searchListModel = new SearchListModel(patients, searchText);

        DefaultListModel<Patient> mode = new DefaultListModel<>();

        switch (choice){
            case "id": mode = searchListModel.idModel();
                break;
            case "birthdate": mode = searchListModel.birthdateModel();
                break;
            case "deathdate": mode = searchListModel.deathdateModel();
                break;
            case "ssn": mode = searchListModel.ssnModel();
                break;
            case "drivers": mode = searchListModel.driversModel();
                break;
            case "passport": mode = searchListModel.passportModel();
                break;
            case "prefix": mode = searchListModel.prefixModel();
                break;
            case "first": mode = searchListModel.firstModel();
                break;
            case "last": mode = searchListModel.lastModel();
                break;
            case "suffix": mode = searchListModel.suffixModel();
                break;
            case "maiden" : mode = searchListModel.maidenModel();
                break;
            case "marital": mode = searchListModel.maritalModel();
                break;
            case "race": mode = searchListModel.raceModel();
                break;
            case "ethnicity": mode = searchListModel.ethnicityModel();
                break;
            case "gender": mode = searchListModel.genderModel();
                break;
            case "birthplace": mode = searchListModel.birthdateModel();
                break;
            case "address": mode = searchListModel.addressModel();
                break;
            case "city": mode = searchListModel.cityModel();
                break;
            case "state": mode = searchListModel.stateModel();
                break;
            case "zip": mode = searchListModel.zipModel();
                break;

            default: JOptionPane.showMessageDialog(controller.getAppFrame(), "You need to select a search Mod");
        }

        return mode;
    }


    public void selectSearch(){
        /* this is a list selection listener*/
        Patient p  = (Patient) controller.getAppFrame().getBasePanel().getListPanel().resultList.getSelectedValue();
        /*
        id, birthdate, deathdate, ssn, drivers, passport,
        prefix, first, last, suffix, maiden,
        marital, race, ethnicity, gender,
        birthplace, address, city, state, zip */

        controller.getAppFrame().getBasePanel().getDisplayPanel().id.setText("id: " + p.getId());
        controller.getAppFrame().getBasePanel().getDisplayPanel().birthdate.setText("birthdate: " + p.getBirthdate());
        controller.getAppFrame().getBasePanel().getDisplayPanel().deathdate.setText("deathdate: " + p.getDeathdate());
        controller.getAppFrame().getBasePanel().getDisplayPanel().ssn.setText("ssn: " + p.getSsn());
        controller.getAppFrame().getBasePanel().getDisplayPanel().drivers.setText("driver: " + p.getDrivers());
        controller.getAppFrame().getBasePanel().getDisplayPanel().passport.setText("passport: " + p.getPassport());
        controller.getAppFrame().getBasePanel().getDisplayPanel().prefix.setText("prefix: " + p.getPrefix());
        controller.getAppFrame().getBasePanel().getDisplayPanel().first.setText("first: " + p.getFirst());
        controller.getAppFrame().getBasePanel().getDisplayPanel().last.setText("last: " + p.getLast());
        controller.getAppFrame().getBasePanel().getDisplayPanel().suffix.setText("suffix: " + p.getSuffix());
        controller.getAppFrame().getBasePanel().getDisplayPanel().maiden.setText("maiden: " + p.getMaiden());
        controller.getAppFrame().getBasePanel().getDisplayPanel().marital.setText("marital: " + p.getMarital());
        controller.getAppFrame().getBasePanel().getDisplayPanel().race.setText("race: " + p.getRace());
        controller.getAppFrame().getBasePanel().getDisplayPanel().ethnicity.setText("ethnicity: " + p.getEthnicity());
        controller.getAppFrame().getBasePanel().getDisplayPanel().gender.setText("gender: " + p.getGender());
        controller.getAppFrame().getBasePanel().getDisplayPanel().birthplace.setText("birthplace: " + p.getBirthplace());
        controller.getAppFrame().getBasePanel().getDisplayPanel().address.setText("address: " + p.getAddress());
        controller.getAppFrame().getBasePanel().getDisplayPanel().city.setText("city: " + p.getCity());
        controller.getAppFrame().getBasePanel().getDisplayPanel().state.setText("state: " + p.getState());
        controller.getAppFrame().getBasePanel().getDisplayPanel().zip.setText("zip: " + p.getZip());
    }


    public void calculate(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();

        try{
            patients.get(0);
            if(controller.getAppFrame().getBasePanel().getStatisticPanel().average.isSelected()){
                String average = getAverage();
                controller.getAppFrame().getBasePanel().getStatisticPanel().reuslt.setText("Average: " + average);
            }
            else if(controller.getAppFrame().getBasePanel().getStatisticPanel().distribution.isSelected()){

            }
            else if(controller.getAppFrame().getBasePanel().getStatisticPanel().commonYear.isSelected()){
                HashMap.Entry<String,Integer> maxYearEntry = getMaxYearEntry();
                controller.getAppFrame().getBasePanel().getStatisticPanel().reuslt.setText("The most common year: " +maxYearEntry.getKey() + ", The appear times are: " + maxYearEntry.getValue());
            }
            else{
                JOptionPane.showMessageDialog(controller.getAppFrame(), "You need to choose a RadioButton(from caclButton)");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(controller.getAppFrame(), "Please Choose a File!(from caclButton)");
            //e.printStackTrace();
        }
    }

    /* help function for calculate */
    private String getAverage(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();
        patients.remove(0);


        ArrayList<Integer> agelist = controller.getAppModel().getAgeList(patients);
        int sum = 0;

        for (int age : agelist){
            sum = sum + age;
        }

        double average = sum / agelist.size();
        return Double.toString(average);
    }

    private HashMap.Entry<String, Integer> getMaxYearEntry(){
        ArrayList<Patient> patients = controller.getAppModel().factoryGetPatientList();

        HashMap.Entry<String, Integer> maxYearEntry = controller.getAppModel().getCommonYear(patients);

        return maxYearEntry;
    }
}
