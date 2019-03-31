<%@ page import="uk.ac.ucl.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: Yangtao Ge
  Date: 30/03/2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Statistics of Patients</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
        <jsp:include page="/header.jsp"/>
        <h1>Statistics: </h1>
        <div class="main">
            <h2>Birth Year:</h2>
            <ul>
                <%
                    String commonYear = (String)request.getAttribute("commonYear");
                    int frequency = (Integer)request.getAttribute("frequency");
                %>
                <li>
                    <p>The most common birth year is: <%=commonYear%></p>
                </li>
                <li>
                    <p>The frequency of the most common birth year is: <%=frequency%> times</p>
                </li>
            </ul>

            <h2>Age Distribution:</h2>
            <ul>
                <%
                    int aless20 = (Integer)request.getAttribute("aless20");
                    int a20to30 = (Integer)request.getAttribute("a20to30");
                    int a30to40 = (Integer)request.getAttribute("a30to40");
                    int a40to50 = (Integer)request.getAttribute("a40to50");
                    int a50to60 = (Integer)request.getAttribute("a50to60");
                    int amore60 = (Integer)request.getAttribute("amore60");
                %>
                <li>
                    <p>Less than 20 years old: <%=aless20%></p>
                </li>
                <li>
                    <p>From 20 to 30 years old: <%=a20to30%></p>
                </li>
                <li>
                    <p>From 30 to 40 years old: <%=a30to40%></p>
                </li>
                <li>
                    <p>From 40 to 50 years old: <%=a30to40%></p>
                </li>
                <li>
                    <p>From 50 to 60 years old: <%=a40to50%></p>
                </li>
                <li>
                    <p>From 20 to 30 years old: <%=a50to60%></p>
                </li>
                <li>
                    <p>more than 60 years old: <%=amore60%></p>
                </li>
            </ul>
        </div>

        <div>
            <h2>Oldest & Youngest Patient:</h2>
            <ul>
                <%
                    Patient oldestPatient = (Patient)request.getAttribute("oldestPatient");
                    Patient youngestPatient = (Patient)request.getAttribute("youngestPatient");
                %>
                <li>
                    <p>The oldest Patient is:
                        <a href="profile.html?id=<%=oldestPatient.getId()%>" title = "<%=oldestPatient.getId()%>"><%=oldestPatient.getFirst() + " " + oldestPatient.getLast()%></a></p>
                </li>
                <li>
                    <p>The youngest Patient is:
                        <a href="profile.html?id=<%=youngestPatient.getId()%>" title = "<%=youngestPatient.getId()%>"> <%=youngestPatient.getFirst() + " " + youngestPatient.getLast()%></a></p>
                </li>
            </ul>
        </div>

        <div>
            <h2>Average age:</h2>
            <%
                double averageAge = (double)request.getAttribute("averageAge");
            %>
            <p>The average age is: <%=averageAge%></p>
        </div>
        <jsp:include page="/footer.jsp"/>
</body>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

</html>
