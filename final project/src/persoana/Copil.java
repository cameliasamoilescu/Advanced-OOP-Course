package persoana;

import java.util.Date;

/**
 * Clasa Copil este derivata din Abonat si
 * implementeaza metodele abstracte
 * acord_reducere() si calculez_pret_legitimatie()
 *
 * In cazul in care copilul are varsta mai mica de 11 ani,
 * beneficiaza de o reducere de 70%,
 * iar daca varsta este mai mare reducerea este de doar 50%.
 */

public class Copil extends Abonat{
    int varsta;

    public Copil(String nume, String prenume,  String cnp, String numarTelefon, int varsta) {
        super(nume, prenume,  cnp, numarTelefon);
        this.varsta = varsta;
    }

    public Copil(int idAbonat, String nume, String prenume, Date dataInregistrare, String cnp, String numarTelefon, int nrAbateri, double pretLegitimatie, int varsta) {
        super(idAbonat, nume, prenume, dataInregistrare, cnp, numarTelefon, nrAbateri, pretLegitimatie);
        this.varsta = varsta;
    }


    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public double acordReducere() {
        if(this.varsta <  11)
            return 70;
        else
            return 50;
    }

    @Override
    public void calculezPretLegitimatie() {
        this.pretLegitimatie = this.pretStandard * (1 - this.acordReducere()/100);
    }

    @Override
    public String toString() {
        return "\nCopil {" + super.toString() + "\n\t\t\tvarsta = " + varsta + "\n}\n";
    }
}
