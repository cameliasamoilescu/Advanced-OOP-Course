public class Dog extends Animal implements BubbleBathable{


    @Override
    public void  wash(){
        System.out.println("Washing a dog");
    }

    @Override
    public void takeBubbleBath() {

    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {
        System.out.println("do not apply");
    }


}

