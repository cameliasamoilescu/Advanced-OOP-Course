package persoana;

import java.util.Date;

/**
 * Clasa Student este derivata din Abonat si
 * implementeaza metodele abstracte
 * acord_reducere() si calculez_pret_legitimatie()
 *
 *
 * Daca studentul are carnetul vizat, pretul permisului are o reducere de 50%
 */


public class Student extends Abonat {

    private boolean carnetVizat;

    public Student(String nume, String prenume,  String cnp, String numarTelefon, boolean carnetVizat) {
        super(nume, prenume, cnp, numarTelefon);
        this.carnetVizat = carnetVizat;
    }

    public Student(int idAbonat, String nume, String prenume, Date dataInregistrare, String cnp, String numarTelefon, int nrAbateri, double pretLegitimatie, boolean carnetVizat) {
        super(idAbonat, nume, prenume, dataInregistrare, cnp, numarTelefon, nrAbateri, pretLegitimatie);
        this.carnetVizat = carnetVizat;
    }

    @Override
    public String toString() {
        return  "\nStudent {" + super.toString() +
                "\n\t\tcarnet_vizat=" + carnetVizat +
                "\n\t\tpret_legitimatie=" + pretLegitimatie +
                "}\n";
    }

    public boolean isCarnetVizat() {
        return carnetVizat;
    }

    public void setCarnetVizat(boolean carnetVizat) {
        this.carnetVizat = carnetVizat;
    }

    @Override
    public double acordReducere() {
        if(carnetVizat)
            return 50;
        else return 0;
    }

    @Override
    public void calculezPretLegitimatie() {
        this.pretLegitimatie = this.pretStandard * (1 - this.acordReducere()/100);
    }
}
