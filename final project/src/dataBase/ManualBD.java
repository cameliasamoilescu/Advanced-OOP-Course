package dataBase;

import carte.Carte;
import carte.Manual;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class ManualBD {
    private static Connection c = null;


    public ManualBD() {
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


    public static void createManual() {

        String createTable ="CREATE TABLE IF NOT EXISTS manual ("+
                "id_carte NUMBER(8) NOT NULL, " +
                "titlu VARCHAR(32) NOT NULL, " +
                "autor VARCHAR(32) NOT NULL, " +
                "imprumutata NUMBER(1),"+
                "materie VARCHAR(32)" +
                ")"
                ;

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("MAnual");
        }


    }


    public static void insertManual(Manual manual){
        String insertImprumut = "INSERT INTO manual " +
                "(id_carte, titlu, autor, imprumutata, materie) " +
                "VALUES " +
                "('" +
                manual.getIdCarte() + "', '" + manual.getTitlu() + "', '" + manual.getAutor() + "', '" + manual.isImprumutata() + "', '" + manual.getMaterie()
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
    public static boolean existaManual(int idCarte){

        String sql = "SELECT * from manual where id_carte = " + idCarte;
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

    public static Pair<ArrayList<Carte>, ArrayList<Carte>> getManual(){
        String getImprumuturi = "SELECT * from manual";
        int idCarte;
        String titlu;
        String autor;
        boolean imprumutata;
        String materie;

        try (Statement stmt = c.createStatement()) {

            ArrayList<Carte> carti = new ArrayList<Carte>();
            ArrayList<Carte> cartiImprumutate = new ArrayList<Carte>();


            ResultSet result = stmt.executeQuery(getImprumuturi);



            while (result.next()) {
                idCarte = result.getInt("id_carte");
                titlu = result.getString("titlu");
                autor = result.getString("autor");
                imprumutata = result.getBoolean("imprumutata");
                materie = result.getString("materie");


                Manual manual = new Manual(idCarte, titlu, autor, imprumutata,materie);
                carti.add(manual);

                if(imprumutata)
                    cartiImprumutate.add(manual);

            }
            return new Pair<ArrayList<Carte>, ArrayList<Carte>>(carti, cartiImprumutate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateManual(int idCarte, boolean imprumutata){

        String sql = "UPDATE manual SET imprumutata = ? "
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

    public static void deleteManual(int idCarte){

        String sql = "DELETE FROM dictionar WHERE id_carte = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idCarte);
            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



}
