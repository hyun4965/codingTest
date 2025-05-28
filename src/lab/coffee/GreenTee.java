package lab.coffee;

public class GreenTee extends CoffeeDecorator {
    public GreenTee(Coffee c) { super(c); }

    @Override
    public String getDescription() {
        return c.getDescription() + " + GreenTee";
    }

    @Override
    public double cost() {
        return c.cost() + 0.1;
    }
}
