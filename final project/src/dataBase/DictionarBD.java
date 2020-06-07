package dataBase;

import carte.Carte;
import carte.Dictionar;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class DictionarBD {
    private static Connection c = null;


    public DictionarBD() {
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
    public static void createDictionar() {

        String createTable ="CREATE TABLE IF NOT EXISTS dictionar ("+
                "id_carte NUMBER(8) NOT NULL, " +
                "titlu VARCHAR(32) NOT NULL, " +
                "autor VARCHAR(32) NOT NULL, " +
                "imprumutata NUMBER(1),"+
                "tip VARCHAR(32)," +
                "editura VARCHAR(32)" +
                ")"
                ;

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Dictionar");
        }


    }


    public static void insertDictionar(Dictionar dictionar){
        String insertImprumut = "INSERT INTO dictionar " +
                "(id_carte, titlu, autor, imprumutata, tip, editura) " +
                "VALUES " +
                "('" +
                dictionar.getIdCarte() + "', '" + dictionar.getTitlu() + "', '" + dictionar.getAutor() + "', '" + dictionar.isImprumutata() + "', '" + dictionar.getTip() + "', '" + dictionar.getEditura()
                + "')";

        try (Statement stmt = c.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertImprumut);
            if (insertedRows != 1) {
                throw new SQLException("Eroare la inserarea in tabelul dictionar");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Pair<ArrayList<Carte>, ArrayList<Carte>> getDictionar(){
        String getImprumuturi = "SELECT * from dictionar";
        int idCarte;
        String titlu;
        String autor;
        boolean imprumutata;
        String tip;
        String editura;


        try (Statement stmt = c.createStatement()) {

            ArrayList<Carte> carti = new ArrayList<Carte>();
            ArrayList<Carte> cartiImprumutate = new ArrayList<Carte>();


            ResultSet result = stmt.executeQuery(getImprumuturi);



            while (result.next()) {

                idCarte = result.getInt("id_carte");
                titlu = result.getString("titlu");
                autor = result.getString("autor");
                imprumutata = result.getBoolean("imprumutata");
                tip = result.getString("tip");
                editura = result.getString("editura");


                Dictionar dictionar = new Dictionar(idCarte, titlu, autor, imprumutata,tip, editura);
                carti.add(dictionar);
                if(imprumutata)
                    cartiImprumutate.add(dictionar);

            }
            return new Pair<ArrayList<Carte>, ArrayList<Carte>>(carti,cartiImprumutate) ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateDictionar(int idCarte, boolean imprumutata){

        String sql = "UPDATE dictionar SET imprumutata = ? "
                + "WHERE id_carte = ?";


        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setBoolean(1, imprumutata);
            pstmt.setInt (2, idCarte);


            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDictionar(int idCarte){

        String sql = "DELETE FROM dictionar WHERE id_carte = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idCarte);
            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean existaDictionar(int idCarte){

        String sql = "SELECT * from dictionar where id_carte = " + idCarte;
        try (Statement stmt = c.createStatement()) {

            ResultSet result = stmt.executeQuery(sql);
            int countRow = 0;
            while (result.next()){
                ++countRow;
            }
            if(countRow > 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
