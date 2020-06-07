package carte;

import java.util.Objects;
/**
 * Clasa Manual este derivata din Carte si
 * implementeaza metoda abstracta zileImprumut()
 *
 *
 * Manualele sunt imprumutate pe o perioada de 300 de zile
 *
 *
 */

public class Manual extends Carte{
    private String materie;

    public Manual(String titlu, String autor, String materie) {
        super(titlu, autor);
        this.materie = materie;
    }

    public Manual(int idCarte, String titlu, String autor, boolean imprumutata, String materie) {
        super(idCarte, titlu, autor, imprumutata);
        this.materie = materie;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    @Override
    public int zileImprumut() {
        return 300;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manual manual = (Manual) o;
        return Objects.equals(materie, manual.materie);
    }


    @Override
    public String toString() {
        return "Manual {" +
                super.toString() +
                ", materie='" + materie + '\'' +
                " }";
    }
}
