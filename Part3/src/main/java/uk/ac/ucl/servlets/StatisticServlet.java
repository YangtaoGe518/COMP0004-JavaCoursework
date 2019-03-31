package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/statistic.html")
public class StatisticServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        List<Patient> patients = model.getPatients();

        /* common year */
        HashMap.Entry<String, Integer> maxEntry = model.getCommonYear(patients);
        String commonYear = maxEntry.getKey();
        int frequency = maxEntry.getValue();

        request.setAttribute("commonYear", commonYear);
        request.setAttribute("frequency", frequency);

        /* Distribution */
        int aless20 = model.getAgeDistribution(patients,0,20);
        int a20to30 = model.getAgeDistribution(patients, 20,30);
        int a30to40 = model.getAgeDistribution(patients,30,40);
        int a40to50 = model.getAgeDistribution(patients,40,50);
        int a50to60 = model.getAgeDistribution(patients,50,60);
        int amore60 = model.getAgeDistribution(patients,50,10000);

        request.setAttribute("aless20", aless20);
        request.setAttribute("a20to30", a20to30);
        request.setAttribute("a30to40", a30to40);
        request.setAttribute("a40to50", a40to50);
        request.setAttribute("a50to60", a50to60);
        request.setAttribute("amore60", amore60);

        /* max & min age patient*/
        Patient oldestPatient = model.getOldest(patients);
        Patient youngestatient = model.getYoungest(patients);

        request.setAttribute("oldestPatient", oldestPatient);
        request.setAttribute("youngestPatient", youngestatient);

        /* average age */
        double averageAge = model.averageAge(patients);

        request.setAttribute("averageAge", averageAge);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/statistic.jsp");
        dispatcher.forward(request, response);
    }
}
