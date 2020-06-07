package servicii;

import carte.Carte;

import java.util.ArrayList;

/**
 * Clasa ServiciiCarti tine evidenta cartilor bibliotecii si al cartilor imprumutate.
 *   Se pot efectua servicii ca:
 *            adaugaCarteinStoc()
 *            afiseazaCartilePeStoc()
 *            afiseazaCartileImprumutate()
 *            scoateCartedinStoc()
 *            cautaCarte()
 *            cautaCarteDupaIdCarte()
 */

public class ServiciiCarti {

    protected ArrayList<Carte> carti;
    private ArrayList<Carte> cartiImprumutate;


    public ServiciiCarti() {
        this.carti = new ArrayList<Carte>();
        this.cartiImprumutate = new ArrayList<Carte>();
    }

    public ServiciiCarti(ArrayList<Carte> carti) {
        this.carti = carti;
        this.cartiImprumutate = new ArrayList<Carte>();
    }


    public ServiciiCarti(ArrayList<Carte> carti, ArrayList<Carte> cartiImprumutate) {
        this.carti = carti;
        this.cartiImprumutate = cartiImprumutate;
    }

    public ArrayList<Carte> getCartiImprumutate() {
        return cartiImprumutate;
    }

    public void setCartiImprumutate(ArrayList<Carte> cartiImprumutate) {
        this.cartiImprumutate = cartiImprumutate;
    }

    public ArrayList<Carte> getCarti() {
        return carti;
    }

    public void setCarti(ArrayList<Carte> carti) {
        this.carti = carti;
    }

    //daca nu exista in stocul bibliotecii, adaug carte
    public void adaugaCarteinStoc(Carte carte){
        if(this.carti.contains(carte))
            System.out.println("\nCartea " + carte + " este deja in stoc\n");
        carti.add(carte);


    }


    public void afiseazaCartilePeStoc(){

        System.out.println("\nBiblioteca are pe stoc urmatoarele carti: \n");
        for (Carte carte: this.carti)
            System.out.println(carte.toString());
    }


    public  void afiseazaCartileImprumutate(){

        if (cartiImprumutate.size() == 0)
            System.out.println("Biblioteca nu a imprumutat nicio carte");
       else {
            System.out.println("\nBiblioteca a imprumutat urmatoarele carti: \n");
            for (Carte carte : cartiImprumutate)
                System.out.println(carte.toString());
        }
    }


    //scot carte daca exista in stocul bibliotecii
    public boolean scoateCartedinStoc(int idCarte) {

        boolean exista = false;
        Carte carteScos = null;
        for (Carte carte : carti) {
            if (carte.getIdCarte() == idCarte) {
                exista = true;
                carteScos = carte;
            }
        }

        if(!exista){
            System.out.println("\nNu exista nicio carte cu id ul dat in stocul bibliotecii\n");
            return false;
        }
        else {
            if (carteScos.isImprumutata()) {
                System.out.println("\nCarte este imprumutata, nu poate fi scoasa din stoc\n");
                return false;
            }
            else{
                carti.remove(carteScos);
                return true;
            }

        }
    }



    //verifica daca o carte este in stocul bibliotecii si daca este disponibila pentru a fi imprumutata

    public Carte cautaCarte(String titlu, String autor){
        for (Carte carte : this.carti) {
            if (carte.getTitlu().equals(titlu) && carte.getAutor().equals(autor)){
                if (!carte.isImprumutata()) {
                    System.out.println(carte.toString());
                    return carte;
                }
                else
                    System.out.println(" Cartea " + carte.toString() + " nu este disponibila\n");
                    return null;
            }
        }

        System.out.println(" Cartea " + titlu + " scrisa de " + autor + " nu este in stocul bibliotecii\n");
        return null;
    }

    public Carte cautaCarteDupaIdCarte(int idCarte){

        for (Carte carte : this.carti) {
            if (carte.getIdCarte() == idCarte) {
                System.out.println(carte.toString());

                return carte;
            }

            }
        System.out.println("\nNu a fost gasita cartea\n");
        return null;

    }




}
