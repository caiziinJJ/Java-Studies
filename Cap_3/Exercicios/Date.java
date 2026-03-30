public class Date{
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year){
        if(month <0 && month > 12){
            System.out.println("Mês inválido");
        }
        else {
            this.month = month;
        }
        if(day < 0 && day > 31){
            System.out.println("Dia inválido");
        }
        else {
            this.day = day;
        }
        if(year < 1850 && year > 2026){
            System.out.println("Ano inválido");
        }
        else {
            this.year = year;
        }
    }

    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        if(month <0 && month > 12){
            System.out.println("Mês inválido");
        }
        else {
            this.month = month;
        }
    }
    public int getDay(){
        return day;
    }
    public void setDay(int day){
        if(day < 0 && day > 31){
            System.out.println("Dia inválido");
        }
        else {
            this.day = day;
        }
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        if(year < 1850 && year > 2026){
            System.out.println("Ano inválido");
        }
        else {
            this.year = year;
        }
    }
    public String displayDate(Date object){
        String textoExibicao = "A data é " + object.month + "/" + object.day + "/" + object.year + "." ;
        return textoExibicao;
        //return System.out.printf("A data é %d/%d/%d %n", object.month, object.day, object.year);
    }

}