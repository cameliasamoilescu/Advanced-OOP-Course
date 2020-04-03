public class Cup implements BubbleBathable{

    double volume;
    String color;

    public int getLevelOffagility(){
        return Washable.FRAGILE;
    }

    @Override
    public boolean needsWashing() {
        return false;
    }

    @Override
    public void wash(){
        needsWashing();
        System.out.println("Washing a cup");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("doesn't need bubble bathing");
    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {

    }
}
