package silver;

import java.util.Scanner;

public class BJ1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] count = new int[10];

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            count[num]++;
        }

        int sixNine = (count[6] + count[9] + 1) / 2; // 6과 9의 개수를 합쳐서 2로 나눈 값
        count[6] = sixNine;
        count[9] = sixNine;


        int maxSet = 0;
        for (int i = 0; i < 10; i++) {
            maxSet = Math.max(maxSet, count[i]);
        }

        System.out.println(maxSet);
    }
}
