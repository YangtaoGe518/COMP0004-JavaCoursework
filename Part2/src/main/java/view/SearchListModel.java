package view;

import model.Patient;

import javax.swing.*;
import java.util.ArrayList;

public class SearchListModel {
    ArrayList<Patient> patients;
    String searchText;

    public SearchListModel(ArrayList<Patient> patients, String searchText){
        this.patients = patients;
        this.searchText = searchText;
    }
    /*
        id, birthdate, deathdate, ssn, drivers, passport,
        prefix, first, last, suffix, maiden,
        marital, race, ethnicity, gender,
        birthplace, address, city, state, zip */

    public DefaultListModel idModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getId().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel birthdateModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getBirthdate().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel deathdateModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getDeathdate().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel ssnModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getSsn().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel driversModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getDrivers().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel passportModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getPassport().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel prefixModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getPrefix().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel firstModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getFirst().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel lastModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getLast().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel suffixModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getSuffix().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel maidenModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getMaiden().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel maritalModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getMarital().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel raceModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getRace().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel ethnicityModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getEthnicity().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel genderModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getGender().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel birthplaceModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getBirthplace().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel addressModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getAddress().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel cityModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getCity().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel stateModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getState().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    public DefaultListModel zipModel(){
        DefaultListModel<Patient> listModel = new DefaultListModel<>();
        for (Patient p : patients) {
            if (p.getZip().contains(searchText)) {
                listModel.addElement(p);
            }
        }
        return listModel;
    }

    /* help functions */
    private String toUpper(String input){
        String sub = input.substring(0,1).toUpperCase();
        String out = sub + input.substring(1);
        return out;
    }


}
