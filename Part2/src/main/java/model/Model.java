package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Model {
    private ReadCSV readCSV;
    private Factory factory;
    private JSONFormatter jsonFormatter;
    private String filePath;

    /**
     * MainModel for Access all related Patient info
     */

    public Model(){
        readCSV = new ReadCSV();
        factory = new Factory();
        jsonFormatter = new JSONFormatter();
        filePath = "";
    }

    public void readFile(String filePath){
        ArrayList<Patient> patients = readCSV.makePatientList(filePath);
        factory.setPatientList(patients);
    }

    public ArrayList<Patient> factoryGetPatientList(){
        return factory.getPatientList();
    }

    public String makeSingleJSON(Patient patient){
        return jsonFormatter.singlePatient(patient);
    }

    public String makeMultiJSON(ArrayList<Patient> patients){
        return jsonFormatter.multiplePatients(patients);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private int getAge(Patient patient){
        int age;
        String birthdate = patient.getBirthdate();
        String deathdate = patient.getDeathdate();

        String birthyear = birthdate.substring(0,4);
        Integer intBirthYear = Integer.valueOf(birthyear);

        if (!deathdate.equals("")){  // if the person dead
            String deathyear = deathdate.substring(0,4);
            Integer intDeathYear = Integer.valueOf(deathyear);

            age = intDeathYear - intBirthYear;
        }else{ // the person is alive
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            age = currentYear - intBirthYear;
        }
        return age;
    }

    public ArrayList<Integer> getAgeList(ArrayList<Patient> patients){
        // remember to remove the title
        ArrayList<Integer> ageList = new ArrayList<>();

        for(Patient p :  patients){
            ageList.add(getAge(p));
        }

        return ageList;
    }


    private HashMap<String, Integer> getBirthyearMap(ArrayList<Patient> patients){
        HashMap<String, Integer> birthyearMap = new HashMap<>();

        for(Patient p: patients){
            String birthYear = p.getBirthdate().substring(0,4);
            /* make map */
            if(birthyearMap.containsKey(birthYear)){  // if the key doest not exist
                birthyearMap.put(birthYear, birthyearMap.get(birthYear) + 1);
            }else{
                birthyearMap.put(birthYear, 1);
            }
        }
        return birthyearMap;
    }

    public HashMap.Entry<String, Integer> getCommonYear(ArrayList<Patient> patients){
        HashMap<String, Integer> birthYearMap = getBirthyearMap(patients);
        HashMap.Entry<String, Integer> maxEntry = null;

        /* get the max entry */
        for (HashMap.Entry<String,Integer> entry : birthYearMap.entrySet()){
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }

        return maxEntry;
    }



}
