public class Ex1 {
    public static void main(String[] args) {
//        washable = new Washable();

        Washable washable = new Car();
        washable.wash();


        Washable dog = new Dog();
        if (dog.needsWashing()) {
            dog.wash();
        }

        Washable car = new Car();
        car.wash();



    }
}
