package servicii;

import biblioteca.Imprumut;
import biblioteca.SortareImprumut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ServiciiImprumut {
    private HashMap<Integer, ArrayList<Imprumut>> imprumuturi;
    private HashMap<String, ArrayList<Imprumut>> imprumutPeZile;

//    private HashMap<Date, ArrayList<Imprumut>> imprumutPeZile;


    public ServiciiImprumut(HashMap<Integer, ArrayList<Imprumut>> imprumuturi, HashMap<String, ArrayList<Imprumut>> imprumutPeZile) {

        this.imprumuturi = imprumuturi;
        this.imprumutPeZile = imprumutPeZile;
    }

    public ServiciiImprumut() {
        this.imprumuturi = new HashMap<Integer, ArrayList<Imprumut>>();
        this.imprumutPeZile = new HashMap<String, ArrayList<Imprumut>>();
    }


    public HashMap<Integer, ArrayList<Imprumut>> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(HashMap<Integer, ArrayList<Imprumut>> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }

    public HashMap<String, ArrayList<Imprumut>> getImprumutPeZile() {
        return imprumutPeZile;
    }

    public void setImprumutPeZile(HashMap<String, ArrayList<Imprumut>> imprumutPeZile) {
        this.imprumutPeZile = imprumutPeZile;
    }

    public ArrayList<Imprumut> getImprumuturiAbonat(int idAbonat) {

        return this.imprumuturi.getOrDefault(idAbonat, null);

    }


    public void adaugImprumutLaAbonat(int idAbonat, Imprumut imprumut) {


        if (this.imprumuturi.containsKey(idAbonat)) {
            ArrayList<Imprumut> imprumuturi = this.imprumuturi.get(idAbonat);
            imprumuturi.add(imprumut);
        }
        else {
            ArrayList<Imprumut> imprumuturi = new ArrayList<Imprumut>();
            imprumuturi.add(imprumut);
            imprumuturi.sort(new SortareImprumut());
            this.imprumuturi.put(idAbonat, imprumuturi);
            }

    }

    public void stergeImprumut(int idAbonat, Imprumut imprumut) {

        ArrayList<Imprumut> imprumuturi = this.imprumuturi.get(idAbonat);

        imprumuturi.remove(imprumut);
        this.imprumuturi.put(idAbonat, imprumuturi);


    }

    public void stergeImprumutDinZiua(String data, Imprumut imprumut){

        ArrayList<Imprumut> imprumutPeZile = this.imprumutPeZile.get(data);
        imprumutPeZile.remove(imprumut);
        this.imprumutPeZile.put(data, imprumutPeZile);


    }

    public void adaugImprumutLaData(String data, Imprumut imprumut){

        if (this.imprumutPeZile.containsKey(data)) {
            ArrayList<Imprumut> imprumutPeZile = this.imprumutPeZile.get(data);
            imprumutPeZile.add(imprumut);
            Collections.sort(imprumutPeZile, new SortareImprumut());

        }
        else {
            ArrayList<Imprumut> imprumutPeZile = new ArrayList<Imprumut>();
            imprumutPeZile.add(imprumut);
            this.imprumutPeZile.put(data, imprumutPeZile);

        }

    }
}
