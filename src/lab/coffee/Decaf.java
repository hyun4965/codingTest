package lab.coffee;

public class Decaf extends Coffee{
    public Decaf() {
        this.description = "Decaf Coffee";
    }
    @Override
    public double cost(){
        return 1; //1.05 달러
    }
}
