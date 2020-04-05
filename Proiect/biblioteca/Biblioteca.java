package biblioteca;

import carte.Carte;
import persoana.Abonat;

import java.text.ParseException;
import java.util.*;

/**
 * Clasa biblioteca incapsuleaza toate datele bibliotecii si se comporta ca un
 * bibliotecar. Gestioneaza date si actiuni specifice unei biblioteci.
 *
 * Clasa contine datele tuturor abonatilor bibliotecii, a cartilor, a cartilor imprumutate
 * si pentru fiecare abonat cartile imprumutate de acesta
 *
 *
 * Aceasta contine metodele:
 *          adaugaAdonat()
 *          scoateAbonat()
 *          adaugaCarteinStoc()
 *          scoateCartedinStoc()
 *          dezaboneaza()
 *          cautaCarte()
 *          imprumuta_carte()
 *          restituie_carte()
 *          prelungeste_termen_imprumut()
 *          afiseaza_cartile_imprumutate_de_abonat()
 *          sumaTotala()
 *          afiseaza_cartile_pe_stoc()
 *          afiseaza_abonatii()
 *          afiseaza_cartile_imprumutate
 */

public class Biblioteca {

    private String nume;

    //abonatii bibliotecii
    private ArrayList<Abonat> abonati;

    //Stocul de carti al bibliotecii
    private ArrayList<Carte> carti;

    //Retinem pentru fiecare Abonat ce carti a imprumutat
    private HashMap<Abonat, ArrayList<Imprumut> > imprumuturi;
    private ArrayList<Carte> carti_imprumutate;



    public Biblioteca(String nume){

        this.nume = nume;
        this.abonati = new ArrayList<Abonat>();
        this.carti = new ArrayList<Carte>();
        this.imprumuturi = new HashMap<Abonat, ArrayList<Imprumut>>();
        this.carti_imprumutate = new ArrayList<Carte>();

    }

