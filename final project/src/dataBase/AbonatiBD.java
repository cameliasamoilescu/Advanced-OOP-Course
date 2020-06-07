package dataBase;

import persoana.Abonat;
import persoana.Adult;
import persoana.Copil;
import persoana.Student;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AbonatiBD {
    private static Connection c = null;



    public static void connect(){

        try {

            c = DriverManager.getConnection("jdbc:sqlite:src/bazaDeDate/bazaDeDate.db");


        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }


    public AbonatiBD() {
        connect();
        createAbonati();

    }

    public static void createAbonati(){
        String createTable =
                "CREATE TABLE IF NOT EXISTS abonati (" +
                        "tip VARCHAR(32) NOT NULL," +
                        "id NUMBER(6) NOT NULL," +
                        "nume VARCHAR(32) NOT NULL, " +
                        "prenume VARCHAR(32) NOT NULL, " +
                        "data_inregistrare DATE, " +
                        "cnp VARCHAR(32), " +
                        "nr_telefon VARCHAR(32), " +
                        "nr_abateri NUMBER(8) DEFAULT 0, " +
                        "pret_legitimatie NUMBER(8,2), " +
                        "criteriu_reducere NUMBER(1), "+
                        "varsta NUMBER(8), "+
                        "carnet_vizat NUMBER(1)" +
                        ")";

        try (Statement stmt = c.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Abonati");
        }

    }


    public static void insertAbonati(Abonat abonat){
        String insertAbonat;

        if (abonat instanceof Adult) {
            // do something

            insertAbonat ="INSERT INTO abonati " +
                    "(tip, id, nume, prenume, data_inregistrare, cnp, nr_telefon, nr_abateri, pret_legitimatie, criteriu_reducere) " +
                    "VALUES " +
                    "('adult', '" + abonat.getIdAbonat() +"', '" +  abonat.getNume() +"', '" + abonat.getPrenume() + "','" + new java.sql.Date(abonat.getDataInregistrare().getTime()) +
                    "', '" + abonat.getCnp() + "', '" + abonat.getNumarTelefon() + "', '" + abonat.getNrAbateri() + "', '" + abonat.getPretLegitimatie() +
                    "', '" + ((Adult)abonat).isCriteriuReducere() +
                    "')";
        }
        else if (abonat instanceof Student){
            insertAbonat ="INSERT INTO abonati " +
                    "(tip, id, nume, prenume, data_inregistrare, cnp, nr_telefon, nr_abateri, pret_legitimatie, carnet_vizat) " +
                    "VALUES " +
                    "('student', '" + abonat.getIdAbonat() +"', '" +  abonat.getNume() +"', '" + abonat.getPrenume() + "','" + new java.sql.Date(abonat.getDataInregistrare().getTime()) +
                    "', '" + abonat.getCnp() + "', '" + abonat.getNumarTelefon() + "', '" + abonat.getNrAbateri() + "', '" + abonat.getPretLegitimatie() +
                    "', '" + ((Student)abonat).isCarnetVizat() +
                    "')";
        }
        else{
            insertAbonat = "INSERT INTO abonati " +
                    "(tip, id, nume, prenume, data_inregistrare, cnp, nr_telefon, nr_abateri, pret_legitimatie, varsta) " +
                    "VALUES " +
                    "('copil', '" + abonat.getIdAbonat() +"', '" +  abonat.getNume() +"', '" + abonat.getPrenume() + "','" + new java.sql.Date(abonat.getDataInregistrare().getTime()) +
                    "', '" + abonat.getCnp() + "', '" + abonat.getNumarTelefon() + "', '" + abonat.getNrAbateri() + "', '" + abonat.getPretLegitimatie() +
                    "', '" + ((Copil)abonat).getVarsta() +
                    "')";
        }

        try (Statement stmt = c.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertAbonat);
            if (insertedRows != 1) {
                throw new SQLException("Eroare la inserarea in tabelul abonati");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  ArrayList<Abonat> getAbonati(){


        String getAbonati = "SELECT * from abonati";
        try (Statement stmt = c.createStatement()) {
            ArrayList<Abonat> abonati = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getAbonati);
            while (result.next()) {

                int id = result.getInt("id");
                String tip = result.getString("tip");
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");


                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                java.util.Date dataInregistrare = formatter.parse(result.getString("data_inregistrare"));

                String cnp = result.getString("cnp");
                String nrTelefon = result.getString("nr_telefon");
                int nrAbateri = result.getInt("nr_abateri");
                double pretLegitimatie = result.getDouble("pret_legitimatie");

                switch (tip) {
                    case "adult": {
                        abonati.add(new Adult(id,nume, prenume, dataInregistrare, cnp, nrTelefon, nrAbateri, pretLegitimatie, result.getBoolean("criteriu_reducere") ));
                        break;
                    }
                    case "copil": {
                        abonati.add(new Copil(id,nume, prenume, dataInregistrare, cnp, nrTelefon, nrAbateri, pretLegitimatie, result.getInt("varsta")));
                        break;
                    }

                    case "student": {
                        abonati.add(new Student(id,nume, prenume, dataInregistrare, cnp, nrTelefon, nrAbateri, pretLegitimatie, result.getBoolean("carnet_vizat")));
                        break;


                    }
                    default:
                        break;
                }
            }

            return abonati;
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }



    public static void updateAbonati(int idAbonat, int nrAbateri){

        String sql = "UPDATE abonati SET nr_abateri = ? "
                + "WHERE id = ?";


        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, nrAbateri);
            pstmt.setInt (2, idAbonat);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void deleteAbonati(int idAbonat){

        String sql = "DELETE FROM abonati WHERE id = ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            pstmt.setInt(1, idAbonat);

            // delete
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    public static void main(String[] args) {
        connect();
    }



}
