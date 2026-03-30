public class Employee{
    private String name;
    private String surname;
    private double monthlySalary;

    public Employee(String name, String surname, double monthlySalary){
        this.name = name;
        this.surname = surname;
        if (monthlySalary <= 0) {
            System.out.println("Salário inválido!");
        } else {
            this.monthlySalary = monthlySalary;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public double getMonthlySalary(){
        return monthlySalary;
    }
    public void setMonthlySalary(double monthlySalary){
        if (monthlySalary <= 0) {
            System.out.println("Salário inválido!");
        } else {
            this.monthlySalary = monthlySalary;
        }
    }

}