    public Biblioteca(String nume, ArrayList<Carte> carti) {


        this.abonati = new ArrayList<>();
        this.carti = carti;
        this.imprumuturi = new HashMap<Abonat, ArrayList<Imprumut>>();
        this.carti_imprumutate = new ArrayList<Carte>();

    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<Abonat> getAbonati() {
        return abonati;
    }

    public void setAbonati(ArrayList<Abonat> abonati) {
        this.abonati = abonati;
    }

    public ArrayList<Carte> getCarti() {
        return carti;
    }

    public void setCarti(ArrayList<Carte> carti) {
        this.carti = carti;
    }


    public HashMap<Abonat, ArrayList<Imprumut>> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(HashMap<Abonat, ArrayList<Imprumut>> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }

    public ArrayList<Carte> getCarti_imprumutate() {
        return carti_imprumutate;
    }

    public void setCarti_imprumutate(ArrayList<Carte> carti_imprumutate) {
        this.carti_imprumutate = carti_imprumutate;
    }



    // adauga abonat in baza de date a bibliotecii
    public void adaugaAbonat(Abonat abonat){


        if(!abonati.contains(abonat)){
            this.abonati.add(abonat);
            abonat.calculez_pret_legitimatie();

            Collections.sort(abonati, new sortareAbonati());

        }
        else
            System.out.println("\nAbonat existent\n");
    }


    //scoate abonatul din baza de date a bibliotecii daca exista
    public void scoateAbonat(Abonat abonat){

        if(!abonati.contains(abonat))
            System.out.println("\nNu exista acest abonat: \n");
        else
            abonati.remove(abonat);
    }

    //daca nu exista in stocul bibliotecii, adaug carte
    public void adaugaCarteinStoc(Carte carte){
        if(carti.contains(carte))
            System.out.println("\nCartea " + carte + " este deja in stoc\n");
        carti.add(carte);

    }

    //scot carte daca exista in stocul bibliotecii
    public void scoateCartedinStoc(Carte carte) {
        if(carti.contains(carte))
            carti.remove(carte);
        else
            System.out.println("\n Cartea nu este in stoc\n");
    }


    // scot din baza de date a bibliotecii toti abonatii care au mai mult de 5 abateri
    public void dezaboneaza(){

        ArrayList<Imprumut> items;

        for(int i = 0; i < abonati.size(); i ++){
            Abonat abonat = abonati.get(i);

            if(abonat.getNr_abateri() >= 5){

                items = imprumuturi.get(abonat);

                for(Imprumut imprumut:items) {
                    //restituie toate cartile inainte sa fie scos din baza de date
                    imprumut.carte.setImprumutata(false);
                    carti_imprumutate.remove(imprumut.carte);
                }

                imprumuturi.remove(abonat);
                this.scoateAbonat(abonat);
            }
        }
    }

    //verifica daca o carte este in stocul bibliotecii si daca este disponibila pentru a fi imprumutata
    public boolean cautaCarte(Carte carte){
        for(int i = 0; i < carti.size(); i ++) {
            Carte carteCurenta = carti.get(i);
            if(carte.equals(carteCurenta) && !carte.isImprumutata())

                return true;
        }

        System.out.println(" Cartea " + carte.toString() + " nu este disponibila\n");
        return false;
    }



    //Am presupus ca un abonat poate sa imprumute maxim o carte intr-o zi
    public void imprumuta_carte(Abonat abonat, Carte carte, String data) throws ParseException {


        Imprumut imprumut = new Imprumut(abonat, data, "", carte);
        imprumut.calculeaza_data_restituire();

        ArrayList<Imprumut> items;

        // verific daca ceea ce vreau sa imprumut este disponibil
        if(cautaCarte(carte)) {

            carte.setImprumutata(true);
            items = imprumuturi.get(abonat);

            if (items == null) {

                // daca abonatul nu are nicio carte imprumutata in momentul de fata
                items = new ArrayList<Imprumut>();

                // adaug cartea in evidenta cartilor imprumutate
                carti_imprumutate.add(carte);

                // adaug cartea la imprumuturile abonatului
                items.add(imprumut);
                Collections.sort(items, new sortareImprumut());

                imprumuturi.put(abonat, items);

            } else {

                items.add(imprumut);
                Collections.sort(items, new sortareImprumut());
                carti_imprumutate.add(carte);


            }
        }
        else
            System.out.println("Cartea nu este disponibila");
    }



    public void restituie_carte(Abonat abonat, Carte carte, String data_curenta) {

        ArrayList<Imprumut> items = imprumuturi.get(abonat);
        Imprumut imprumut_curent = null;

        for (Imprumut imprumut : items) {

            if (imprumut.carte.equals(carte)) {

                imprumut_curent = imprumut;
                items.remove(imprumut);

                carti_imprumutate.remove(carte);

                carte.setImprumutata(false);
                break;
            }
        }

        // comparam data la care restituie cartea cu data la care trebuie restituita si adaugam/nu adaugam penalitati
        if (imprumut_curent != null && imprumut_curent.getData_restituire().compareTo(data_curenta) <= 0) {
            abonat.setNr_abateri(abonat.getNr_abateri() + 1);
        }

    }



    public void prelungeste_termen_imprumut(Abonat abonat, Carte carte, String data_curenta) throws ParseException {

        ArrayList<Imprumut> items = imprumuturi.get(abonat);


        if(items != null)
            for(Imprumut imprumut:items)
            {

                // Daca abonatul are carti pe care nu le-a restituit la timpl, nu i se acorda prelungirea
                if (imprumut.getData_restituire().compareTo(data_curenta) <= 0)
                {
                    abonat.setNr_abateri(abonat.getNr_abateri() + 1);
                    System.out.println("\nNu puteti prelungi perioada de imprumut deoarece nu ati respectat data restituirii cartilor imprumutate\n");
                    break;
                }


                if (imprumut.carte.equals(carte)){
                    imprumut.prelungeste_perioada(data_curenta);
                }

            }

    }

    public void afiseaza_cartile_imprumutate_de_abonat(Abonat abonat){


        if(!abonati.contains(abonat))
            System.out.println("\nNu exita abonatul cautat\n");
        else {
            ArrayList<Imprumut> items = imprumuturi.get(abonat);

            if (items == null)
                System.out.println("\nAbonatul" + abonat + "nu are nicio carte imprumutata\n");
            else {
                //System.out.println(items.toString());
                System.out.println("\nAbonatul" + abonat + " a imprumutat:\n");
                for (Imprumut imprumut : items)
                    System.out.println(imprumut.toString());
            }
        }
    }

    public double sumaTotala(){

        double suma = 0;

        for(Abonat abonat: abonati){

            suma += abonat.getPret_legitimatie();
        }

        return suma;
    }

    public  void afiseaza_cartile_pe_stoc(){

        System.out.println("\nBiblioteca are pe stoc urmatoarele carti: \n");
        for (Carte carte: carti)
            System.out.println(carte.toString());
    }

    public  void afiseaza_abonatii(){

        System.out.println("\nBiblioteca are urmatorii abonati: \n");
        for (Abonat abonat: abonati)
            System.out.println(abonat.toString());
    }


    public  void afiseaza_cartile_imprumutate(){

        System.out.println("\nBiblioteca a imprumutat urmatoarele carti: \n");
        for (Carte carte: carti_imprumutate)
            System.out.println(carte.toString());
    }




    @Override
    public String toString() {
        return "Biblioteca{" +
                "nume='" + nume + '\'' +
                ", abonati=" + abonati.toString() +
                ", carti=" + carti.toString() +
                '}';
    }

}
