package middle2;
import java.util.Scanner;

public class A7_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = {500, 100, 10, 5, 1};

        int[] counts = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            counts[i] = n / coins[i];
            n %= coins[i];
        }

        for (int i = 0; i < coins.length; i++) {
            if (counts[i] > 0) {
                System.out.println(coins[i] + "원: " + counts[i] + "개");
            }
        }
    }
}
