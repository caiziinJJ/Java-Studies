public class Invoice{
    private String number;
    private String description;
    private int quantityBought;
    private double price;

    public Invoice(String number, String description, int quantityBought, double price){
        number = this.number;
        description = this.description;
        if (this.quantityBought <= 0 ){
            quantityBought = 0;
        }
        else {
            quantityBought = this.quantityBought;
        }
        if (this.price <= 0 ){
            price = 0;
        }
        else {
            price = this.price;
        }
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        String numberString = this.number;
        double numberDouble = Double.parseDouble(numberString);
        if (numberDouble <=0){
            System.out.println("Invalid quantity");
        }
        else {
            number = numberString;
        }
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        description = this.description;
    }
    public String getQuantityBought(){
        String quantityString = String.valueOf(quantityBought);
        return quantityString;
    }
    public void setQuantityBought(int quantityBought){
        if(quantityBought <=0){
            System.out.println("Invalid quantity");
        }
        else {
            quantityBought = this.quantityBought;
        }
    }
    public String getPrice(){
        return number;
    }
    public void setPrice(double price){
        if (this.price <= 0 ){
            price = 0;
        }
        else {
            price = this.price;
        }
    }
    public double getInvoiceAmount(){
        if(quantityBought < 0){
            quantityBought = 0;
        }
        if(price < 0){
            price = 0;
        }
        double result = quantityBought * price;
        return result;
    }
}