package servicii;

import carte.Atlas;
import carte.Dictionar;
import carte.Manual;
import carte.Roman;
import persoana.Adult;
import persoana.Copil;
import persoana.Student;

import java.io.*;

/**
 *  Clasa ServiciiInput este un Singleton
 *  care cu ajutorul readAbonati() si readCarti()
 *  incarca datele din fisierele .csv in program
 */

public class ServiciiInput {

    private static ServiciiInput instance = null;
    private String base = "src/fisiere/";

    private ServiciiInput() {
    }

    public static ServiciiInput getInstance() {
        if (instance == null)
            instance = new ServiciiInput();

        return instance;
    }

    /**
     *
     * returneaza un obiect de tipul ServiciiAbonati,
     * continand o colectie de abonati cititi din fisierul
     * abonati.csv
     *
     */


    public ServiciiAbonati readAbonati(){
        String line;
        String data[];

        ServiciiAbonati serviciiAbonati = new ServiciiAbonati();
        try {

            BufferedReader reader = new BufferedReader(new FileReader(base + "abonati.csv"));

            while ((line = reader.readLine()) != null) {
                data = line.split(",");
                String abonat = data[0];

                switch (abonat) {
                    case "adult": {
                        boolean reducere;
                        if (data[5].equals("fals"))
                            reducere = false;
                        else
                            reducere = true;

                        serviciiAbonati.adaugaAbonat(new Adult(data[1], data[2], data[3], data[4], reducere));
                        break;
                    }
                    case "copil": {
                        serviciiAbonati.adaugaAbonat(new Copil(data[1], data[2], data[3], data[4], Integer.parseInt(data[5])));
                        break;
                    }

                    case "student": {
                        boolean legitimatie;
                        if (data[5] == "fals")
                            legitimatie = false;
                        else
                            legitimatie = true;
                        serviciiAbonati.adaugaAbonat(new Student(data[1], data[2], data[3], data[4], legitimatie));
                        break;


                    }
                    default:
                        break;
                }
            }

            reader.close();
        }catch (IOException e){
            System.out.println("Eroare la citirea din fisier a angajatilor\n");
            e.printStackTrace();
        }

        return serviciiAbonati;


    }

    /**
     *
     * returneaza un obiect de tipul ServiciiCarti,
     *  continand o colectie de carti citite din fisierele
     *  atlas.csv, dictionar.csv, manual.csv, roman.csv
     *
     */

    public ServiciiCarti readCarti() throws IOException {

        String inputFiles[] = new String[]{"atlas.csv", "dictionar.csv", "manual.csv", "roman.csv"};

        ServiciiCarti serviciiCarti = new ServiciiCarti();


        for (String file : inputFiles)
            serviciiCarti = readTipCarte(file, serviciiCarti);

        return serviciiCarti;

    }


    public ServiciiCarti readTipCarte(String path, ServiciiCarti serviciiCarti){

        String row;
        String data[];

        try {

            BufferedReader reader = new BufferedReader(new FileReader(base + path));

            switch (path) {
                case "atlas.csv": {
                    while ((row = reader.readLine()) != null) {
                        data = row.split(",");
                        serviciiCarti.adaugaCarteinStoc(new Atlas(data[0], data[1], data[2]));
                    }

                    break;
                }
                case "dictionar.csv": {

                    while ((row = reader.readLine()) != null) {
                        data = row.split(",");
                        serviciiCarti.adaugaCarteinStoc(new Dictionar(data[0], data[1], data[2], data[3]));
                    }
                    break;
                }

                case "manual.csv": {
                    while ((row = reader.readLine()) != null) {
                        data = row.split(",");
                        serviciiCarti.adaugaCarteinStoc(new Manual(data[0], data[1], data[2]));
                    }
                    break;
                }

                case "roman.csv": {
                    while ((row = reader.readLine()) != null) {
                        data = row.split(",");
                        serviciiCarti.adaugaCarteinStoc(new Roman(data[0], data[1], data[2]));
                    }
                    break;
                }

                default:
                    break;
            }

            reader.close();
        }catch (IOException e){
            System.out.println("Eroare la citirea cartilor din fisier\n");
            e.printStackTrace();
        }
        return serviciiCarti;
    }


}

