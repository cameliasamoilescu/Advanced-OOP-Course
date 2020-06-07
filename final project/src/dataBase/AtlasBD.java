package dataBase;

import carte.Atlas;
import carte.Carte;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;

public class AtlasBD {

    private static Connection c = null;

    public AtlasBD() {
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

    public static void createAtlas() {

        String createTable ="CREATE TABLE IF NOT EXISTS atlas ("+
                "id_carte NUMBER(8) NOT NULL, " +
                "titlu VARCHAR(32) NOT NULL, " +
                "autor VARCHAR(32) NOT NULL, " +
                "imprumutata NUMBER(1), "+
                "editura VARCHAR(32)" +
                ")"
                ;

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Atlas");
        }


    }
    public static void insertAtlas(Atlas atlas){
        String insertImprumut = "INSERT INTO atlas " +
                "(id_carte, titlu, autor, imprumutata, editura) " +
                "VALUES " +
                "(' " +
                atlas.getIdCarte() + "', '" + atlas.getTitlu() + "', '" + atlas.getAutor() + "', '" + atlas.isImprumutata() + "', '" + atlas.getEditura()
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


    public static Pair<ArrayList<Carte>, ArrayList<Carte>> getAtlas(){
        String getImprumuturi = "SELECT * from atlas";
        int idCarte;
        String titlu;
        String autor;
        boolean imprumutata;
        String editura;


        try (Statement stmt = c.createStatement()) {

            ArrayList<Carte> carti = new ArrayList<Carte>();

            ArrayList<Carte> cartiImprumutate  = new ArrayList<Carte>();

            ResultSet result = stmt.executeQuery(getImprumuturi);
            while (result.next()) {

                idCarte = result.getInt("id_carte");
                titlu = result.getString("titlu");
                autor = result.getString("autor");
                imprumutata = result.getBoolean("imprumutata");
                editura = result.getString("editura");

                Atlas atlas = (new Atlas(idCarte, titlu, autor, imprumutata, editura));
                carti.add(atlas);
                if(imprumutata){
                    cartiImprumutate.add(atlas);
                }

            }
            return new Pair<ArrayList<Carte>, ArrayList<Carte>>(carti, cartiImprumutate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateAtlas(int idCarte, boolean imprumutata){

        String sql = "UPDATE atlas SET imprumutata = ? "
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

    public static void deleteAtlas(int idCarte){

        String sql = "DELETE FROM atlas WHERE id_carte = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idCarte);
            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean existaAtlas(int idCarte){

        String sql = "SELECT * from atlas where id_carte = " + idCarte;
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
