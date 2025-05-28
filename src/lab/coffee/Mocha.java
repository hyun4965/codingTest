package lab.coffee;

class Mocha extends CoffeeDecorator {
    public Mocha(Coffee c) { super(c); }

    @Override
    public String getDescription() {
        return c.getDescription() + " + Mocha";
    }

    @Override
    public double cost() {
        return c.cost() + 0.1; // 모카 추가시 $0.20달러
    }
}
