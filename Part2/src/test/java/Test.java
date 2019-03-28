import controller.MainController;
import model.Model;
import model.Patient;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args){
        MainController mainController = new MainController();

        mainController.getAppModel().readFile("C:\\Users\\Yangtao Ge\\Desktop\\Computer Science\\COMP 0004\\Coursework\\COMP0004Data\\patients100.csv");
        ArrayList<Patient> patients = mainController.getAppModel().factoryGetPatientList();
        patients.remove(0);

        HashMap.Entry<String,Integer> maxYearEntry = mainController.getAppModel().getCommonYear(patients);
        System.out.println("Most common Year is: " + maxYearEntry.getKey() + " Appearance is:  " + maxYearEntry.getValue() );
    }
}