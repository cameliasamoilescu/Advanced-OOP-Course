package servicii;

import biblioteca.Imprumut;
import carte.Carte;
import dataBase.AbonatiBD;
import dataBase.CartiBD;
import dataBase.ImprumutBD;
import javafx.util.Pair;
import persoana.Abonat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    private ServiciiAbonati serviciiAbonati;
    private ServiciiCarti serviciiCarti;
    private ServiciiImprumut serviciiImprumut;

    private static Audit audit = Audit.getInstance();


    public Biblioteca(){
        AbonatiBD abonatiBD = new AbonatiBD();
        ImprumutBD imprumutBD = new ImprumutBD();
        CartiBD cartiBD = new CartiBD();
        this.serviciiAbonati = new ServiciiAbonati();
        this.serviciiCarti = new ServiciiCarti();
        this.serviciiImprumut = new ServiciiImprumut();
    }

    public ServiciiAbonati getServiciiAbonati() {
        return serviciiAbonati;
    }

    public ServiciiCarti getServiciiCarti() {
        return serviciiCarti;
    }

    public ServiciiImprumut getServiciiImprumut() {
        return serviciiImprumut;
    }

    public void start(){
        this.serviciiAbonati = new ServiciiAbonati(AbonatiBD.getAbonati());


        Pair<HashMap<Integer, ArrayList<Imprumut>>,  HashMap<String, ArrayList<Imprumut>>> pair= ImprumutBD.getImprumuturi();
        this.serviciiImprumut = new ServiciiImprumut(pair.getKey(), pair.getValue());


        Pair<ArrayList<Carte>, ArrayList<Carte> > pairs = CartiBD.getCarti();
        this.serviciiCarti = new ServiciiCarti(pairs.getKey(), pairs.getValue());

        ArrayList<Abonat> abonati = serviciiAbonati.getAbonati();
        Abonat maximAbonat;

        ArrayList<Carte> carti = serviciiCarti.getCarti();
        if(abonati.size() != 0){
            maximAbonat = abonati.stream().max(Comparator.comparing(Abonat::getIdAbonat)).get();
            Abonat.setCounter(maximAbonat.getIdAbonat());
        }

        Carte maximCarte;
        if(carti.size() != 0) {
            maximCarte = serviciiCarti.getCarti().stream().max(Comparator.comparing(Carte::getIdCarte)).get();
            Carte.setCounter(maximCarte.getIdCarte());
        }
    }

    public void dezaboneaza(){

        ArrayList<Imprumut> items;
        ArrayList<Abonat> abonati = serviciiAbonati.getAbonati();

        for (Abonat abonat : abonati) {
            ArrayList<Imprumut> imprumuturi = serviciiImprumut.getImprumuturiAbonat(abonat.getIdAbonat());


            if (abonat.getNrAbateri() >= 5) {

                if (imprumuturi != null) {
                    for (Imprumut imprumut : imprumuturi) {
                        //restituie toate cartile inainte sa fie scos din baza de date
                        Carte carte = serviciiCarti.cautaCarteDupaIdCarte(imprumut.getIdCarte());
                        carte.setImprumutata(false);
                        CartiBD.updateCarte(carte.getIdCarte(), false);

                        Date dataImprumut = imprumut.getDataImprumut();

                        serviciiImprumut.stergeImprumutDinZiua(new SimpleDateFormat("yyyy-MM-dd").format(dataImprumut), imprumut);
                        ImprumutBD.deleteImprumuturi(abonat.getIdAbonat(), carte.getIdCarte());
                        serviciiCarti.getCartiImprumutate().remove(carte);
                    }
                    serviciiAbonati.scoateAbonat(abonat);
                    AbonatiBD.deleteAbonati(abonat.getIdAbonat());
                }
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

        ArrayList<Imprumut> imprumuturi = serviciiImprumut.getImprumuturiAbonat(abonat.getIdAbonat());


        if (imprumuturi == null) {
            System.out.println("\nAbonatul" + abonat + " nu a imprumutat nicio carte\n");
        } else {
            //System.out.println(items.toString());
            System.out.println("\nAbonatul" + abonat + " a imprumutat:\n");
            imprumuturi.stream().forEach(imprumut -> System.out.println(imprumut.toString()));

        }





    }

    public int prelungesteTermenImprumut(String cnpAbonat, int idCarte, Date dataCurenta) throws ParseException {

        audit.write("prelungesteTermenImprumut");
        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);

        if (abonat == null){
            return -1;
        }
        ArrayList<Imprumut> imprumuturi = serviciiImprumut.getImprumuturiAbonat(abonat.getIdAbonat());

        if(imprumuturi != null) {


            for (Imprumut imprumut : imprumuturi) {
                // Daca abonatul are carti pe care nu le-a restituit la timpl, nu i se acorda prelungirea
                if (imprumut.getDataRestituire().compareTo(dataCurenta) <= 0) {
                    abonat.setNrAbateri(abonat.getNrAbateri() + 1);
                    AbonatiBD.updateAbonati(abonat.getIdAbonat(), abonat.getNrAbateri());
                    System.out.println("\nNu puteti prelungi perioada de imprumut deoarece nu ati respectat data restituirii cartilor imprumutate\n");
                    return -3;
                }
            }

            for (Imprumut imprumut : imprumuturi) {
                if (imprumut.getIdCarte() == idCarte) {
                    imprumut.prelungestePerioada(dataCurenta, serviciiCarti.cautaCarteDupaIdCarte(idCarte).zileImprumut());
                    ImprumutBD.updateImprumuturi(abonat.getIdAbonat(), idCarte, imprumut.getDataRestituire());
                    return idCarte;
                }
            }
        }
        else {

            System.out.println("\nAbonatul nu are aceasta carte imprumutata\n");

        }
        return -2;
    }

    //Am presupus ca un abonat poate sa imprumute maxim o carte intr-o zi
    public int imprumutaCarte(String cnpAbonat, String titluCarte, String autorCarte, Date data) throws ParseException {

        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);

        if (abonat != null) {

            // verific daca ceea ce vreau sa imprumut este disponibil
            Carte carte = serviciiCarti.cautaCarte(titluCarte, autorCarte);
            if (carte != null) {

                System.out.println("id carte" + carte.getIdCarte());
                Imprumut imprumut = new Imprumut(abonat.getIdAbonat(), data, null, carte.getIdCarte());
                imprumut.calculeazaDataRestituire(carte.zileImprumut());

                carte.setImprumutata(true);
                CartiBD.updateCarte(carte.getIdCarte(), true);

                serviciiImprumut.adaugImprumutLaData(new SimpleDateFormat("yyyy-MM-dd").format(data), imprumut);
                serviciiImprumut.adaugImprumutLaAbonat(abonat.getIdAbonat(), imprumut);

                ImprumutBD.insertImprumuturi(imprumut);

            }
            else{
                return 1;
            }

        } else {

            System.out.println("Abonatul cautat nu exista in baza noastra de date.\n Adaugati mai intai abonatul, dupa aceea efectuati imprumutul");
            return -1;

        }
        audit.write("imprumutaCarte ");

        return 0;

    }


    public int restituieCarte(String cnpAbonat, int idCarte, Date dataCurenta){

        Abonat abonat = serviciiAbonati.cautaAbonat(cnpAbonat);
        Carte carte = serviciiCarti.cautaCarteDupaIdCarte(idCarte);

        if(abonat == null){
            System.out.println("Abonatul nu exista\n");
            return 1;
        }

        ArrayList<Imprumut> imprumuturi = serviciiImprumut.getImprumuturiAbonat(abonat.getIdAbonat());


        Imprumut imprumut_curent = null;
        boolean aImprumutat = false;

        if(imprumuturi != null) {
            for (Imprumut imprumut : imprumuturi) {

                if (imprumut.getIdCarte() == idCarte) {

                    imprumut_curent = imprumut;

                    serviciiImprumut.stergeImprumut(abonat.getIdAbonat(), imprumut);
                    serviciiCarti.getCartiImprumutate().remove(carte);
                    carte.setImprumutata(false);
                    CartiBD.updateCarte(carte.getIdCarte(), carte.isImprumutata());


                    Date dataImprumut = imprumut.getDataImprumut();
                    serviciiImprumut.stergeImprumutDinZiua(new SimpleDateFormat("yyyy-MM-dd").format(dataImprumut), imprumut);

                    ImprumutBD.deleteImprumuturi(abonat.getIdAbonat(), idCarte);

                    aImprumutat = true;
                    break;
                }
            }
        }

        if (aImprumutat) {

            // comparam data la care restituie cartea cu data la care trebuie restituita si adaugam/nu adaugam penalitati
            if (imprumut_curent.getDataRestituire().compareTo(dataCurenta) <= 0) {
                abonat.setNrAbateri(abonat.getNrAbateri() + 1);
                AbonatiBD.updateAbonati(abonat.getIdAbonat(), abonat.getNrAbateri());
            }
        } else {
            System.out.println("Abonatul " + abonat + " nu a imprumutat aceasta carte");
            return -1;
        }

        audit.write("restituieCarte ");

        return 0;
    }


    public void afiseazaImprumuturiDeLaData(String date){


        if (serviciiImprumut.getImprumutPeZile().containsKey(date)) {
            ArrayList<Imprumut> items = serviciiImprumut.getImprumutPeZile().get(date);

            if (items.size() != 0) {
                System.out.println("\nLa data de: " + date + " au existat urmatoarele imprumuturi: \n");
                for (Imprumut item : items) {
                    System.out.println(item);
                }
            }
            else {
                System.out.println("\nLa data de: " + date + " nu a existat nicun imprumut\n");

            }

        } else {
            System.out.println("\nLa data de: " + date+ " nu a existat nicun imprumut \n");

        }

        audit.write("imprumutaCarte ");

    }

    public void afiseazaAbonatii(){
        serviciiAbonati.afiseazaAbonatii();
        audit.write("afiseazaAbonatii ");

    }

    public boolean adaugaAbonat(Abonat abonat){

        audit.write("adaugaAbonat ");
        if(serviciiAbonati.adaugaAbonat(abonat))
        {
            AbonatiBD.insertAbonati(abonat);
            return true;
        }
        return false;
    }

    public void cautaAbonat(String cnp){
        audit.write("cautaAbonat ");
        serviciiAbonati.cautaAbonat(cnp);

    }


    public void adaugaCarteinStoc(Carte carte){
        audit.write("adaugaCarteinStoc ");
        serviciiCarti.adaugaCarteinStoc(carte);
        CartiBD.insertCarti(carte);
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
        if(serviciiCarti.scoateCartedinStoc(idCarte))
            CartiBD.deleteCarte(idCarte);

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

