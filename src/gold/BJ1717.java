package gold;

import java.util.*;

public class BJ1717 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 원소 개수
        int m = sc.nextInt(); // 연산 개수

        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (cmd == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }
    public static void union(int a, int b) {
        int q = find(a);
        int w = find(b);
        if (q != w) {
            arr[w] = q;
        }
    }

    public static int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]); // 경로 압축
        }
        return arr[x];
    }

}
