package gold;

import java.util.Scanner;
import java.util.Arrays;

public class BJ14938 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 지역의 개수
        int m = sc.nextInt(); // 수색 범위
        int r = sc.nextInt(); // 길의 개수

        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            dist[a][b] = l;
            dist[b][a] = l;
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            int currentItems = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    currentItems += items[j];
                }
            }
            maxItems = Math.max(maxItems, currentItems);
        }

        System.out.println(maxItems);
    }
}