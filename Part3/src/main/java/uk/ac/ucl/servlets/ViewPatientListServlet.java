package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// The servlet invoked to display a list of patients.
// The url http://localhost:8080/patientList.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/patientList.html")
public class ViewPatientListServlet extends HttpServlet
{
    private int profilePerPage = 25;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    int currentPage = Integer.valueOf(request.getParameter("currentPage"));
    //System.out.println(currentPage);

    // handle the list on one page
    List<Patient> patients = getCurrentPatients(currentPage);
    request.setAttribute("patients", patients);

    // handle the rows
    int rows = getNumberOfRows();
    //System.out.println(rows);
    int numOfPages = rows / profilePerPage;

    if(numOfPages % profilePerPage > 0){
        numOfPages++;
    }

    request.setAttribute("numOfPages", numOfPages);
    request.setAttribute("currentPage", currentPage);

    //invoke the jsp, and forward control to profile jsp
      RequestDispatcher dispatcher = request.getRequestDispatcher("patientList.jsp");
      dispatcher.forward(request, response);
  }

  /* help functions of the servlet */
    /**
     * getCurrentPatients method takes the the currentPage number and
     * gets the current list of display on the current page
     * @param currentPage
     * @return a list of patients on current page
     * @throws IOException
     */
  private List<Patient> getCurrentPatients(int currentPage) throws IOException{
      List<Patient> currentPatients = new ArrayList<>();
      int start = currentPage * profilePerPage - profilePerPage;

      Model model = ModelFactory.getModel();
      List<Patient> patients = model.getPatients();

      // check the last page is out of index or not
      int end = 0;
      if(start + 25 < patients.size()){
          end = start + 25;
      }
      else{
          end = patients.size();
      }

      // bulid the list for the current page
      for (int i = start; i < end; i++){
          Patient p = patients.get(i);
          currentPatients.add(p);
      }


      return currentPatients;
  }

    /**
     * getNumberOfRows gets the total number of patient profiles
     * @return the total number of profiles
     * @throws IOException
     */
  private int getNumberOfRows()throws IOException{
      int numOfRow = 0;

      Model model = ModelFactory.getModel();
      List<Patient> patients = model.getPatients();

      numOfRow = patients.size();

      return numOfRow;
  }
}
