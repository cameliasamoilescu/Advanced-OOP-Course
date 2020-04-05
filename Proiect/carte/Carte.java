package carte;

import java.util.Objects;

/**
 * Clasa Carte este clasa de baza pentru clasele Atlas, Dictionar, Roman, Manual
 *      este o clasa abstracta deoarece pentru fiecare tip de carte perioada de imprumut difera
 *
 *
 *
 * Functia abstracta zileImprumut() este implementata in clasele derivate in funtie de tip
 *
 *
 */

public abstract class Carte {

    private int id_carte;
    private String titlu;
    private String autor;
    protected boolean imprumutata;


    public Carte(int id_carte, String titlu, String autor) {
        this.id_carte = id_carte;
        this.titlu = titlu;
        this.autor = autor;
        this.imprumutata = false;
    }


    public int getId_carte() {
        return id_carte;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setImprumutata(boolean imprumutata) {
        this.imprumutata = imprumutata;
    }


    public boolean isImprumutata() {
        return imprumutata;
    }


    abstract public int zileImprumut();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(titlu, carte.titlu) &&
                Objects.equals(autor, carte.autor);
    }

    @Override
    public String toString() {
        return
                "id_carte = " + id_carte +
                ", titlu = '" + titlu + '\'' +
                ", autor = '" + autor + '\'' +
                ", imprumutata = " + imprumutata;
    }
}
