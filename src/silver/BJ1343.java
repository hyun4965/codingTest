package silver;

import java.util.Scanner;

public class BJ1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.nextLine();

        StringBuilder result = new StringBuilder();
        int n = board.length();
        int i = 0;

        while (i < n) {
            char c = board.charAt(i);

            if (c == '.') {
                result.append('.');
                i++;
            } else {
                int j = i;
                while (j < n && board.charAt(j) == 'X') {
                    j++;
                }
                int len = j - i;

                if (len % 2 == 1) {
                    System.out.println(-1);
                    return;
                }

                int aCount = len / 4;
                for (int k = 0; k < aCount; k++) {
                    result.append("AAAA");
                }

                if (len % 4 == 2) {
                    result.append("BB");
                }

                i = j;
            }
        }

        System.out.println(result.toString());
    }
}
