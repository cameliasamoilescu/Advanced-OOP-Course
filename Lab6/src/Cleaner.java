public class Cleaner {

    public static void cleanObject(Object object){
        if(object instanceof Car){
            Car car = (Car) object;
            car.wash();
        } else if (object instanceof Window){
            Window window = (Window) object;
            window.wash();
        } else if (object instanceof Cup){
            Cup cup = (Cup) object;
            cup.wash();
        } else if (object instanceof Dog){
            Dog dog = (Dog) object;
            dog.wash();
        } else {
            throw new RuntimeException();
        }

    }
    public static void clean(WashableObject washableObject){
        washableObject.wash();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        //clean(dog);


        Window window = new Window();
        cleanObject(window);
        //clean(window);

        Car car = new Car();
        //clean(car);


        Cup cup = new CoffeeCup();
        //clean(cup);

        String unknownType = "unknown type";
        cleanObject(unknownType);
//        clean(unknownType); // does not complile, not a washableObject

    }
}
