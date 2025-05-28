package lab.coffee;

public class HouseBlend extends Coffee {
    public HouseBlend() {
        this.description = "HouseBlend Coffee";
    }
    @Override
    public double cost(){
        return 1.00; //0.99 달러
    }
}
