public class Account{
    private String name;
    private double balance;

    public Account(String name, double balance){
        this.name = name;

        if(balance > 0.0){
            this.balance = balance;
        }
        else{
            System.out.println("Invalid value!");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        if(amount <= 0){
            System.out.println("Invalid value");
        }
        else{
            double oldBalance = balance;
            balance += amount;
            System.out.printf("Valor anterior: %.2f\nValor atual: %.2f\n",oldBalance, balance);
        }
    }

    public void withdraw(double value){
        if (value > balance){
            System.out.println("Withdrawl amount exceeded account balance");
        } else if (value <= 0) {
            System.out.println("Invalid amount of money");
        } else{
            double oldBalance = balance;
            balance -= value;
            System.out.printf("O valor antigo da conta era: %.2f e agora é: %.2f\n",oldBalance, balance);
        }
    }
}

