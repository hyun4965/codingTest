package gold;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        int[] alphabet = new int[26];

        for (String word : words) {
            int temp = (int) Math.pow(10, word.length() - 1);
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'A'] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alphabet);

        int answer = 0;
        int num = 9;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0) {
                break;
            }
            answer += alphabet[i] * num;
            num--;
        }
        System.out.println(answer);
    }
}
