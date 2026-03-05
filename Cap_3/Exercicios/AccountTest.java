import java.util.Scanner;

public class AccountTest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Account c1 = new Account("Viado", 2000.00);
        c1.setName("Humberto");
        System.out.println(c1.getName());
        System.out.printf("O valor atual na conta é: %.2f\n", c1.getBalance());
        System.out.println("Digite a quantidade a ser sacada");
        double valorSaque = input.nextDouble();
        c1.withdraw(valorSaque);
    }
}