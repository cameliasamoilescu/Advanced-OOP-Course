package conteiner;

import task.CounterOutTask;
import task.OutTask;
import task.RandomOutTask;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        CounterOutTask counterOutTask = new CounterOutTask();

        RandomOutTask randomOutTask = new RandomOutTask();

        OutTask outTask = new OutTask("you are in OutTask");

        Queue queue = new Queue();
        queue.push(counterOutTask);
        queue.push(randomOutTask);
        queue.push(outTask);

        Stack stack = new Stack();
        stack.push(counterOutTask);
        stack.push(randomOutTask);
        stack.push(outTask);


        System.out.println("This is the stack:");
        while(!stack.isEmpty())
            stack.pop().printValue();

        System.out.println("This is the queue");

        while(!queue.isEmpty())
            queue.pop().printValue();

    }
}
