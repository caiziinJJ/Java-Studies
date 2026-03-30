import java.util.Scanner;
public class AccountTestQuestion
{
    public static void main(String[] args)
    {
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        //System.out.printf("%s balance: $%.2f %n", account1.getName(),account1.getBalance());
        //System.out.printf("%s balance: $%.2f %n%n", account2.getName(),account2.getBalance());
        displayAccount(account1);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter deposit amount for account1: "); // prompt
        double depositAmount = input.nextDouble(); // obtém a entrada do usuário
        System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
        account1.setBalance(depositAmount); // adiciona o saldo de account1
        displayAccount(account1);

        System.out.print("Enter deposit amount for account2: "); // prompt
        depositAmount = input.nextDouble(); // obtém a entrada do usuário
        System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
        account2.setBalance(depositAmount); // adiciona ao saldo de account2

        displayAccount(account1);
        displayAccount(account2);
    }
    public static void displayAccount(Account accountToDisplay){
        System.out.printf("Proprietário da conta: %s, valor em deposito: %.2f. %n", accountToDisplay.getName(), accountToDisplay.getBalance());
    }
} // fim da classe AccountTest