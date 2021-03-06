<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Yangtao Ge
  Date: 30/03/2019
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Management System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h1>Single Search</h1>
    <%
        String field = (String)request.getAttribute("field");
        String keywords = (String)request.getAttribute("keywords");
    %>
    <p> You search by &lt; <%=field%> &gt;, Your search keywords are &lt; <%=keywords%> &gt; </p>
    <h2> Search result: </h2>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("resultList");
        if (patients.size() !=0)
        {
    %>
    <ul>
        <%
            for (Patient patient : patients)
            {
                String href = "profile.html?id=" + patient.getId() ;
        %>
        <li><a href="<%=href%>" title = "<%=patient.getId()%>"> <%=patient.getFirst() + " " +patient.getLast()%> </a> </li>
        <% }
        } else
        {%>
        <p>Nothing found</p>
        <%}%>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" ></script>

</html>
