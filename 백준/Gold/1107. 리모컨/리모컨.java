import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        int minPress = Math.abs(n - 100);

        for (int i = 0; i <= 999999; i++) {
            int len = check(i);
            if (len > 0) {
                int press = len + Math.abs(n - i);
                minPress = Math.min(minPress, press);
            }
        }

        System.out.print(minPress);
    }

    static int check(int n) {
        if (n == 0) return broken[0] ? 0 : 1;

        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) return 0;
            n /= 10;
            len++;
        }
        return len;
    }
}
