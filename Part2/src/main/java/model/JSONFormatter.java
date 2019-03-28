package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONFormatter {

    private String singleObject(String str, String val) {
        /* Object is an unordered ste of name/value pairs: {"String" : "val"} */
        StringBuilder output = new StringBuilder();
        output.append("\"");
        output.append(str);
        output.append("\"");
        output.append(":");
        output.append("\"");
        output.append(val);
        output.append("\"");

        return output.toString();
    }

    public String singlePatient(Patient patient) {
        /* append all objects from a patient */
        /* id, birthdate, deathdate, ssn, drivers, passport,
           prefix, first, last, suffix, maiden,
           marital, race, ethicity, gender,
           birthplace, address, city, state, zip */
        Map<String, String> m = new LinkedHashMap<>();
        m.put("id", patient.getId());
        m.put("birthdate", patient.getBirthdate());
        m.put("deathdate", patient.getDeathdate());
        m.put("ssn", patient.getSsn());
        m.put("drivers", patient.getDrivers());
        m.put("passport", patient.getPassport());
        m.put("prefix", patient.getPrefix());
        m.put("first", patient.getFirst());
        m.put("last", patient.getLast());
        m.put("suffix", patient.getSuffix());
        m.put("maiden", patient.getMaiden());
        m.put("marital", patient.getMarital());
        m.put("race", patient.getRace());
        m.put("ethicity", patient.getEthnicity());
        m.put("gender", patient.getGender());
        m.put("birthplace", patient.getBirthplace());
        m.put("address", patient.getAddress());
        m.put("city", patient.getCity());
        m.put("state", patient.getState());
        m.put("zip", patient.getZip());

        StringBuilder output = new StringBuilder();
        output.append("{"); // begin
        output.append("\n"); // new line
        for (Map.Entry<String, String> entry : m.entrySet()) {
            output.append(singleObject(entry.getKey(), entry.getValue()));
            if (entry.getKey() != "zip") { // last item does not have a comma at the end
                output.append(",");
            }
            output.append("\n");
        }
        output.append("}"); // end

        return output.toString();
    }

    public String multiplePatients(List<Patient> patientsList) {
        StringBuilder output = new StringBuilder();
        int count = 0;

        output.append("{");
        output.append("\n");  // new line
        output.append("\"");
        output.append("patients");
        output.append("\"");
        output.append(":");
        output.append("[");
        output.append("\n");  // new line

        /* inner loop for produce patients list */
        for (Patient p : patientsList) {
            output.append(singlePatient(p));
            count++;
            if (count < patientsList.size()) { // last object does not have comma at the end.
                output.append(",");
            }
            output.append("\n"); // new line
        }

        output.append("]");
        output.append("\n"); // new line
        output.append("}");

        return output.toString();
    }
}
