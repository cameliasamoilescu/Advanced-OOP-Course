package CandyBox;

public class CandyBag {

    private final int nrBoxes;
    private int index;
    CandyBox[] chocolateBox;

    public CandyBag(int nrBoxes) {
        if (nrBoxes > 0) {
            this.nrBoxes = nrBoxes;
            this.chocolateBox = new CandyBox[nrBoxes];
        } else {

            throw new RuntimeException("Nu ati introdus un nr positiv ");

        }

    }

    public void adaugaChocolateBox(CandyBox candyBox){
        if(index < nrBoxes){
            chocolateBox[index++] = candyBox;
        }

    }
}


