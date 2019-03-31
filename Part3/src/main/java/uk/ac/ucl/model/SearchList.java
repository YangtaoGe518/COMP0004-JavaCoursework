package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class SearchList {
    List<Patient> patients;
    String searchText;

    public SearchList(List<Patient> patients, String searchText){
        this.patients = patients;
        this.searchText = searchText;
    }
    /*
        id, birthdate, deathdate, ssn, drivers, passport,
        prefix, first, last, suffix, maiden,
        marital, race, ethnicity, gender,
        birthplace, address, city, state, zip */

    public List<Patient> selectField(String field){
        List<Patient> list = new ArrayList<>();

        switch (field){
            case "id": list = idList();
                break;
            case "birthdate": list = birthdateList();
                break;
            case "deathdate": list = deathdateList();
                break;
            case "ssn": list = ssnList();
                break;
            case "driver": list = driverList();
                break;
            case "passport": list = passportList();
                break;
            case "first": list = firstList();
                break;
            case "last": list = lastList();
                break;
            case "marital": list = maritalList();
                break;
            case "race": list = raceList();
                break;
            case "ethnicity": list = ethnicityList();
                break;
            case "gender": list = genderList();
                break;
            case "birthplace": list = birthplaceList();
                break;
            case "address": list = addressList();
                break;
            case "city": list = cityList();
                break;
            case "state": list = stateList();
                break;
            case "zip": list = zipList();
                break;

            default: System.out.println("choose a field");
        }

        return list;
    }

    private List<Patient> idList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getId().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> birthdateList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getBirthdate().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> deathdateList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getDeathdate().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> ssnList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getSsn().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> driverList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getDrivers().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> passportList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getPassport().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> firstList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getFirst().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> lastList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getLast().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> maritalList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getMarital().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> raceList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getRace().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> ethnicityList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getEthnicity().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> genderList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getGender().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> birthplaceList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getBirthplace().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> addressList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getAddress().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> cityList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getCity().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> stateList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getState().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<Patient> zipList(){
        List<Patient> list = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getZip().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

}
