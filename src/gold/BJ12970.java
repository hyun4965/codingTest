package gold;

import java.util.Arrays;
import java.util.Scanner;


public class BJ12970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int aNum = 0;
        int bNum = 0;


        for (int i = 0; i <= K; i++) {
            aNum = i;
            bNum = N - i;

            if (aNum * bNum >= K) {
                break;
            }

            // 만들 수 없는 경우
            if (i == K) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        String[] answer = new String[N];
        Arrays.fill(answer, "B");

        if (K == 0) {
            for (String s : answer) {
                System.out.print(s);
            }
            System.exit(0);
        }

        for (int i = 0; i < aNum - 1; i++) {
            answer[i] = "A";
        }
        int currentTwins = (aNum - 1) * bNum;
        int haveMoveA = K - currentTwins;
        answer[N - 1 - haveMoveA] = "A";

        for (String s : answer) {
            System.out.print(s);
        }
    }
}