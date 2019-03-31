package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Model {
    private ReadCSV readCSV;
    private Factory factory;

    public Model() {
        readCSV = new ReadCSV();
        factory = new Factory();
    }

    public void readFile(File file) {
        String filePath = file.getAbsolutePath();
        ArrayList<Patient> patients = readCSV.makePatientList(filePath);
        patients.remove(0);
        factory.setPatientList(patients);
    }

    public List<Patient> getPatients() {
        List<Patient> patients = factory.getPatientList();
        return patients;
    }

    public Patient getPatientDetail(String id) {
        Patient patient = findById(id);
        return patient;
    }

    private Patient findById(String searchText) {
        List<Patient> patients = getPatients();
        Patient result = patients.stream()
                .filter(patient -> searchText.equals(patient.getId()))
                .findAny()
                .orElse(null);

        return result;
    }


    // This also returns dummy data. The real version should use the keyword parameter to search
    // the patient data and return a list of matching items. It might return a List<Patient>
    // instead of a List<String>.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }

    /* statistic functions */
    private int getAge(Patient patient) {
        int age;
        String birthdate = patient.getBirthdate();
        String deathdate = patient.getDeathdate();

        String birthyear = birthdate.substring(0, 4);
        Integer intBirthYear = Integer.valueOf(birthyear);

        if (!deathdate.equals("")) {  // if the person dead
            String deathyear = deathdate.substring(0, 4);
            Integer intDeathYear = Integer.valueOf(deathyear);

            age = intDeathYear - intBirthYear;
        } else { // the person is alive
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            age = currentYear - intBirthYear;
        }
        return age;
    }

    private List<Integer> getAgeList(List<Patient> patients) {
        // remember to remove the title
        List<Integer> ageList = new ArrayList<>();

        for (Patient p : patients) {
            ageList.add(getAge(p));
        }

        return ageList;
    }

    public int getAgeDistribution(List<Patient> patients, int min, int max){
        List<Integer> ageList = getAgeList(patients);
        int numOfPatients = 0;

        for(int age: ageList){
            if (min<= age && max > age){
                numOfPatients++;
            }
        }

        return numOfPatients;
    }

    public Patient getYoungest(List<Patient> patients){
        Patient patient = null;
        List<Integer> ageList = getAgeList(patients);
        int minAge = 10000;
        int index = 0;

        for (int i = 0; i < ageList.size(); i++){
            if(ageList.get(i) < minAge){
                minAge = ageList.get(i);
                index = i;
            }
        }
        patient = patients.get(index);

        return patient;
    }

    public Patient getOldest(List<Patient> patients){
        Patient patient = null;
        List<Integer> ageList = getAgeList(patients);
        int maxAge = 0;
        int index = 0;

        for (int i = 0; i < ageList.size(); i++){
            if(ageList.get(i) > maxAge){
                maxAge = ageList.get(i);
                index = i;
            }
        }
        patient = patients.get(index);

        return patient;
    }

    public double averageAge(List<Patient> patients){
        List<Integer> ageList = getAgeList(patients);
        int sum = 0;

        for(int age: ageList){
            sum = sum + age;
        }
        double averageAge = sum / ageList.size();

        return averageAge;
    }


    private HashMap<String, Integer> getBirthyearMap(List<Patient> patients) {
        HashMap<String, Integer> birthyearMap = new HashMap<>();

        for (Patient p : patients) {
            String birthYear = p.getBirthdate().substring(0, 4);
            /* make map */
            if (birthyearMap.containsKey(birthYear)) {  // if the key doest not exist
                birthyearMap.put(birthYear, birthyearMap.get(birthYear) + 1);
            } else {
                birthyearMap.put(birthYear, 1);
            }
        }
        return birthyearMap;
    }

    public HashMap.Entry<String, Integer> getCommonYear(List<Patient> patients) {
        HashMap<String, Integer> birthYearMap = getBirthyearMap(patients);
        HashMap.Entry<String, Integer> maxEntry = null;

        /* get the max entry */
        for (HashMap.Entry<String, Integer> entry : birthYearMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }


    /* search Methods*/
    public List<Patient> singleSearch(List<Patient> patients, String field, String keyword){
        List<Patient> resultList = new ArrayList<>();
        SearchList searchList = new SearchList(patients, keyword);

        resultList = searchList.selectField(field);

        return resultList;
    }

    public List<Patient> ageSearch(List<Patient> patients, int min, int max){
        List<Patient> resultList = new ArrayList<>();
        List<Integer> ageList = getAgeList(patients);

        for(int i = 0; i < ageList.size(); i++){
            int age = ageList.get(i);
            if(min <= age && max > age){
                Patient p = patients.get(i);
                resultList.add(p);
            }
        }
        return resultList;
    }
}
