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

@WebServlet("/vanzator_f3")
public class IstoricVnz extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("produseVnz.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String dataInceput, dataFinal, username;

        if (line.split("&").length == 3) {

            dataInceput = line.split("&")[0].split("=")[1];
            dataFinal = line.split("&")[1].split("=")[1];
            username = line.split("&")[2].split("=")[1];

            try {

                List<String> istoric = VanzatorRepository.istoricVanzari(dataInceput,dataFinal,username);
                if (istoric != null) {
                    req.setAttribute("mesaj", istoric);
                } else {
                    istoric.add("Niciun produs vandut!");
                    req.setAttribute("mesaj", istoric);
                }
                req.getRequestDispatcher("produseVnz.jsp").forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }
        }

    }


}
