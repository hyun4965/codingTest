package silver;

import java.util.Scanner;

public class BJ1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count0 = 0;
        int count1 = 0;

        char prev = s.charAt(0);
        if (prev == '0') {
            count0++;
        }else {
            count1++;
        }

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != prev) {
                if (cur == '0') {
                    count0++;
                }else {
                    count1++;
                }
                prev = cur;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
