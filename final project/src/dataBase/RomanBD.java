package dataBase;

import carte.Carte;
import carte.Roman;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class RomanBD {
    private static Connection c = null;

    public RomanBD() {
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



    public static void createRoman() {

        String createTable ="CREATE TABLE IF NOT EXISTS roman ("+
                "id_carte NUMBER(8) NOT NULL, " +
                "titlu VARCHAR(32) NOT NULL, " +
                "autor VARCHAR(32) NOT NULL, " +
                "imprumutata NUMBER(1),"+
                "gen VARCHAR(32)" +
                ")"
                ;

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("roman");
        }


    }


    public static void insertRoman(Roman roman){
        String insertImprumut = "INSERT INTO roman " +
                "(id_carte, titlu, autor, imprumutata, gen) " +
                "VALUES " +
                "('" +
                roman.getIdCarte() + "', '" + roman.getTitlu() + "', '" + roman.getAutor() + "', '" + roman.isImprumutata() + "', '" + roman.getGen()
                + "')";

        try (Statement stmt = c.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertImprumut);
            if (insertedRows != 1) {
                throw new SQLException("Eroare la inserarea in tabelul atlas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean existaRoman(int idCarte){

        String sql = "SELECT * from roman where id_carte = " + idCarte;
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

    public static Pair<ArrayList<Carte>, ArrayList<Carte>> getRoman(){
        String getImprumuturi = "SELECT * from roman";
        int idCarte;
        String titlu;
        String autor;
        boolean imprumutata;
        String gen;

        try (Statement stmt = c.createStatement()) {

            ArrayList<Carte> carti = new ArrayList<Carte>();
            ArrayList<Carte> cartiImprumutate= new ArrayList<Carte>();


            ResultSet result = stmt.executeQuery(getImprumuturi);


            while (result.next()) {

                idCarte = result.getInt("id_carte");
                titlu = result.getString("titlu");
                autor = result.getString("autor");
                imprumutata = result.getBoolean("imprumutata");
                gen= result.getString("gen");

                Roman roman = new Roman(idCarte, titlu, autor, imprumutata, gen);
                carti.add(roman);
                if(imprumutata)
                    cartiImprumutate.add(roman);

            }
            return new Pair<ArrayList<Carte>, ArrayList<Carte>>(carti, cartiImprumutate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateRoman(int idCarte, boolean imprumutata){

        String sql = "UPDATE roman SET imprumutata = ? "
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

    public static void deleteRoman(int idCarte){

        String sql = "DELETE FROM roman WHERE id_carte = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idCarte);
            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



}
