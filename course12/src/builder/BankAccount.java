package builder;

public class BankAccount {
    private String name;
    private String accountNo;
    private String email;
    private boolean acceptNewsletter;

    public BankAccount(BankAccountBuilder bankAccountBuilder) {
        this.name =bankAccountBuilder.name;
        this.accountNo = bankAccountBuilder.accountNo;
        this.email = bankAccountBuilder.email;
        this.acceptNewsletter = bankAccountBuilder.acceptNewsletter;
    }

    static class BankAccountBuilder{
        private String name;
        private String accountNo;
        private String email;
        private boolean acceptNewsletter;

        public BankAccountBuilder withName(String name){
            this.name = name;
            return this;
        }
        public BankAccountBuilder withAccountNo(String accountNo){
            this.accountNo = accountNo;
            return this;
        }
        public BankAccountBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public BankAccountBuilder acceptNewsletter(boolean acceptNewsletter){
            this.acceptNewsletter = acceptNewsletter;
            return this;
        }

        public BankAccount build(){
            return new BankAccount(this);
        }

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", email='" + email + '\'' +
                ", acceptNewsletter=" + acceptNewsletter +
                '}';
    }
}
