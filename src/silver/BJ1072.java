package silver;

import java.util.Scanner;

public class BJ1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong(); // 총 게임 수
        long Y = sc.nextLong(); // 이긴 게임 수

        long currentWinRate = (Y * 100) / X;

        // 승률이 이미 99 이상이면, 더 이상 올라갈 수 없음
        if (currentWinRate >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1000000000L;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long newWinRate = ((Y + mid) * 100) / (X + mid);

            if (newWinRate > currentWinRate) {
                result = mid;
                right = mid - 1; // 최소값 찾기 위해 왼쪽 탐색
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
