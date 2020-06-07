package biblioteca;
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

public class Imprumut{

    protected int idAbonat;
    private Date dataImprumut;
    private Date dataRestituire;
    protected int idCarte;


    public Imprumut(int idAbonat, Date dataImprumut, Date dataRestituire, int idCarte) {
        this.idAbonat = idAbonat;
        this.dataImprumut = dataImprumut;
        this.dataRestituire = dataRestituire;
        this.idCarte = idCarte;

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

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getIdAbonat() {
        return idAbonat;
    }

    public void setIdAbonat(int idAbonat) {
        this.idAbonat = idAbonat;
    }

    public void prelungestePerioada(Date dataCurenta, int zile) throws ParseException {
        this.calculeazaDataRestituire(zile);
    }

    public void calculeazaDataRestituire(int zile) throws ParseException {


        // in functie de fiecare carte calculam data restituirii
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataImprumut);
        c.add(Calendar.DATE, zile);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataRestituire = c.getTime();

        this.dataRestituire = dataRestituire;

    }

    String afisareData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(data);
        return date;
    }

    @Override
    public String toString() {
        return "\nImprumut { " +
                "abonat = " + idAbonat +
                "\n\t\t\tdata_imprumut = " + this.afisareData(dataImprumut) + '\'' +
                "\n\t\t\tdata_restituire = " + this.afisareData(dataRestituire) + '\'' +
                "\n\t\t\tcarte = " + idCarte +
                '}';
    }
}
