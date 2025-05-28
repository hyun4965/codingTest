package gold;

import java.util.Scanner;

//브루토 포스 알고리즘 사용
public class BJ1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 이동하려는 채널
        int M = sc.nextInt(); // 고장난 버튼 수
        boolean[] broken = new boolean[10]; // 고장난 버튼 여부 체크

        if (M > 0) {
            for (int i = 0; i < M; i++) {
                int b = sc.nextInt();
                broken[b] = true;
            }
        }

        // 1. +,- 만 사용했을 때
        int minPress = Math.abs(N - 100);

        // 2. 모든 채널 번호 시도 (0 ~ 999999)
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean canPress = true;

            for (int j = 0; j < s.length(); j++) {
                if (broken[s.charAt(j) - '0']) {
                    canPress = false;
                    break;
                }
            }

            if (canPress) {
                // 숫자 누른 횟수 + (그 번호에서 N까지의 거리)
                int press = s.length() + Math.abs(N - i);
                minPress = Math.min(minPress, press);
            }
        }

        System.out.println(minPress);
    }
}
