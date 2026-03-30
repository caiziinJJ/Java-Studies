public class InvoiceTest{
    public static void main(String[] args){
        Invoice teste1 = new Invoice("1", "Compra mercado", 36, 349.99);
        System.out.println("Teste Métodos Get e Set da variável de instância number.");
        System.out.println(teste1.getNumber());
        teste1.setNumber("20");
        System.out.println(teste1.getNumber());
        System.out.println("Teste Métodos Get e Set da variável de instância description.");
        System.out.println(teste1.getDescription());
        teste1.setDescription("Compra de Armas");
        System.out.println(teste1.getDescription());
        System.out.println("Teste Métodos Get e Set da variável de instância quantityBought.");
        System.out.println(teste1.getQuantityBought());
        teste1.setQuantityBought(3);
        System.out.println(teste1.getQuantityBought());
        System.out.println("Teste Métodos Get e Set da variável de instância price.");
        System.out.println(teste1.getPrice());
        teste1.setPrice(17985.34);
        System.out.println(teste1.getPrice());
        System.out.printf("O total gasto foi: %.2f%n", teste1.getInvoiceAmount());
    }
}