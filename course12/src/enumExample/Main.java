package enumExample;

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        pizza.setPizzaStatus(Pizza.PizzaStatus.ORDERED);

        System.out.println(pizza);
        System.out.println("Time to deliver: " + pizza.getTimeOfDeliveryInHours());

        for(Pizza.PizzaStatus status: Pizza.PizzaStatus.values()){
            System.out.println(status.name() + ": " + status.getHoursToDeliver());
        }

    }
}
