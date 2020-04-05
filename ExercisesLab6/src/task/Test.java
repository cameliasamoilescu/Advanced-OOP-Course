package task;

public class Test {

    public static void main(String[] args) {
        CounterOutTask counterOutTask = new CounterOutTask();
        counterOutTask.printValue();
        counterOutTask.printValue();


        RandomOutTask randomOutTask = new RandomOutTask();
        randomOutTask.printValue();

        OutTask outTask = new OutTask("you are in OutTask");
        outTask.printValue();
    }


}
