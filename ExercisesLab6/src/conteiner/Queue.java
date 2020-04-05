package conteiner;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public class Queue implements Conteiner{
    private List<Task> list = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Task pop() {
        if(list.size() > 0){
            Task task = list.get(0);
            list.remove(0);
            return task;
        }
        else
            return null;
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }
}
