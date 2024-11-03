package silver;

import java.util.Scanner;

public class BJ1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        sc.close();

        long sum = 0;
        int N = 0;

        // 1부터 차례대로 더해가며 sum이 S를 넘지 않을 때까지 반복
        for (int i = 1; ; i++) {
            sum += i;
            N++;
            if (sum > S) {  // 합이 S를 초과하면 반복 종료
                N--;  // 초과된 경우이므로 마지막에 더한 숫자를 제외하기 위해 N을 감소
                break;
            }
        }

        System.out.println(N);
    }
}
