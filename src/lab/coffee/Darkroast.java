package lab.coffee;

public class Darkroast extends Coffee {
    public Darkroast() {
        this.description = "Dark Roasted Coffee";
    }
    @Override
    public double cost(){
        return 1.00; //0.99 달러
    }
}
