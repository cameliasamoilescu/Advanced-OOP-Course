package builder;

public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount.BankAccountBuilder()
                .withName("bill")
                .withAccountNo("1234")
                .withEmail("@@a")
                .acceptNewsletter(true)
                .build();

        System.out.println(bankAccount);
    }
}
