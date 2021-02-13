package repositories;

import models.Administrator;
import utils_db.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MagazinRepository {

    public static String allMagazin() throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Magazin_id from magazin;";
        ResultSet resultSet = statement.executeQuery(sql);

        StringBuilder listMagazine = new StringBuilder();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("Magazin_id");
            listMagazine.append(String.valueOf(id)).append("&");
        }

        return listMagazine.toString();

    }

    public static List<Integer> magazinByAdministrator(Administrator administrator) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Magazin_id from Administrator join Magazin using (Adm_username) " +
                "where Adm_username like '" + administrator.getUsername() + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Integer> listMagazine = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("Magazin_id");
            listMagazine.add(id);
        }

        return listMagazine;

    }


}
