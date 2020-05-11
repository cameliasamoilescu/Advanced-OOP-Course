public class Car implements BubbleBathable{

    @Override
    public void  wash(){
        System.out.println("Washing a car");
    }

    @Override
    public void soak() {
        System.out.println("soaking the car");
    }

    @Override
    public void takeBubbleBath() {

    }

    @Override
    public void scrub() {
        System.out.println("soft scrub");
    }
}
