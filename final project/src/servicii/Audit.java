package servicii;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  Clasa Audit este un Singleton
 *      care scrie in fisierul audit.csv
 *      ce serviciu al bibliotecii este apelat
 *
 */


public class Audit {
    private static Audit instance = null;
    private String base = "src/fisiere/";

    private Audit() {
    }

    public static Audit getInstance() {
        if (instance == null)
            instance = new Audit();

        return instance;
    }


    public void write(String numeMetoda){

        try {

            File file = new File(base + "audit.csv");
            FileWriter audit = new FileWriter(file, true);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm yyyy/MM/dd");
            Date data = new Date();
            String thread = Thread.currentThread().getName();

            audit.append(numeMetoda).append(",  ").append(dateFormat.format(data)).append(", ").append(thread).append("\n");
            audit.flush();
            audit.close();
        }catch (IOException e){
            System.out.println("Eroare la scrierea in audit.csv \n");
            e.printStackTrace();
        }


    }
}
