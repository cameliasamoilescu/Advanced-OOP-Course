package persoana;

import biblioteca.Imprumut;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private Date dataInregistrare;
    private String cnp;
    private String numarTelefon;
    private int nrAbateri;
    protected double pretLegitimatie;
    protected static int pretStandard = 50;
    private ArrayList<Imprumut> cartiImprumutate;


    abstract public double acordReducere();
    abstract public void calculezPretLegitimatie();

    public Abonat(String nume, String prenume, String cnp, String numarTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataInregistrare = null;
        this.cnp = cnp;
        this.numarTelefon = numarTelefon;
        this.nrAbateri = 0;
        this.cartiImprumutate = new ArrayList<Imprumut>();
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

    public Date getDataInregistrare() {
        return dataInregistrare;
    }

    public void setDataInregistrare(Date dataInregistrare) {
        this.dataInregistrare = dataInregistrare;
    }

    public void setPretLegitimatie(double pretLegitimatie) {
        this.pretLegitimatie = pretLegitimatie;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public int getNrAbateri() {
        return nrAbateri;
    }

    public void setNrAbateri(int nrAbateri) {
        this.nrAbateri = nrAbateri;
    }

    public double getPretLegitimatie() {
        return pretLegitimatie;
    }

    public static int getPretStandard() {
        return pretStandard;
    }

    public static void setPretStandard(int pretStandard) {
        Abonat.pretStandard = pretStandard;
    }

    public ArrayList<Imprumut> getCartiImprumutate() {
        return cartiImprumutate;
    }

    public void setCartiImprumutate(ArrayList<Imprumut> cartiImprumutate) {
        this.cartiImprumutate = cartiImprumutate;
    }

    String afisareData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(data);
        return date;
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
                ",\n data_inregistrare='" + this.afisareData(dataInregistrare) + '\'' +
                ",\n cnp='" + cnp + '\'' +
                ",\n numar_telefon='" + numarTelefon + '\'' +
                ",\n nr_abateri=" + nrAbateri +
                ",\n pret_legitimatie=" + pretLegitimatie;
    }

}
