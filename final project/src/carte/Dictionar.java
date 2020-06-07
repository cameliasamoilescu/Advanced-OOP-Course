package carte;

import java.util.Objects;

/**
 *
 * Clasa Dictionar este derivata din Carte si
 * implementeaza metoda abstracta zileImprumut()
 *
 *
 * Dictionarele sunt imprumutate pe o perioada de 60 de zile
 *
 *
 */

public class Dictionar extends Carte {
    private String tip;
    private String editura;


    public Dictionar(String titlu, String autor, String tip, String editura) {
        super(titlu, autor);
        this.tip = tip;
        this.editura = editura;
    }

    public Dictionar(int idCarte, String titlu, String autor, boolean imprumutata, String tip, String editura) {
        super(idCarte, titlu, autor, imprumutata);
        this.tip = tip;
        this.editura = editura;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    @Override
    public int zileImprumut() {
        return 60;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dictionar dictionar = (Dictionar) o;
        return Objects.equals(tip, dictionar.tip) &&
                Objects.equals(editura, dictionar.editura);
    }

    @Override
    public String toString() {
        return "Dictionar {"
                + super.toString() +
                ", tip='" + tip + '\'' +
                ", editura='" + editura + '\'' +
                " } " ;
    }
}
