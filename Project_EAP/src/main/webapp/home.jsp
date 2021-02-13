<%--
  Created by IntelliJ IDEA.
  User: troia
  Date: 05/05/2020
  Time: 17:32
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
        background: rgba(0,0,0, 0.15);
        margin: 0;
        color: white;
        font: 1px Helvetica, sans-serif;
        text-indent: 30px;
        border-bottom-right-radius: 5px;
        border-bottom-left-radius: 5px;
    }

    form {
        margin-right: 10px;
        margin-top: -5px;
        float: right;
    }

    button {
        background-color: #3d3d3d;
        color: white;
        margin-right: 15px;
        margin-top: -2px;
        padding: 15px 10px;
        border: 1px solid white;
        cursor: pointer;
        width: 180px;
        border-radius: 5px;
    }

</style>
</head>
<body>

<h3>
    <p>Aplicatie pentru gestionarea unui magazin
        <form method="get" action="/administrator">
            <button type="submit">Administrator</button>
        </form>

        <form method="get" action="/vanzator">
            <button type="submit">Vanzator</button>
        </form>
    </p>
</h3>

</body>
</html>
