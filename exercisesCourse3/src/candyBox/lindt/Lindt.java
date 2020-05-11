package candyBox.lindt;

import candyBox.CandyBox;

public class Lindt extends CandyBox {
    private int length, width, height;

    public Lindt(){
        super();
        length = 0;
        height = 0;
        width = 0;
    }

    public void printLindtDim(){
        System.out.println("lenght: " + length + " width" + width + " height");
    }
    public Lindt(String flavor, String origin, int length, int width, int height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length*width*height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() +
                " " + this.getFlavor() +
                " has volume " +
                this.getVolume();
    }
}
