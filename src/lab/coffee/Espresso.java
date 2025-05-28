package lab.coffee;

public class Espresso extends Coffee {
    public Espresso() {
        this.description = "Espresso Coffee";
    }
    @Override
    public double cost(){
        return 1; //에스프레소는 1.99 달러
    }
}
