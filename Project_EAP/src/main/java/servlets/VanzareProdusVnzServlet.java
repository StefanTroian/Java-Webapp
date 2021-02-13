package servlets;

import repositories.VanzatorRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet("/vanzator_f1")
public class VanzareProdusVnzServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("vanzareProdusVanzator.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username;
        Integer idProdus, cantitate;

        if (line.split("&").length == 3) {

            idProdus = Integer.valueOf(line.split("&")[0].split("=")[1]);
            username = line.split("&")[1].split("=")[1];
            cantitate = Integer.valueOf(line.split("&")[2].split("=")[1]);

            try {

                if (VanzatorRepository.vanzareProdus(idProdus,username,cantitate) == false) {

                    String mesaj = "Stoc insuficient!";
                    req.setAttribute("mesaj", mesaj);
                    req.getRequestDispatcher("vanzareProdusVanzator.jsp").forward(req,resp);

                } else {
                    req.getRequestDispatcher("vanzareProdusVanzator.jsp").forward(req,resp);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
