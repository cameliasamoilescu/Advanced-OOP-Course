package task;

public class CounterOutTask implements Task {
    public static int counter = 0;

    @Override
    public void printValue() {
        counter += 1;
        System.out.println("CounterOutTask\nCounter is: " + counter + '\n');

    }
}
