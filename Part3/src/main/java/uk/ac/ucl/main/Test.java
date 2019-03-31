package uk.ac.ucl.main;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Model model = ModelFactory.getModel();
        String id = "3d287899-4841-4637-b80d-44bb492ea2ce";
        Patient patient = model.getPatientDetail(id);
        System.out.println(patient.getId());
    }
}
