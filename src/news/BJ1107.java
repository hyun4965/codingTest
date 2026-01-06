package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            broken[b] = true;
        }

        int minPress = Math.abs(n - 100);

        for (int i = 0; i <= 999999; i++) {
            int len = check(i);
            if (len > 0) {
                int press = len + Math.abs(n - i);
                if (press < minPress) {
                    minPress = press;
                }
            }
        }

        System.out.print(minPress);
    }

    static int check(int n) {
        if (n == 0) {
            return broken[0] ? 0 : 1;
        }
        int len = 0;
        int temp = n;
        while (temp > 0) {
            if (broken[temp % 10]) {
                return 0;
            }
            temp /= 10;
            len++;
        }
        return len;
    }
}