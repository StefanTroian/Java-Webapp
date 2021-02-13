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

@WebServlet("/administrator_f3")
public class NrProdIntervalAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("nrProduseIntervalAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String dataInceput, dataFinal;
        Integer idMagazin;

        if (line.split("&").length == 3) {

            dataInceput = line.split("&")[0].split("=")[1];
            dataFinal = line.split("&")[1].split("=")[1];
            idMagazin = Integer.valueOf(line.split("&")[2].split("=")[1]);

            try {

                Integer sum = AdministratorRepository.raportProdusInterval(dataInceput,dataFinal,idMagazin);
                String mesaj = "";

                if (sum != 0) {
                    mesaj = "Numar produse vandute la magazinul " + idMagazin + ": " + sum;
                } else {
                    mesaj = "Niciun produs vandut la magazinul " + idMagazin;
                }

                System.out.println(mesaj);
                req.setAttribute("mesaj", mesaj);
                req.getRequestDispatcher("nrProduseIntervalAdministrator.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}