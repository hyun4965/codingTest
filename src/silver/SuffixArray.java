package silver;

import java.util.Arrays;
import java.util.Scanner;

public class SuffixArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        String[] suffixes = new String[S.length()];

        for (int i = 0; i < S.length(); i++) {
            suffixes[i] = S.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            System.out.println(suffix);
        }
    }
}
