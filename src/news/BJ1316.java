package news;

import java.util.Scanner;

public class BJ1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (check(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean check(String str) {
        boolean[] visited = new boolean[26];
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (visited[now - 'a']) {
                    return false;
                }
                visited[now - 'a'] = true;
                prev = now;
            }
        }

        return true;
    }
}
