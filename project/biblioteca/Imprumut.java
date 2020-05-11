package biblioteca;

import carte.Carte;
import persoana.Abonat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
    private Date dataImprumut;
    private Date dataRestituire;
    protected Carte carte;


    public Imprumut(Abonat abonat, Date dataImprumut, Date dataRestituire, Carte carte) {
        this.abonat = abonat;
        this.dataImprumut = dataImprumut;
        this.dataRestituire = dataRestituire;
        this.carte = carte;


    }

    public Date getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(Date dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public Date getDataRestituire() {
        return dataRestituire;
    }

    public void setDataRestituire(Date dataRestituire) {
        this.dataRestituire = dataRestituire;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }



    public void prelungestePerioada(Date dataCurenta) throws ParseException {
        this.dataImprumut = dataCurenta;
        this.calculeazaDataRestituire();
    }

    public void calculeazaDataRestituire() throws ParseException {


        // in functie de fiecare carte calculam data restituirii
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataImprumut);
        c.add(Calendar.DATE, carte.zileImprumut());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataRestituire = c.getTime();

        this.dataRestituire = dataRestituire;

    }

    String afisareData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(data);
        return date;
    }

    @Override
    public String toString() {
        return "\nImprumut { " +
                "abonat = " + abonat +
                "\n\t\t\tdata_imprumut = " + this.afisareData(dataImprumut) + '\'' +
                "\n\t\t\tdata_restituire = " + this.afisareData(dataRestituire) + '\'' +
                "\n\t\t\tcarte = " + carte +
                '}';
    }
}
