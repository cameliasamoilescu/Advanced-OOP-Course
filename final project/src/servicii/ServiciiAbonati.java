package servicii;

import biblioteca.SortareAbonati;
import persoana.Abonat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * Clasa ServiciiAbonat contine un Array de abonati
 * asupra caruia se efectueaza servicii ca:
 *          afiseazaAbonatii()
 *          adaugaAbonat()
 *          cautaAbonat()
 *          scoateAbonat()
 *
 */


public class ServiciiAbonati {
    private ArrayList<Abonat> abonati;

    public ServiciiAbonati() {
        this.abonati = new ArrayList<>();

    }

    public ServiciiAbonati(ArrayList<Abonat> abonati) {
        this.abonati = abonati;

    }


    public ArrayList<Abonat> getAbonati() {
        return abonati;
    }

    public void setAbonati(ArrayList<Abonat> abonati) {
        this.abonati = abonati;
    }


    public  void afiseazaAbonatii(){

        System.out.println("\nBiblioteca are urmatorii abonati: \n");
        for (Abonat abonat: abonati)
            System.out.println(abonat.toString());
    }


    // adauga abonat in baza de date a bibliotecii
    public boolean adaugaAbonat(Abonat abonat){

        boolean ab = abonati.stream().anyMatch(t -> t.getCnp().equals(abonat.getCnp()));
        if(!ab){

            abonat.setDataInregistrare(new Date());
            this.abonati.add(abonat);
            abonat.calculezPretLegitimatie();
            Collections.sort(abonati, new SortareAbonati());

            return true;
        }
        else {

            System.out.println("\nAbonat existent\n");
            return false;
        }
    }

     public Abonat cautaAbonat(String cnp){

        for (Abonat abonat: abonati)
            if(abonat.getCnp().equals(cnp))
            {
                System.out.println(abonat.toString());

                return abonat;
            }

         System.out.println("Abonatul cautat nu exista");
         return null;

     }


    //scoate abonatul din baza de date a bibliotecii daca exista
    public void scoateAbonat(Abonat abonat){

        if(!abonati.contains(abonat))
            System.out.println("\nNu exista acest abonat: \n");
        else
            abonati.remove(abonat);
    }




}
