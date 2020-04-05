package persoana;

/**
 * Clasa Student este derivata din Abonat si
 * implementeaza metodele abstracte
 * acord_reducere() si calculez_pret_legitimatie()
 *
 *
 * Daca studentul are carnetul vizat, pretul permisului are o reducere de 50%
 */


public class Student extends Abonat {

    private boolean carnet_vizat;

    public Student(String nume, String prenume, String data_inregistrare, String cnp, String numar_telefon, boolean carnet_vizat) {
        super(nume, prenume, data_inregistrare, cnp, numar_telefon);
        this.carnet_vizat = carnet_vizat;
    }

    @Override
    public String toString() {
        return  "\nStudent {" + super.toString() +
                "\n\t\tcarnet_vizat=" + carnet_vizat +
                "\n\t\tpret_legitimatie=" + pret_legitimatie +
                "}\n";
    }


    @Override
    public double acord_reducere() {
        if(carnet_vizat)
            return 50;
        else return 0;
    }

    @Override
    public void calculez_pret_legitimatie() {
        this.pret_legitimatie = this.pret_standard * (1 - this.acord_reducere()/100);
    }
}
