package servlets;

import repositories.AdministratorRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet("/administrator_f7")
public class AddMagazinAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("addMagazinAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String nume, username;
        Integer idMagazin;

        if (line.split("&").length == 3) {

            idMagazin = Integer.valueOf(line.split("&")[0].split("=")[1]);
            nume = line.split("&")[1].split("=")[1];
            username = line.split("&")[2].split("=")[1];

            try {

                if (AdministratorRepository.addMagazin(idMagazin,nume,username) == false) {

                    String mesaj = "ID Magazin existent!";
                    req.setAttribute("mesaj", mesaj);
                    req.getRequestDispatcher("addMagazinAdministrator.jsp").forward(req,resp);

                } else {

                    req.getRequestDispatcher("addMagazinAdministrator.jsp").forward(req,resp);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
