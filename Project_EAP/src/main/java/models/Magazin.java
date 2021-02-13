package models;

public class Magazin {

    protected Integer id;
    protected String nume;
    protected String adm;

    public Magazin(Integer id, String nume, String adm) {
        this.id = id;
        this.nume = nume;
        this.adm = adm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

}
