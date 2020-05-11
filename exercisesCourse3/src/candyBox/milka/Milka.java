package candyBox.milka;

import candyBox.CandyBox;

public class Milka extends CandyBox {
    private int height, R;

    public Milka(){
        super();
        height = 0;
        R = 0;
    }
    public Milka(String flavor, String origin, int height, int r) {
        super(flavor, origin);
        this.height = height;
        R = r;
    }

    public void printMilkaDim(){
        System.out.println("Height: " + height + " R: " + R);
    }
    @Override
    public float getVolume() {
        return (float)3.14*R*R*height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() +
                " " + this.getFlavor() +
                " has volume " +
                this.getVolume();
    }
}
