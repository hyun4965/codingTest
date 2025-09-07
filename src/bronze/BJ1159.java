package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] cnt = new int[26];

        for (int i = 0; i < N; i++) {
            String lastName = br.readLine().trim();
            char first = lastName.charAt(0);
            cnt[first - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 5) ans.append((char)('a' + i));
        }

        if (ans.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(ans.toString());
        }
    }
}
