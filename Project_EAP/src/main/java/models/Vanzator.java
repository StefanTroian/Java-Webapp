package models;

public class Vanzator {

    protected String Username;
    protected String Nume;
    protected String Prenume;
    protected String Parola;
    protected Integer Magazin;

    public Vanzator(String username, String nume, String prenume, String parola, Integer magazin) {
        Username = username;
        Nume = nume;
        Prenume = prenume;
        Parola = parola;
        Magazin = magazin;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    public Integer getMagazin() {
        return Magazin;
    }

    public void setMagazin(Integer magazin) {
        Magazin = magazin;
    }
}
