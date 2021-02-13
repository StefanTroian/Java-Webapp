package models;

public class Administrator {

    protected String Username;
    protected String Nume;
    protected String Prenume;
    protected String Parola;

    public Administrator(String username, String nume, String prenume, String parola) {
        Username = username;
        Nume = nume;
        Prenume = prenume;
        Parola = parola;
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

    @Override
    public String toString() {
        return "Administrator: " + Username + " " + Nume + " " + Prenume + " " + Parola;
    }

}
