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
import java.util.List;

@WebServlet("/runAgeRangeSearch.html")
public class searchAgeRangeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //call model-factory
        Model model = ModelFactory.getModel();
        List<Patient> patients = model.getPatients();

        //get maximum and minimum age boundaries
        String minAge = request.getParameter("searchMin");
        String maxAge = request.getParameter("searchMax");
        int min = Integer.valueOf(minAge);
        int max = Integer.valueOf(maxAge);

        // get the result list
        List<Patient> resultList = model.ageSearch(patients, min, max);

        //store all info in request object
        request.setAttribute("resultList", resultList);
        request.setAttribute("min", min);
        request.setAttribute("max", max);

        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/ageSearchResult.jsp");
        dispatcher.forward(request, response);
        
    }
}
