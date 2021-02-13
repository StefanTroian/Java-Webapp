<%@ page import="models.Administrator" %><%--
  Created by IntelliJ IDEA.
  User: troia
  Date: 05/06/2020
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href='https://fonts.googleapis.com/css?family=Great Vibes' rel='stylesheet'>
<head>
    <title>ProjectEAP</title>
    <style>
        body {
            background: url(background.jpg);
            background-size: 101.2%;
            margin: 0;
            color: white;
            font-family: Helvetica, sans-serif;
        }

        p {
            font-family: 'Great Vibes', serif;font-size: 30px;
            padding: 10px;
            margin-top: 0px;
            margin-bottom: -20px;
        }

        h3 {
            margin: 0;
            background: rgba(0,0,0, 0.15);
            color: white;
            font: 1px Helvetica, sans-serif;
            text-indent: 30px;
            border-bottom-right-radius: 5px;
            border-bottom-left-radius: 5px;
        }

        form {
            width: 185px;
            margin-left: 5px;
            margin-right: 0px;
            margin-top:	100px;
            margin-bottom: 0px;
            float: left;
        }

        button {
            background-color: #3d3d3d;
            color: white;
            padding: 10px 10px;
            margin: 5px 0;
            border: 1px solid white;
            cursor: pointer;
            width: 185px;
            border-radius: 5px;
        }

        .container {
            width: 185px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h3>
    <p>Aplicatie pentru gestionarea unui magazin
    <form action="/administrator" method="get" style="margin-top: -53px; margin-right: -10px; float: right;">
        <div class="container">
            <button type="submit" style="width: 150px;">Log out</button>
        </div>
    </form>
    </p>
</h3>


<form action="/administrator_f1" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Adaugare produs</button>
    </div>
</form>

<form action="/administrator_f2" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Setare stoc produs</button>
    </div>
</form>

<form action="/administrator_f3" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Produse vandute (Data)</button>
    </div>
</form>

<form action="/administrator_f4" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Produse vandute (Tip)</button>
    </div>
</form>

<form action="/administrator_f5" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Verificare stoc</button>
    </div>
</form>

<form action="/administrator_f7" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Add Magazin</button>
    </div>
</form>

<form action="/administrator_f6" method="get" style="margin-top: -14px;">
    <div class="container">
        <button type="submit">Istoric Angajati</button>
    </div>
</form>

        <%
            if (request.getAttribute("adm") != null) {
                Administrator adm = (Administrator) request.getAttribute("adm");
                session.setAttribute("adm",adm);
            }
        %>

</body>
</html>
