package conteiner;
import task.Task;


public interface Conteiner {

    boolean isEmpty();
    Task pop();
    void push(Task task);
}
