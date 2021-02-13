<%@ page import="java.util.List" %>
<%@ page import="models.Vanzator" %><%--
  Created by IntelliJ IDEA.
  User: troia
  Date: 05/11/2020
  Time: 19:51
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
            background-size: 100%;
            margin: 0;
            color: white;
            font-family: Helvetica, sans-serif;
        }

        p {
            font-family: 'Great Vibes';font-size: 30px;
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
            width: 200px;
            margin-left: 5px;
            margin-right: 0px;
            margin-top:	200px;
            margin-bottom: 0px;
            float: left;
        }

        input[type=text], input[type=password], input[list] {
            width: 250px;
            padding: 10px 10px;
            margin-bottom: 20px;
            display: inline-block;
            border: 1px solid grey;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #3d3d3d;
            color: white;
            padding: 10px 10px;
            margin: 5px 0;
            border: 1px solid white;
            cursor: pointer;
            width: 200px;
            border-radius: 5px;
        }

        .container {
            width: 200px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h3>
    <p>Aplicatie pentru gestionarea unui magazin
    <form action="/vanzator" method="get" style="margin-top: -53px; margin-right: -10px; float: right;">
        <div class="container">
            <button type="submit" style="width: 150px;">Log out</button>
        </div>
    </form>
    </p>
</h3>


<form action="/vanzator_f1" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Plasare vanzare</button>
    </div>
</form>

<form action="/vanzator_f2" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Verificare stoc</button>
    </div>
</form>

<form action="/vanzator_f3" method="get" style="margin-top: 0px;">
    <div class="container">
        <button type="submit">Istoric produse</button>
    </div>
</form>

<br><br><br><br><br>
<form action="/vanzator_f3" method="post" style="margin-top: 10px;
            margin-left: 25px;
            width: 290px;
            border: 1px solid white;
            -webkit-backdrop-filter: blur(5px);
            backdrop-filter: blur(5px);
            margin-bottom: 10px;
            border-bottom-right-radius: 5px;
            border-bottom-left-radius: 5px;
            border-top-right-radius: 5px;
            border-top-left-radius: 5px;
            padding-bottom: 20px;
            padding-left: 40px;
            padding-top: 20px;
">

    <div class="container">
        <label for="dataInceput">Data Inceput</label>
        <input type="text" id="dataInceput" placeholder="YYYY-M-DD" name="dataInceput" required>
        <label for="dataFinal">Data Final</label>
        <input type="text" id="dataFinal" placeholder="YYYY-M-DD" name="dataFinal" required>

            <%
                String username;
                username = ((Vanzator) session.getAttribute("vnz")).getUsername();
                out.print("<input type=\"hidden\" id=\"username\" name=\"username\" value='" + username + "'>");
            %>

        <br>
        <button type="submit" style="width: 250px;">Istoric produse</button>
        <label>

            <%
                if (request.getAttribute("mesaj") != null) {
                    List<String> stoc = (List<String>) request.getAttribute("mesaj");
                    for (int i = 0; i < stoc.size(); i++) {
                        out.print("<label>" + stoc.get(i) + "</label><br>");
                    }
                } else out.print("");
            %>

        </label>
    </div>
</form>

</body>
</html>