package lab.coffee;

class SteamedMilk extends CoffeeDecorator {
    public SteamedMilk(Coffee c) { super(c); }

    @Override
    public String getDescription() {
        return c.getDescription() + " + SteamedMilk";
    }

    @Override
    public double cost() {
        return c.cost() + 0.10; // SteamedMilk 추가시 $0.10달러
    }
}
