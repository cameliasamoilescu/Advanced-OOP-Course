package persoana;

import java.util.Date;

/**
 * Clasa Adult este derivata din Abonat si
 * implementeaza metodele abstracte
 * acord_reducere() si calculez_pret_legitimatie()
 *
 * Daca adultul se incadreaza in criteriile de reducere, acesta beneficiaza de 10%
 */


public class Adult extends Abonat {


    //daca se incadreaza in criteriile pentru reducere
    private boolean criteriuReducere;

    public Adult(String nume, String prenume, String cnp, String numarTelefon, boolean criteriuReducere) {
        super(nume, prenume, cnp, numarTelefon);
        this.criteriuReducere = criteriuReducere;
    }

    public Adult(int idAbonat, String nume, String prenume, Date dataInregistrare, String cnp, String numarTelefon, int nrAbateri, double pretLegitimatie, boolean criteriuReducere) {
        super(idAbonat, nume, prenume, dataInregistrare, cnp, numarTelefon, nrAbateri, pretLegitimatie);
        this.criteriuReducere = criteriuReducere;
    }



    public boolean isCriteriuReducere() {
        return criteriuReducere;
    }


    public void setCriteriuReducere(boolean criteriuReducere) {
        this.criteriuReducere = criteriuReducere;
    }

    @Override
    public String toString() {

        return "\nAdult { "+ super.toString() +
                "\n\t\tcriteriu_reducere=" + criteriuReducere +
                "\n\t\tpret_legitimatie=" + pretLegitimatie +
                "}\n";
    }

    @Override
    public double acordReducere() {
        if(criteriuReducere)
            return 10;
        return 0;
    }

    @Override
    public void calculezPretLegitimatie() {
        this.pretLegitimatie = this.pretStandard * (1 - this.acordReducere()/100);
    }


}
