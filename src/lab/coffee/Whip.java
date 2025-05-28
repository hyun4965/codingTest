package lab.coffee;

class Whip extends CoffeeDecorator {
    public Whip(Coffee c) { super(c); }

    @Override
    public String getDescription() {
        return c.getDescription() + " + Whip";
    }

    @Override
    public double cost() {
        return c.cost() + 0.1; // Whip 추가시 $0.1달러
    }
}