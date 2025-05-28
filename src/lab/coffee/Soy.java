package lab.coffee;

class Soy extends CoffeeDecorator {
    public Soy(Coffee c) { super(c); }

    @Override
    public String getDescription() {
        return c.getDescription() + " + Soy";
    }

    @Override
    public double cost() {
        return c.cost() + 0.1; // 모카 추가시 $0.15달러
    }
}
