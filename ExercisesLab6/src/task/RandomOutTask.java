package task;

import java.util.Random;

public class RandomOutTask implements Task {
    private int randomNumber;

    public RandomOutTask() {
        Random rand = new Random();
        randomNumber = rand.nextInt(1000);
    }

    @Override
    public void printValue() {

        System.out.println("RandomOutTask \nRandom number: " + randomNumber + '\n');

    }
}
