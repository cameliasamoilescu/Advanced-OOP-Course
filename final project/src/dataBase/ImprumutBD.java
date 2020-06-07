package dataBase;

import biblioteca.Imprumut;
import biblioteca.SortareImprumut;
import javafx.util.Pair;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ImprumutBD {
    private static Connection c = null;


    public ImprumutBD() {
        connect();
        createImprumuturi();
    }

    public static void connect(){
        try {
            c = DriverManager.getConnection("jdbc:sqlite:src/bazaDeDate/bazaDeDate.db");


        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Baza de date deschisa cu succes");
    }
    public static void createImprumuturi() {

        String createTable =
                "CREATE TABLE IF NOT EXISTS imprumuturi ("+
                        "id_abonat NUMBER(8) NOT NULL, " +
                        "data_imprumut DATE, " +
                        "data_restituire DATE, " +
                        "id_carte NUMBER(8) NOT NULL"+
                        ")";

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("imprumut");
        }


    }

    public static void insertImprumuturi(Imprumut imprumut){
        String insertImprumut = "INSERT INTO imprumuturi " +
                "(id_abonat, data_imprumut, data_restituire, id_carte) " +
                "VALUES " +
                "('" +
                imprumut.getIdAbonat() + "', '" + new java.sql.Date(imprumut.getDataImprumut().getTime()) + "', '" + new java.sql.Date(imprumut.getDataRestituire().getTime())+ "', '" + imprumut.getIdCarte()
                + "')";

        try (Statement stmt = c.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertImprumut);
            if (insertedRows != 1) {
                throw new SQLException("Eroare la inserarea in tabelul abonati");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Pair<HashMap<Integer, ArrayList<Imprumut>>,  HashMap<String, ArrayList<Imprumut>>> getImprumuturi(){
        String getImprumuturi = "SELECT * from imprumuturi";
        try (Statement stmt = c.createStatement()) {

            HashMap<Integer, ArrayList<Imprumut>> imprumuturi = new HashMap<Integer, ArrayList<Imprumut>>();
            HashMap<String, ArrayList<Imprumut>> imprumuturiPeZile = new HashMap<String, ArrayList<Imprumut>>();


            ResultSet result = stmt.executeQuery(getImprumuturi);


            while (result.next()) {

                int idAbonat = result.getInt("id_abonat");




                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dataImprumut = formatter.parse(result.getString("data_imprumut"));
                String dataImpr = new SimpleDateFormat("yyyy-MM-dd").format(dataImprumut);


                java.util.Date dataRestituire = formatter.parse(result.getString("data_restituire"));
                int idCarte = result.getInt("id_carte");

                Imprumut imprumut = new Imprumut(idAbonat, dataImprumut, dataRestituire, idCarte);

                if (imprumuturi.containsKey(idAbonat)) {
                    ArrayList<Imprumut> impr = imprumuturi.get(idAbonat);
                    impr.add(imprumut);
                }
                else {
                    ArrayList<Imprumut> impr = new ArrayList<Imprumut>();
                    impr.add(imprumut);
                    Collections.sort(impr, new SortareImprumut());
                    imprumuturi.put(idAbonat, impr);
                }



                if (imprumuturiPeZile.containsKey(dataImpr)) {
                    ArrayList<Imprumut> impr = imprumuturiPeZile.get(dataImpr);
                    impr.add(imprumut);
                }
                else {
                    ArrayList<Imprumut> impr = new ArrayList<Imprumut>();
                    impr.add(imprumut);
                    Collections.sort(impr, new SortareImprumut());
                    imprumuturiPeZile.put(dataImpr, impr);
                }

            }


            return new Pair< HashMap<Integer, ArrayList<Imprumut>>,  HashMap<String, ArrayList<Imprumut>>>(imprumuturi, imprumuturiPeZile);
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }



    public static void updateImprumuturi(int idAbonat, int idCarte, java.util.Date dataRestituire){

        String sql = "UPDATE imprumuturi SET data_restituire = ? "
                + "WHERE id_abonat = ? and id_carte = ?";


        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(dataRestituire.getTime()) );
            pstmt.setInt (2, idAbonat);
            pstmt.setInt (3, idCarte);


            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteImprumuturi(int idAbonat, int idCarte){

        String sql = "DELETE FROM imprumuturi WHERE id_abonat = ? and id_carte = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idAbonat);
            pstmt.setInt(2, idCarte);
            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
