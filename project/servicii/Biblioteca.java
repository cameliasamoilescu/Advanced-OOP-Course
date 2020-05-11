package servicii;

import biblioteca.Imprumut;
import biblioteca.SortareImprumut;
import carte.Carte;
import persoana.Abonat;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/** Clasa biblioteca incapsuleaza toate datele bibliotecii si se comporta ca un
* bibliotecar. Gestioneaza date si actiuni specifice unei biblioteci.
*
* Clasa contine datele tuturor abonatilor bibliotecii, a cartilor,
* si a imprumuturilor pe zile
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


    private HashMap<Date, ArrayList<Imprumut>> imprumutPeZile;
    private ServiciiAbonati serviciiAbonati;
    private ServiciiCarti serviciiCarti;
    private static Audit audit = Audit.getInstance();

    public Biblioteca(ServiciiAbonati serviciiAbonati, ServiciiCarti serviciiCarti) {
        this.serviciiAbonati = serviciiAbonati;
        this.serviciiCarti = serviciiCarti;
        this.imprumutPeZile = new HashMap<Date, ArrayList<Imprumut>>();

    }

    public void dezaboneaza(){

        ArrayList<Imprumut> items;
        ArrayList<Abonat> abonati = serviciiAbonati.getAbonati();

        for (int i = 0; i < abonati.size(); i++) {
            Abonat abonat = abonati.get(i);
            ArrayList<Imprumut> imprumuturi = abonat.getCartiImprumutate();

            if (abonat.getNrAbateri() >= 5) {

                for (Imprumut imprumut : imprumuturi) {
                    //restituie toate cartile inainte sa fie scos din baza de date
                    Carte carte = imprumut.getCarte();
                    carte.setImprumutata(false);

                    Date dataImprumut = imprumut.getDataImprumut();

                    ArrayList<Imprumut> imprumutPeZile = this.imprumutPeZile.get(dataImprumut);
                    imprumutPeZile.remove(imprumut);
                    this.imprumutPeZile.put(dataImprumut, imprumutPeZile);

                    serviciiCarti.getCartiImprumutate().remove(carte);
                }
                serviciiAbonati.scoateAbonat(abonat);
            }
        }

        audit.write("dezaboneaza  ");
    }

    public void afiseazaCartileImprumutateDeAbonat(String cnpAbonat){
        audit.write("afiseazaCartileImprumutateDeAbonat  ");

        ArrayList<Abonat> abonati = serviciiAbonati.getAbonati();
        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);

        if (abonat == null)
            return;

        ArrayList<Imprumut> imprumuturi = abonat.getCartiImprumutate();


        if (imprumuturi.size() == 0) {
            System.out.println("\nAbonatul" + abonat + " nu a imprumutat nicio carte\n");
        } else {
            //System.out.println(items.toString());
            System.out.println("\nAbonatul" + abonat + " a imprumutat:\n");
            for (Imprumut imprumut : imprumuturi)
                System.out.println(imprumut.toString());
        }





    }

    public void prelungesteTermenImprumut(String cnpAbonat, int idCarte, Date dataCurenta) throws ParseException {

        audit.write("prelungesteTermenImprumut");
        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);

        if (abonat == null){
            return;
        }
        ArrayList<Imprumut> imprumuturi = abonat.getCartiImprumutate();
        Carte carte = serviciiCarti.cautaCarteDupaIdCarte(idCarte);


        for (Imprumut imprumut : imprumuturi) {

            // Daca abonatul are carti pe care nu le-a restituit la timpl, nu i se acorda prelungirea
            if (imprumut.getDataRestituire().compareTo(dataCurenta) <= 0) {
                abonat.setNrAbateri(abonat.getNrAbateri() + 1);
                System.out.println("\nNu puteti prelungi perioada de imprumut deoarece nu ati respectat data restituirii cartilor imprumutate\n");
                return;
            }
        }

        for (Imprumut imprumut : imprumuturi) {
            if (imprumut.getCarte().equals(carte)) {
                imprumut.prelungestePerioada(dataCurenta);

                return;
            }
        }

        System.out.println("\nAbonatul nu are aceasta carte imprumutata\n");


    }

    //Am presupus ca un abonat poate sa imprumute maxim o carte intr-o zi
    public void imprumutaCarte(String cnpAbonat, String titluCarte, String autorCarte, Date data) throws ParseException {

        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);

        if (abonat != null) {
            ArrayList<Imprumut> items;

            ArrayList<Imprumut> imprumuturi = abonat.getCartiImprumutate();

            // verific daca ceea ce vreau sa imprumut este disponibil
            Carte carte = serviciiCarti.cautaCarte(titluCarte, autorCarte);
            if (carte != null) {

                Imprumut imprumut = new Imprumut(abonat, data, null, carte);
                imprumut.calculeazaDataRestituire();

                carte.setImprumutata(true);

                // adaug cartea in evidenta cartilor imprumutate
                serviciiCarti.getCartiImprumutate().add(carte);

                // adaug cartea la imprumuturile abonatului
                imprumuturi.add(imprumut);

                ArrayList<Imprumut> imprumutPeZile = this.imprumutPeZile.get(data);
                if (imprumutPeZile != null) {
                    imprumutPeZile.add(imprumut);
                    Collections.sort(imprumutPeZile, new SortareImprumut());
                } else {
                    imprumutPeZile = new ArrayList<Imprumut>();
                    imprumutPeZile.add(imprumut);
                    this.imprumutPeZile.put(data, imprumutPeZile);

                }

                Collections.sort(imprumuturi, new SortareImprumut());
                abonat.setCartiImprumutate(imprumuturi);

            }

        } else
            System.out.println("Adaugati mai intai abonatul, dupa aceea efectuati imprumutul");

        audit.write("imprumutaCarte ");

    }


    public void restituieCarte(String cnpAbonat, int idCarte, Date dataCurenta){

        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);
        Carte carte = serviciiCarti.cautaCarteDupaIdCarte(idCarte);
        ArrayList<Imprumut> imprumuturi = abonat.getCartiImprumutate();

        Imprumut imprumut_curent = null;
        boolean aImprumutat = false;

        for (Imprumut imprumut : imprumuturi) {

            if (imprumut.getCarte().equals(carte)) {

                imprumut_curent = imprumut;
                imprumuturi.remove(imprumut);
                abonat.setCartiImprumutate(imprumuturi);


                serviciiCarti.getCartiImprumutate().remove(carte);
                carte.setImprumutata(false);

                Date dataImprumut = imprumut.getDataImprumut();

                ArrayList<Imprumut> imprumutPeZile = this.imprumutPeZile.get(dataImprumut);
                imprumutPeZile.remove(imprumut);
                this.imprumutPeZile.put(dataImprumut, imprumutPeZile);

                aImprumutat = true;
                break;
            }
        }

        if (aImprumutat) {

            // comparam data la care restituie cartea cu data la care trebuie restituita si adaugam/nu adaugam penalitati
            if (imprumut_curent.getDataRestituire().compareTo(dataCurenta) <= 0) {
                abonat.setNrAbateri(abonat.getNrAbateri() + 1);
            }
        } else {
            System.out.println("Abonatul " + abonat + " nu a imprumutat aceasta carte");
        }

        audit.write("restituieCarte ");

    }


    public void afiseazaImprumuturiDeLaData(Date date){


        if (this.imprumutPeZile.containsKey(date)) {
            ArrayList<Imprumut> items = this.imprumutPeZile.get(date);

            if (items.size() != 0) {
                System.out.println("\nLa data de: " + date.toString() + " au existat urmatoarele imprumuturi: \n");
                for (Imprumut item : items) {
                    System.out.println(item);
                }
            } else {
                System.out.println("\nLa data de: " + date.toString() + " nu a existat nicun imprumut\n");

            }

        } else {
            System.out.println("\nLa data de: " + date.toString() + " nu a existat nicun imprumut \n");

        }

        audit.write("imprumutaCarte ");

    }

    public void afiseazaAbonatii(){
        serviciiAbonati.afiseazaAbonatii();
        audit.write("afiseazaAbonatii ");

    }

    public void adaugaAbonat(Abonat abonat){
        serviciiAbonati.adaugaAbonat(abonat);
        audit.write("adaugaAbonat ");
    }

    public void cautaAbonat(String cnp){
        audit.write("cautaAbonat ");
        serviciiAbonati.cautaAbonat(cnp);

    }


    public void adaugaCarteinStoc(Carte carte){
        audit.write("adaugaCarteinStoc ");
        serviciiCarti.adaugaCarteinStoc(carte);
    }

    public void afiseazaCartilePeStoc(){
        audit.write("afiseazaCartilePeStoc ");
        serviciiCarti.afiseazaCartilePeStoc();
    }

    public void afiseazaCartileImprumutate(){
        audit.write("afiseazaCartileImprumutate ");
        serviciiCarti.afiseazaCartileImprumutate();

    }


    public void scoateCartedinStoc(int idCarte){
        audit.write("scoateCartedinStoc ");
        serviciiCarti.scoateCartedinStoc(idCarte);

    }

    public void cautaCarte(String titlu, String autor){
        audit.write("cautaCarte ");
        serviciiCarti.cautaCarte(titlu, autor);
    }


    public void cautaCarteDupaIdCarte(int idCarte){
        audit.write("cautaCarteDupaIdCarte ");
        serviciiCarti.cautaCarteDupaIdCarte(idCarte);
    }


}

