package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    private Patient createPatient(String[] data) {
        // the method if for making a new Patient Object

        String id = data[0];
        String birthdate = data[1];
        String deathdate = data[2];
        String ssn = data[3];
        String drivers = data[4];
        String passport = data[5];
        String prefix = data[6];
        String first = data[7];
        String last = data[8];
        String suffix = data[9];
        String maiden = data[10];
        String marital = data[11];
        String race = data[12];
        String ethnicity = data[13];
        String gender = data[14];
        String birthplace = data[15];
        String address = data[16];
        String city = data[17];
        String state = data[18];
        String zip = data[19];

        return new Patient(id, birthdate, deathdate, ssn, drivers, passport,
                prefix, first, last, suffix, maiden,
                marital, race, ethnicity, gender,
                birthplace, address, city, state, zip);
    }

    public ArrayList<Patient> makePatientList(String filePath) {
        /* this method make a list of patients into A List */
        ArrayList<Patient> patients = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] contents = line.split(",", Integer.MAX_VALUE); // avoid emety string at the end

                Patient patient = createPatient(contents);
                patients.add(patient);

                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patients;
    }
}
