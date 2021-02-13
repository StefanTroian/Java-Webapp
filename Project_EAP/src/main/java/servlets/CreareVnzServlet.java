package servlets;

import repositories.AdministratorRepository;
import repositories.MagazinRepository;
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

@WebServlet("/home_creare_vnz")
public class CreareVnzServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String listMagazine = MagazinRepository.allMagazin();
            System.out.println(listMagazine);
            req.setAttribute("listMagazine", listMagazine);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("creareVanzator.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String line = req.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        String nume, prenume, username, parola;
        Integer magazin;

        if (line.split("&").length == 5) {

            nume = line.split("&")[0].split("=")[1];
            prenume = line.split("&")[1].split("=")[1];
            username = line.split("&")[2].split("=")[1];
            parola = line.split("&")[3].split("=")[1];
            magazin = Integer.valueOf(line.split("&")[4].split("=")[1]);

            try {

                if (VanzatorRepository.creareCont(nume, prenume, username, parola, magazin) == false) {
                    String mesaj = "Cont existent!";
                    req.setAttribute("mesaj", mesaj);
                    req.getRequestDispatcher("creareVanzator.jsp").forward(req,resp);
                } else {
                    req.getRequestDispatcher("loginVanzator.jsp").forward(req,resp);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                String mesaj = "Server/Connection Error";
                req.setAttribute("mesaj",mesaj);
            }

        }

    }


}
