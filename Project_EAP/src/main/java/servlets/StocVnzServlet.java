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
import java.util.List;

@WebServlet("/vanzator_f2")
public class StocVnzServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("stocVanzator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String username;

        if (line.split("&").length == 1) {

            username = line.split("&")[0].split("=")[1];

            try {

                List<String> stoc = VanzatorRepository.verifStoc(username);
                if (stoc != null) {
                    req.setAttribute("mesaj", stoc);
                } else {
                    stoc.add("Niciun produs!");
                    req.setAttribute("mesaj", stoc);
                }
                req.getRequestDispatcher("stocVanzator.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
