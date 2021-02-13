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

@WebServlet("/administrator_f5")
public class StocAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("stocAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        Integer idMagazin;

        if (line.split("&").length == 1) {

            idMagazin = Integer.valueOf(line.split("&")[0].split("=")[1]);

            try {

                List<String> stoc = AdministratorRepository.verifStoc(idMagazin);
                if (stoc != null) {
                    req.setAttribute("mesaj", stoc);
                } else {
                    stoc.add("Niciun produs!");
                    req.setAttribute("mesaj", stoc);
                }
                req.getRequestDispatcher("stocAdministrator.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}