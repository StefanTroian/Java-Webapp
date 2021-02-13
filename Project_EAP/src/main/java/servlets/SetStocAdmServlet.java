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

@WebServlet("/administrator_f2")
public class SetStocAdmServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("setStocAdministrator.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username;
        Integer idProdus, stoc;

        if (line.split("&").length == 3) {

            idProdus = Integer.valueOf(line.split("&")[0].split("=")[1]);
            stoc = Integer.valueOf(line.split("&")[1].split("=")[1]);
            username = line.split("&")[2].split("=")[1];

            try {

                if (AdministratorRepository.stocProdus(idProdus,stoc,username) == false) {
                    String mesaj = "Update nereusit!";
                    req.setAttribute("mesaj", mesaj);
                    req.getRequestDispatcher("setStocAdministrator.jsp").forward(req,resp);
                } else {
                    req.getRequestDispatcher("setStocAdministrator.jsp").forward(req,resp);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }


}
