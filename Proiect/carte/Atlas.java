package carte;

import java.util.Objects;


/**
 * Clasa Atlas este derivata din Carte si
 * implementeaza metoda abstracta zileImprumut()
 *
 *
 * Atlasurile sunt imprumutate pe o perioada de 90 de zile
 *
 *
 */

public class Atlas extends Carte{

    private String editura;

    public Atlas( String titlu, String autor, String editura) {
        super(titlu, autor);
        this.editura = editura;
    }

    @Override
    public int zileImprumut() {
        return 90;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Atlas atlas = (Atlas) o;
        return Objects.equals(editura, atlas.editura);
    }

    @Override
    public String toString() {
        return "Atlas {" +
                super.toString() +
                ", editura='" + editura + '\'' +
                " }";
    }
}
