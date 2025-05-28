package lab.coffee;

public class StarBuzzMain {
    public static void main(String[] args) {
        Coffee coffee = new Darkroast();        // 4불
        coffee = new Mocha(coffee);             // +2불 = 6
        coffee = new Whip(coffee);              // +2불 = 8
        coffee = new GreenTee(coffee);           // +2불 = 10
        System.out.println("-----------------");
        System.out.println("   주문영수증");
        System.out.println("-----------------");

        System.out.println("명세: " + coffee.getDescription());
        System.out.println("가격: " + coffee.cost() + "불");
    }
}