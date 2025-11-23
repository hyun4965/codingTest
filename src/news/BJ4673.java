package news;

public class BJ4673 {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = d(i);

            if (n <= 10000) {
                check[n] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }

    public static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        return sum;
    }
}
