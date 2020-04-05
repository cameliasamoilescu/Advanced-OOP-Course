package persoana;


/**
 * Clasa Adult este derivata din Abonat si
 * implementeaza metodele abstracte
 * acord_reducere() si calculez_pret_legitimatie()
 *
 * Daca adultul se incadreaza in criteriile de reducere, acesta beneficiaza de 10%
 */


public class Adult extends Abonat {


    //daca se incadreaza in criteriile pentru reducere
    private boolean criteriu_reducere;

    public Adult(String nume, String prenume, String data_inregistrare, String cnp, String numar_telefon, boolean criteriu_reducere) {
        super(nume, prenume, data_inregistrare, cnp, numar_telefon);
        this.criteriu_reducere = criteriu_reducere;
    }


    @Override
    public String toString() {

        return "\nAdult { "+ super.toString() +
                "\n\t\tcriteriu_reducere=" + criteriu_reducere +
                "\n\t\tpret_legitimatie=" + pret_legitimatie +
                "}\n";
    }

    @Override
    public double acord_reducere() {
        if(criteriu_reducere)
            return 10;
        return 0;
    }

    @Override
    public void calculez_pret_legitimatie() {
        this.pret_legitimatie = this.pret_standard * (1 - this.acord_reducere()/100);
    }


}
