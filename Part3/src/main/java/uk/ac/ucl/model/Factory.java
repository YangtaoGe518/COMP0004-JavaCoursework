package uk.ac.ucl.model;

import java.util.ArrayList;

public class Factory {
    /**
     * Design an ArrayList data structure to store List of Patient Object
     */

    private ArrayList<Patient> patientList;

    public Factory() {
        patientList = new ArrayList<Patient>();
    }

    public void makePatient(Patient currentPatient) {

        patientList.add(currentPatient);
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }


}
