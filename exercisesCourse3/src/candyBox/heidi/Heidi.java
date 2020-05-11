package candyBox.heidi;

import candyBox.CandyBox;

public class Heidi extends CandyBox {
    private int length;

    public Heidi(){
        super();
        length = 0;
    }

    public Heidi(String flavor, String origin, int length) {
        super(flavor, origin);
        this.length = length;
    }

    public void printHeidiDim(){
        System.out.println("length " + this.length);
    }

    @Override
    public float getVolume() {
        return length*length*length;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() +
                " " + this.getFlavor() +
                " has volume " +
                this.getVolume();
    }
}
