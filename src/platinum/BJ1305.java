package platinum;

import java.util.Scanner;

public class BJ1305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String input = sc.next();
        sc.close();

        System.out.println(length - getPrefixTable(input, length));
    }

    private static int getPrefixTable(String input, int length) {
        int[] prefixTable = new int[length];
        int j = 0;

        for (int i = 1; i < length; i++) {
            while (j > 0 && input.charAt(i) != input.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (input.charAt(i) == input.charAt(j)) {
                prefixTable[i] = ++j;
            }
        }
        return prefixTable[length - 1];
    }
}
