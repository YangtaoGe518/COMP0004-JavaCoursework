<%--
  Created by IntelliJ IDEA.
  User: Yangtao Ge
  Date: 29/03/2019
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Profile:</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/header.jsp"/>

<jsp:useBean id="patient" scope="request" type="uk.ac.ucl.model.Patient"></jsp:useBean>
<section id="profile" class="section">
    <div class="container">
        <h2 class="headline">Patient Profile of &lt; <jsp:getProperty property="first" name="patient"/> <jsp:getProperty property="last" name="patient"/> &gt; </h2>
        <table id="profiletab">
            <tr>
                <td>id</td>
                <td><jsp:getProperty property="id" name="patient"/> </td>
            </tr>

            <tr>
                <td>birthdate</td>
                <td><jsp:getProperty property="birthdate" name="patient"/></td>
            </tr>

            <tr>
                <td>deathdate</td>
                <td><jsp:getProperty property="deathdate" name="patient"/> </td>
            </tr>

            <tr>
                <td>ssn</td>
                <td><jsp:getProperty property="ssn" name="patient"/></td>
            </tr>

            <tr>
                <td>drivers</td>
                <td><jsp:getProperty property="drivers" name="patient"/> </td>
            </tr>

            <tr>
                <td>passport</td>
                <td><jsp:getProperty property="passport" name="patient"/></td>
            </tr>

            <tr>
                <td>prefix</td>
                <td><jsp:getProperty property="prefix" name="patient"/> </td>
            </tr>

            <tr>
                <td>first</td>
                <td><jsp:getProperty property="first" name="patient"/></td>
            </tr>

            <tr>
                <td>last</td>
                <td><jsp:getProperty property="last" name="patient"/> </td>
            </tr>

            <tr>
                <td>suffix</td>
                <td><jsp:getProperty property="suffix" name="patient"/></td>
            </tr>

            <tr>
                <td>maiden</td>
                <td><jsp:getProperty property="maiden" name="patient"/> </td>
            </tr>

            <tr>
                <td>martial</td>
                <td><jsp:getProperty property="marital" name="patient"/></td>
            </tr>

            <tr>
                <td>race</td>
                <td><jsp:getProperty property="race" name="patient"/> </td>
            </tr>

            <tr>
                <td>ethnicity</td>
                <td><jsp:getProperty property="ethnicity" name="patient"/></td>
            </tr>

            <tr>
                <td>gender</td>
                <td><jsp:getProperty property="gender" name="patient"/> </td>
            </tr>

            <tr>
                <td>birthplace</td>
                <td><jsp:getProperty property="birthplace" name="patient"/></td>
            </tr>

            <tr>
                <td>address</td>
                <td><jsp:getProperty property="address" name="patient"/> </td>
            </tr>

            <tr>
                <td>city</td>
                <td><jsp:getProperty property="city" name="patient"/></td>
            </tr>

            <tr>
                <td>state</td>
                <td><jsp:getProperty property="state" name="patient"/> </td>
            </tr>

            <tr>
                <td>zip</td>
                <td><jsp:getProperty property="zip" name="patient"/></td>
            </tr>
        </table>
    </div>
</section>

<jsp:include page="/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

</body>
</html>
