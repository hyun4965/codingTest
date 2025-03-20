package gold;

import java.util.Scanner;

public class BJ12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();

        StringBuilder t = new StringBuilder(T);

        while (t.length() > S.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        System.out.println(t.toString().equals(S) ? 1 : 0);
    }
}
