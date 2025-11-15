package silver;

import java.util.*;

public class BJ1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        int[] count = new int[26];

        for (char c : name.toCharArray()) {
            count[c - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                middle = String.valueOf((char) (i + 'A'));
            }
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char) (i + 'A'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        System.out.println(left.toString() + middle + right);
    }
}
