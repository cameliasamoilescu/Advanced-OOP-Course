package biblioteca;

import carte.Carte;
import persoana.Abonat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Clasa Imprumut contine toate detaliile legate de un imprumut:
 *          Abonatul, data imprumutului, data restituirii, cartea imprumutata
 *
 *
 * Si metode ca prelungire_perioada() ---> prelungirea perioadei de imprumut
 *           si calculeaza_data_restituire
 *
 */

public class Imprumut {

    protected Abonat abonat;
    private String data_imprumut;
    private String data_restituire;
    Carte carte;


    public Imprumut(Abonat abonat, String data_imprumut, String data_restituire, Carte carte) {
        this.abonat = abonat;
        this.data_imprumut = data_imprumut;
        this.data_restituire = data_restituire;
        this.carte = carte;


    }

    public String getData_imprumut() {
        return data_imprumut;
    }

    public void setData_imprumut(String data_imprumut) {
        this.data_imprumut = data_imprumut;
    }

    public String getData_restituire() {
        return data_restituire;
    }

    public void setData_restituire(String data_restituire) {
        this.data_restituire = data_restituire;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }



    public void prelungeste_perioada(String data_curenta) throws ParseException {
        this.data_imprumut = data_curenta;
        this.calculeaza_data_restituire();
    }

    public void calculeaza_data_restituire() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date dt = formatter.parse(this.data_imprumut);


        // in functie de fiecare carte calculam data restituirii
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, carte.zileImprumut());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data_restituire = dateFormat.format(c.getTime());

        this.data_restituire = data_restituire;

    }

    @Override
    public String toString() {
        return "\nImprumut { " +
                "abonat = " + abonat +
                "\n\t\t\tdata_imprumut = " + data_imprumut + '\'' +
                "\n\t\t\tdata_restituire = " + data_restituire + '\'' +
                "\n\t\t\tcarte = " + carte +
                '}';
    }
}
