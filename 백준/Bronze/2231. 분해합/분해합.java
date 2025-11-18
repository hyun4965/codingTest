import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10; 
            }

            if (sum == N) {
                answer = i; 
                break;
            }
        }

        System.out.println(answer);
    }
}