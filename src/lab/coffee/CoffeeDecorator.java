package lab.coffee;

abstract class CoffeeDecorator extends Coffee { // Coffee가 인터페이스면 implements
    protected Coffee c; // *** Coffee를 가지고(has-a) 있다. ***
    public CoffeeDecorator(Coffee c) { this.c = c; }
}
