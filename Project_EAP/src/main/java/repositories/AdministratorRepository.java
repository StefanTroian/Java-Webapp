package repositories;

import models.Administrator;
import utils_db.DBconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepository {

    public static Administrator login(String username, String parola) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from administrator where Adm_username like '" + username + "' and Parola like '" + parola + "';";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Administrator administrator = new Administrator(
                    resultSet.getString("Adm_username"),
                    resultSet.getString("Nume"),
                    resultSet.getString("Prenume"),
                    resultSet.getString("Parola")
            );
            return administrator;
        } else return null;

    }

    public static boolean creareCont(String nume, String prenume, String username, String parola) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from administrator where Adm_username like '" + username + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) return false;
        else {
            sql = "insert into Administrator(Adm_username,Nume,Prenume,Parola) values('"
                    + username + "','" + nume + "','" + prenume + "','" + parola + "');";

            statement.execute(sql);
            return true;
        }
    }

    public static boolean addProdus(Integer idProdus, String denumire, Integer stoc, Integer idMagazin) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from Produs_magazin where Produs_id = " + idProdus + " and Magazin_id = " + idMagazin + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) return false;
        else {
            sql = "insert into Produs(Produs_id, Denumire) values (" + idProdus + ",'" + denumire + "');";
            statement.execute(sql);
            sql = "insert into Produs_magazin(Produs_id, Magazin_id, Stoc) values (" + idProdus + ", " +
                    idMagazin + ", " + stoc + ");";
            statement.execute(sql);
            return true;
        }
    }

    public static boolean stocProdus(Integer idProdus, Integer stoc, String username) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from Produs join Produs_magazin using (Produs_id) join Magazin using (Magazin_id) " +
                "join Administrator using (Adm_username) where Adm_username like '" + username + "' and Produs_id = " +
                idProdus + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next())  {
            sql = "update produs_magazin set Stoc = " + stoc + " where Produs_id = " + idProdus + ";";
            statement.execute(sql);
            return true;
        } else return false;
    }

    public static List<Integer> produsByAdministrator(Administrator administrator) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Produs_id from Produs join Produs_magazin using (Produs_id) join Magazin " +
                "using (Magazin_id) join Administrator using (Adm_username) " +
                "where Adm_username like '" + administrator.getUsername() + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Integer> listProduse = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("Produs_id");
            listProduse.add(id);
        }

        return listProduse;
    }

    public static Integer raportProdusInterval(String dataInceput, String dataFinal, Integer idMagazin) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select sum(Cantitate) Nrprod " +
                "from vanzare join produs using (Produs_id) join produs_magazin using (Produs_id) join Magazin " +
                "using (Magazin_id) join Administrator using (adm_username)" +
                "where Data_vanzare > '" + dataInceput + "' and Data_vanzare < '" + dataFinal +
                "' and magazin_id = " + idMagazin + " group by magazin_id;";
        ResultSet resultSet = statement.executeQuery(sql);

        Integer sum = 0;
        if (resultSet.next()) sum = resultSet.getInt("Nrprod");

        return sum;
    }

    public static Integer raportProdusTip(Integer idProdus, String username) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select sum(Cantitate) Nrprod " +
                "from vanzare join produs using (Produs_id) join produs_magazin using (Produs_id) join " +
                "Magazin using (Magazin_id) join Administrator using (adm_username) where Produs_id = " + idProdus +
                " and Adm_username like '" + username + "' group by magazin_id;";
        ResultSet resultSet = statement.executeQuery(sql);

        Integer sum = 0;
        if (resultSet.next()) sum = resultSet.getInt("Nrprod");

        return sum;
    }

    public static List<String> verifStoc(Integer idMagazin) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Denumire ,Stoc from Produs join Produs_magazin " +
                "using (Produs_id) join Magazin using (Magazin_id) join Administrator using (Adm_username) " +
                "where Magazin_id = " + idMagazin + " group by Produs_id;";
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> stoc = new ArrayList<>();

        while (resultSet.next()) {
            String prod = String.format("%d \t %s", resultSet.getInt("Stoc"), resultSet.getString("Denumire"));
            stoc.add(prod);
        }

        return stoc;
    }

    public static List<String> istoricAngajat(Integer idMagazin) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select Vnz_username, Denumire " +
                "from vanzare join produs using (Produs_id) join produs_magazin using (Produs_id) join " +
                "Magazin using (Magazin_id) join Vanzator using (Vnz_username) " +
                "where Vanzator.Magazin_id = " + idMagazin +
                " group by Vnz_username,Denumire;";
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> istoricAng = new ArrayList<>();

        while (resultSet.next()) {
            istoricAng.add(resultSet.getString("Vnz_username") + "\t" + resultSet.getString("Denumire"));
        }

        return istoricAng;
    }

    public static boolean addMagazin(Integer idMagazin, String nume, String username) throws SQLException {

        Statement statement = DBconnection.getConnection().createStatement();
        String sql = "select * from Magazin where Magazin_id = " + idMagazin + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) return false;
        else {
            sql = "insert into Magazin(Magazin_id, Nume_magazin, Adm_username) values (" + idMagazin + ",'" + nume
                    + "','" + username + "');";
            statement.execute(sql);
            return true;
        }
    }


}
