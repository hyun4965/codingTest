package platinum;

import java.util.Scanner;

public class BJ1305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String s = sc.next();
        System.out.println(L - makeTable(s, L));
    }

    private static int makeTable(String s, int L) {
        int[] table = new int[L];
        int j = 0;

        for (int i = 1; i < L; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table[L - 1];
    }
}
