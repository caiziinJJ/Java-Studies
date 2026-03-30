public class Invoice{
    private String number;
    private String description;
    private int quantityBought;
    private double price;

    public Invoice(String number, String description, int quantityBought, double price){
        this.number = number;  //O this.number representa o atributo "number" do objeto que será criado
        this.description = description;
        if (quantityBought <= 0 ){
            this.quantityBought = 0;
        }
        else {
            this.quantityBought = quantityBought;
        }
        if (price <= 0 ){
            this.price = 0;
        }
        else {
            this.price = price;
        }
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        String numberString = number;
        double numberDouble = Double.parseDouble(numberString);
        if (numberDouble <=0){
            System.out.println("Invalid quantity");
        }
        else {
            this.number = numberString;
        }
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
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
            this.quantityBought = quantityBought;
        }
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if (price <= 0 ){
            this.price = 0;
        }
        else {
            this.price = price;
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