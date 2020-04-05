package task;

public class OutTask implements Task {

    private String message;
    public OutTask(String msg) {
        this.message = msg;
    }

    @Override
    public void printValue() {
        System.out.println("OutTask: \n" + this.message + '\n');

    }
}
