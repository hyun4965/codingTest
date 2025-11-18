import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            // 공백 출력
            for (int s = 0; s < N - i; s++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int star = 0; star < i; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}