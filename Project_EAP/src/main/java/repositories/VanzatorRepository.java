package repositories;

import models.Administrator;
import models.Vanzator;
import utils_db.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VanzatorRepository {

    public static Vanzator login(String username, String parola) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from vanzator where Vnz_username like '" + username + "' and Parola like '" + parola + "';";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Vanzator vanzator = new Vanzator(
                    resultSet.getString("Vnz_username"),
                    resultSet.getString("Nume"),
                    resultSet.getString("Prenume"),
                    resultSet.getString("Parola"),
                    resultSet.getInt("Magazin_id")
            );
            return vanzator;
        } else return null;

    }

    public static boolean creareCont(String nume, String prenume, String username, String parola, Integer magazin) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();

        String sql = "select * from vanzator where Vnz_username like '" + username + "';";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) return false;
        else {

            sql = "insert into Vanzator(Vnz_username,Nume,Prenume,Parola,Magazin_id) values('"
                    + username + "','" + nume + "','" + prenume + "','" + parola + "','" + magazin +"');";

            statement.execute(sql);
            return true;

        }

    }

    public static List<Integer> produsByVanzator(Vanzator vanzator) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Produs_id " +
                "from vanzator join magazin using (Magazin_id) join produs_magazin using (Magazin_id) " +
                "join produs using (Produs_id)" +
                "where Vnz_username like '" + vanzator.getUsername() + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Integer> listProduse = new ArrayList<>();

        while (resultSet.next()) {
            listProduse.add(resultSet.getInt("Produs_id"));
        }

        return listProduse;
    }

    public static boolean vanzareProdus(Integer idProdus, String username, Integer cantitate) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Stoc from produs_magazin where Produs_id = " + idProdus + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        Integer stoc = 999;
        if (resultSet.next())
            stoc = resultSet.getInt("Stoc");

        if (cantitate > stoc) return false;
        else {
            sql = "insert into vanzare(Produs_id,Vnz_username,Cantitate,Data_vanzare) " +
                    "values (" + idProdus + ",'" + username + "'," + cantitate + ",curdate());";
            statement.execute(sql);
            sql = "update produs_magazin set Stoc = Stoc - " + cantitate + " where Produs_id = "
                    + idProdus + ";";
            statement.execute(sql);
            return true;
        }
    }

    public static List<String> verifStoc(String username) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Denumire, Stoc from Produs join Produs_magazin " +
                " using (Produs_id) join Magazin using (Magazin_id) join Vanzator using (Magazin_id)" +
                " where Vnz_username like '" + username + "' group by Produs_id;";
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> stoc = new ArrayList<>();

        while (resultSet.next()) {
            stoc.add(resultSet.getString("Denumire") + "\t" + resultSet.getInt("Stoc"));
        }

        return stoc;
    }

    public static List<String> istoricVanzari(String dataInceput, String dataFinal, String username) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Vnz_username, Denumire " +
                "from vanzare join produs using (Produs_id) join produs_magazin using (Produs_id) join Magazin using " +
                "(Magazin_id) join Vanzator using (Vnz_username)" +
                "where Vnz_username like '" + username + "' and " +
                "Data_vanzare > '" + dataInceput + "' and Data_vanzare < '" + dataFinal + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> istoric = new ArrayList<>();

        while (resultSet.next()) {
            istoric.add(resultSet.getString("Vnz_username") + "\t" + resultSet.getString("Denumire"));
        }

        return istoric;
    }


}
