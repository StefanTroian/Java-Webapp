package servlets;

import models.Administrator;
import models.Vanzator;
import repositories.AdministratorRepository;
import repositories.VanzatorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet("/vanzator")
public class VanzatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("loginVanzator.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username, parola;

        if (line.split("&").length == 2) {

            username = line.split("&")[0].split("=")[1];
            parola = line.split("&")[1].split("=")[1];

            try {

                Vanzator vanzator = VanzatorRepository.login(username,parola);

                if (vanzator == null) {

                    String mesaj = "Incearca din nou!";
                    req.setAttribute("mesaj",mesaj);
                    req.getRequestDispatcher("loginVanzator.jsp").forward(req,resp);

                } else {

                    req.setAttribute("vnz", vanzator);
                    req.getRequestDispatcher("vanzator.jsp").forward(req,resp);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }

        }

    }


}
