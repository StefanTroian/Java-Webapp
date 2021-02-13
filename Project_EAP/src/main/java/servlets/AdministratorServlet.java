package servlets;

import models.Administrator;
import repositories.AdministratorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet("/administrator")
public class AdministratorServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestDispatcher("loginAdministrator.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username, parola;

        if (line.split("&").length == 2) {

            username = line.split("&")[0].split("=")[1];
            parola = line.split("&")[1].split("=")[1];

            try {

                Administrator administrator = AdministratorRepository.login(username,parola);

                if (administrator == null) {

                    String mesaj = "Incearca din nou!";
                    req.setAttribute("mesaj",mesaj);
                    req.getRequestDispatcher("loginAdministrator.jsp").forward(req,resp);

                } else {

                    req.setAttribute("adm", administrator);
                    req.getRequestDispatcher("administrator.jsp").forward(req,resp);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
