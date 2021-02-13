<%--
  Created by IntelliJ IDEA.
  User: troia
  Date: 05/06/2020
  Time: 18:43
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
            font-family: 'Great Vibes', serif;font-size: 30px;
            padding: 10px;
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
            width: 290px;
            border: 1px solid white;
            -webkit-backdrop-filter: blur(5px);
            backdrop-filter: blur(5px);
            margin-left: 37%;
            margin-top:	80px;
            margin-bottom: 0px;
        }

        input[type=text], input[type=password] {
            width: 250px;
            padding: 10px 10px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid grey;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #3d3d3d;
            color: white;
            padding: 10px 10px;
            margin: 8px 0;
            border: 1px solid white;
            cursor: pointer;
            width: 250px;
            border-radius: 5px;
        }

        .container {
            width: 250px;
            padding: 20px;
        }
    </style>
</head>
<body>

<h3>
    <p>Aplicatie pentru gestionarea unui magazin</p>
</h3>

    <form action="/home_creare_adm" method="post" style="border-top-right-radius: 5px;
            border-bottom: 0px; border-top-left-radius: 5px;">
        <div class="container"style="padding-bottom: 0px;">
            <label for="nume">Nume</label>
            <input type="text" id="nume" placeholder="Nume" name="nume" required>
            <label for="prenume">Prenume</label>
            <input type="text" id="prenume" placeholder="Prenume" name="prenume" required>
            <label for="username">Username</label>
            <input type="text" id="username" placeholder="NumePrenume" name="username" required>
            <label for="parola">Parola</label>
            <input type="password" id="parola" placeholder="Parola" name="parola" required>

            <label style="color: crimson">

                <%
                    if (request.getAttribute("mesaj") != null) {
                        String mesaj = (String) request.getAttribute("mesaj");
                        out.print(mesaj);
                    } else out.print("");
                %>

            </label>
            <button type="submit">Inregistrare</button>
        </div>
    </form>

    <form action="/administrator" method="get" style="margin-top: 0px; border-top: 0px;
	border-bottom-left-radius: 5px; border-bottom-right-radius: 5px;">
        <div class="container" style="padding-top: 0px;">
            <button type="submit">Inapoi</button>
        </div>
    </form>

</body>
</html>
