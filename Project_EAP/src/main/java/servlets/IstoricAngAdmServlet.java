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
import java.util.List;

@WebServlet("/administrator_f6")
public class IstoricAngAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("istoricAngajatiAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        Integer idMagazin;

        if (line.split("&").length == 1) {

            idMagazin = Integer.valueOf(line.split("&")[0].split("=")[1]);

            try {

                List<String> istoric = AdministratorRepository.istoricAngajat(idMagazin);
                if (istoric != null) {
                    req.setAttribute("mesaj", istoric);
                } else {
                    istoric.add("Niciun angajat!");
                    req.setAttribute("mesaj", istoric);
                }
                req.getRequestDispatcher("istoricAngajatiAdministrator.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}