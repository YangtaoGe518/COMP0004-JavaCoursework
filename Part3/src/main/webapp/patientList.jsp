<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <p id="top"> <a href="#bottom" title = "nav to bottom"> go to bottom</a> </p>
  <ul>
    <%
      List<Patient> patients = (List<Patient>) request.getAttribute("patients");
      for (Patient patient : patients)
      {
        String href = "profile.html?id=" + patient.getId() ;
    %>
    <li><a href="<%=href%>" title = "<%=patient.getId()%>"> <%=patient.getFirst() + " " + patient.getLast()%> </a>
    </li>
    <% } %>
  </ul>
  <p id = "bottom">  <a href="#top" title="nav to top"> got to top </a> </p>
</div>

<nav aria-label="Navigation for patient List">
  <ul class="pagination">
    <c:if test="${currentPage != 1}">
      <li class="page-item"><a class="page-link"
                               href="/patientList.html?currentPage=${currentPage-1}">Previous</a>
      </li>
    </c:if>

    <c:forEach begin="1" end="${numOfPages}" var="i">
      <c:choose>
        <c:when test="${currentPage eq i}">
          <li class="page-item active"><a class="page-link">
              ${i} <span class="sr-only">(current)</span></a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item"><a class="page-link"
                                   href="/patientList.html?currentPage=${i}">${i}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>


    <c:if test="${currentPage lt numOfPages}">
      <li class="page-item"><a class="page-link"
                               href="/patientList.html?currentPage=${currentPage+1}">Next</a>
      </li>
    </c:if>
  </ul>
</nav>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

<jsp:include page="/footer.jsp"/>
</body>
</html>
