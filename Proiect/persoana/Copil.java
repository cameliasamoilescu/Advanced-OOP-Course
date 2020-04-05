package persoana;

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

    public Copil(String nume, String prenume, String data_inregistrare, String cnp, String numar_telefon, int varsta) {
        super(nume, prenume, data_inregistrare, cnp, numar_telefon);
        this.varsta = varsta;
    }

    @Override
    public double acord_reducere() {
        if(this.varsta <  11)
            return 70;
        else
            return 50;
    }

    @Override
    public void calculez_pret_legitimatie() {
        this.pret_legitimatie = this.pret_standard * (1 - this.acord_reducere()/100);
    }

    @Override
    public String toString() {
        return "\nCopil {" + super.toString() + "\n\t\t\tvarsta = " + varsta + "\n}\n";
    }
}
