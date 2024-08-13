package bronze;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String[] words = s.split(" ");

            StringBuilder result = new StringBuilder();
            for (String word : words) {
                StringBuilder reversedWord = new StringBuilder(word).reverse();
                result.append(reversedWord).append(" ");
            }
            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}