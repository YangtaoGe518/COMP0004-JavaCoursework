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

@WebServlet("/runMultipleSearch.html")
public class multipleSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // call model-factory
        Model model = ModelFactory.getModel();
        List<Patient> patients = model.getPatients();

        // get field 1 & search string 1
        String field1 = request.getParameter("field1");
        String searchStr1 = request.getParameter("searchStr1");

        String field2 = request.getParameter("field2");
        String searchStr2 = request.getParameter("searchStr2");

        // do search
        List<Patient> list1 = model.singleSearch(patients, field1, searchStr1);
        List<Patient> list2 = model.singleSearch(list1, field2, searchStr2);
        List<Patient> result = list2;

        //store all info in request object
        request.setAttribute("field1", field1);
        request.setAttribute("keywords1", searchStr1);
        request.setAttribute("field2", field2);
        request.setAttribute("keywords2", searchStr2);
        request.setAttribute("resultList", result);

        // Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/multipleSearchResult.jsp");
        dispatcher.forward(request, response);
    }
}
