package dataBase;

import carte.*;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class CartiBD {
    private static Connection c = null;
    private static  DictionarBD dbd;
    private static AtlasBD abd;
    private static ManualBD mbd;
    private static RomanBD rbd;

    public CartiBD() {
        DictionarBD dbd = new DictionarBD();
        AtlasBD abd = new AtlasBD();
        ManualBD mbd = new ManualBD();
        RomanBD rbd = new RomanBD();
        connect();
    }

    public static void connect(){

        try {
            c = DriverManager.getConnection("jdbc:sqlite:src/bazaDeDate/bazaDeDate.db");


        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void insertCarti(Carte carte){
        if(carte instanceof Atlas){
            AtlasBD.insertAtlas((Atlas)carte);
        }
        else if(carte instanceof Dictionar){
            DictionarBD.insertDictionar((Dictionar)carte);
        }else if(carte instanceof Manual){
            ManualBD.insertManual((Manual)carte);
        }else RomanBD.insertRoman((Roman)carte);
    }


    public static Pair<ArrayList<Carte>, ArrayList<Carte>> getCarti(){
        ArrayList<Carte> carti = new ArrayList<Carte>();
        ArrayList<Carte> cartiImprumutate = new ArrayList<Carte>();


        Pair<ArrayList<Carte>, ArrayList<Carte>> pair = AtlasBD.getAtlas();

        carti.addAll(pair.getKey());
        cartiImprumutate.addAll(pair.getValue());

        pair = DictionarBD.getDictionar();
        carti.addAll(pair.getKey());
        cartiImprumutate.addAll(pair.getValue());


        pair = ManualBD.getManual();
        carti.addAll(pair.getKey());
        cartiImprumutate.addAll(pair.getValue());

        pair = RomanBD.getRoman();
        carti.addAll(pair.getKey());
        cartiImprumutate.addAll(pair.getValue());

        return new Pair<ArrayList<Carte>, ArrayList<Carte>>(carti, cartiImprumutate);

    }


    public static void deleteCarte(int idCarte){

        if(AtlasBD.existaAtlas(idCarte)){
            AtlasBD.deleteAtlas(idCarte);
        }
        else if (DictionarBD.existaDictionar(idCarte)){
            DictionarBD.deleteDictionar(idCarte);
        }
        else
        if(ManualBD.existaManual(idCarte)){
            ManualBD.deleteManual(idCarte);
        }
        else RomanBD.deleteRoman(idCarte);

    }
    public static void updateCarte(int idCarte, boolean imprumutata){
        if(AtlasBD.existaAtlas(idCarte)){
            AtlasBD.updateAtlas(idCarte,imprumutata);
        }
        else if (DictionarBD.existaDictionar(idCarte)){
            DictionarBD.updateDictionar(idCarte, imprumutata);
        }
        else
        if(ManualBD.existaManual(idCarte)){
            ManualBD.updateManual(idCarte, imprumutata);
        }
        else RomanBD.updateRoman(idCarte,imprumutata);
    }






}
