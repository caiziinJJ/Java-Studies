public class EmployeeTest{
    public static void main(String[] args){
        Employee e1 = new Employee("Ricardo", "Vargas", 1800.00);
        Employee e2 = new Employee("Janúvio", "Texera", 8572.00);
        System.out.println("Utilização dos métodos Get e Set da variável de instância name");
        System.out.println(e1.getName());
        e1.setName("Tenébrio");
        System.out.println(e1.getName());
        System.out.println("Utilização dos métodos Get e Set da variável de instância surname");
        System.out.println(e2.getSurname());
        e1.setSurname("Texeira");
        System.out.println(e1.getSurname());
        System.out.println("Utilização dos métodos Get e Set da variável de instância monthlySalary");
        System.out.println(e2.getMonthlySalary());
        e2.setMonthlySalary(8100.98);
        System.out.println(e2.getMonthlySalary() + "\n\n\n");
        double salaryTest = e2.getMonthlySalary();
        double salaryPlusTenPercent = salaryTest + (salaryTest * 0.10);
        //System.out.println(salaryTest);
        System.out.printf("O salário anual atual do funcionário %s é %.2f, com o reajuste de 10%%, o novo montante mensal é: %.2f%n", e1.getName(), e2.getMonthlySalary(), e2.getMonthlySalary() + e2.getMonthlySalary() * 0.10 );


    }
}