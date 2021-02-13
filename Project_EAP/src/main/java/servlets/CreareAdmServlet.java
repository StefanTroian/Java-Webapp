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

@WebServlet("/home_creare_adm")
public class CreareAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestDispatcher("creareAdministrator.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String nume, prenume, username, parola;

        if (line.split("&").length == 4) {

            nume = line.split("&")[0].split("=")[1];
            prenume = line.split("&")[1].split("=")[1];
            username = line.split("&")[2].split("=")[1];
            parola = line.split("&")[3].split("=")[1];

            try {

                if (AdministratorRepository.creareCont(nume, prenume, username, parola) == false) {

                    String mesaj = "Cont existent!";
                    req.setAttribute("mesaj",mesaj);
                    req.getRequestDispatcher("creareAdministrator.jsp").forward(req,resp);

                } else {

                    req.getRequestDispatcher("loginAdministrator.jsp").forward(req,resp);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
