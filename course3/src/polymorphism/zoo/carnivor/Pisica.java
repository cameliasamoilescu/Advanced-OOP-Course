package polymorphism.zoo.carnivor;

public class Pisica extends Carnivor {
    public Pisica(String nume, int varsta) {
        super(nume, varsta);
    }

    @Override
    public void scoateSunet() {
        System.out.println("pisica " + this.sunetSpecific);
    }

    @Override
    public String toString() {
        return super.toString() + " Piscica{ " + "sunetSpecific=" + sunetSpecific + '\'' + " }";
    }

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof Pisica){
           Pisica pisica = (Pisica) obj;
           return pisica.getNume().equals(this.getNume());
       }
       return false;
    }
}
