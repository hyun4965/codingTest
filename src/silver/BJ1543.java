package silver;

import java.util.Scanner;

public class BJ1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String doc = sc.nextLine();
        String word = sc.nextLine();

        int n = doc.length();
        int m = word.length();
        int count = 0;
        int i = 0;

        while (i <= n - m) {
            String str = doc.substring(i, i + m);
            if (str.equals(word)) {
                count++;
                i += m;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
