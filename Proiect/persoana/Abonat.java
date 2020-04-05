package persoana;

import carte.Carte;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Abonat este clasa de baza pentru Adult, Copil, Student
 *
 * Aceasta este o clasa abstracta, deoarece pentru fiecare abonat
 * pretul legitimatiei se calculeaza diferit,
 * in functie de acordarea reducerii
 */

public abstract class Abonat{

    private String nume, prenume;
    private String data_inregistrare;
    private String cnp;
    private String numar_telefon;
    private int nr_abateri;
    protected double pret_legitimatie;
    protected static int pret_standard = 50;


    abstract public double acord_reducere();
    abstract public void calculez_pret_legitimatie();

    public Abonat(String nume, String prenume, String data_inregistrare, String cnp, String numar_telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_inregistrare = data_inregistrare;
        this.cnp = cnp;
        this.numar_telefon = numar_telefon;
        this.nr_abateri = 0;

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getData_inregistrare() {
        return data_inregistrare;
    }

    public void setData_inregistrare(String data_inregistrare) {
        this.data_inregistrare = data_inregistrare;
    }

    public void setPret_legitimatie(double pret_legitimatie) {
        this.pret_legitimatie = pret_legitimatie;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNumar_telefon() {
        return numar_telefon;
    }

    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    public int getNr_abateri() {
        return nr_abateri;
    }

    public void setNr_abateri(int nr_abateri) {
        this.nr_abateri = nr_abateri;
    }

    public double getPret_legitimatie() {
        return pret_legitimatie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonat abonat = (Abonat) o;
        return Objects.equals(cnp, abonat.cnp);
    }


    @Override
    public String toString() {
        return "\n nume='" + nume + '\'' +
                ",\n prenume='" + prenume + '\'' +
                ",\n data_inregistrare='" + data_inregistrare + '\'' +
                ",\n cnp='" + cnp + '\'' +
                ",\n numar_telefon='" + numar_telefon + '\'' +
                ",\n nr_abateri=" + nr_abateri +
                ",\n pret_legitimatie=" + pret_legitimatie ;
    }

}
