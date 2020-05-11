package candyBox;

import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        flavor = "";
        origin = "";
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume(){
        return 0;
    }

    @Override
    public String toString() {
        return " flavor = " + flavor + ' '+
                "origin = "+ origin + '\n';
    }

    public String getFlavor(){
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return flavor.equals(candyBox.flavor) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, origin);
    }
}
