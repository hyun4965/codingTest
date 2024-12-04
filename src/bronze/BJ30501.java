package bronze;

import java.util.Scanner;

public class BJ30501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            if (arr[i].contains("S")) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
