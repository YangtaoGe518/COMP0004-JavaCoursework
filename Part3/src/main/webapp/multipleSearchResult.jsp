<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Yangtao Ge
  Date: 31/03/2019
  Time: 10:05
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
    <h1>Multiple Search</h1>
    <%
        String field1 = (String)request.getAttribute("field1");
        String keywords1 = (String)request.getAttribute("keywords1");
        String field2 = (String)request.getAttribute("field2");
        String keywords2 = (String)request.getAttribute("keywords2");
    %>
    <p> You search by &lt; <%=field1%> & <%=field2%> &gt;.</p>
    <p>Your search keywords are &lt; <%=keywords1%> & <%=keywords2%> &gt; </p>

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
