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

@WebServlet("/administrator_f4")
public class NrProdTipAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("nrProdTipAdministrator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username;
        Integer idProdus;

        if (line.split("&").length == 2) {

            idProdus = Integer.valueOf(line.split("&")[0].split("=")[1]);
            username = line.split("&")[1].split("=")[1];

            try {

                Integer sum = AdministratorRepository.raportProdusTip(idProdus,username);
                String mesaj = "";

                if (sum != 0) {
                    mesaj = "Numar produse de tipul " + idProdus + " vandute: " + sum;
                } else {
                    mesaj = "Niciun produs de tipul " + idProdus + " vandut!";
                }

                System.out.println(mesaj);
                req.setAttribute("mesaj", mesaj);
                req.getRequestDispatcher("nrProdTipAdministrator.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}