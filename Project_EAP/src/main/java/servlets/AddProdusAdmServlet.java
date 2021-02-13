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

@WebServlet("/administrator_f1")
public class AddProdusAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("addProdusAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String denumire;
        Integer idMagazin, idProdus, stoc;

        if (line.split("&").length == 4) {

            idProdus = Integer.valueOf(line.split("&")[0].split("=")[1]);
            denumire = line.split("&")[1].split("=")[1];
            stoc = Integer.valueOf(line.split("&")[2].split("=")[1]);
            idMagazin = Integer.valueOf(line.split("&")[3].split("=")[1]);

            try {

                if (AdministratorRepository.addProdus(idProdus,denumire,stoc,idMagazin) == false) {

                    String mesaj = "ID Produs existent!";
                    req.setAttribute("mesaj", mesaj);
                    req.getRequestDispatcher("addProdusAdministrator.jsp").forward(req,resp);

                } else {

                    req.getRequestDispatcher("addProdusAdministrator.jsp").forward(req,resp);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
