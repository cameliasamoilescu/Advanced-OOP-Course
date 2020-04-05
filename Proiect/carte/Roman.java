package carte;

import java.util.Objects;
/**
 * Clasa Roman este derivata din Carte si
 * implementeaza metoda abstracta zileImprumut()
 *
 *
 * Romanele sunt imprumutate pe o perioada de 15 de zile
 *
 *
 */
public class Roman extends Carte{
    private String gen;


    public Roman(int id_carte, String titlu, String autor, String gen) {
        super(id_carte, titlu, autor);
        this.gen = gen;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }


    @Override
    public int zileImprumut() {
        return 15;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Roman roman = (Roman) o;
        return Objects.equals(gen, roman.gen);
    }



    @Override
    public String toString() {
        return "Roman {" +
                super.toString() +
                " gen='" + gen + '\'' +
                ", imprumutata=" + imprumutata +
                " }";
    }
}
