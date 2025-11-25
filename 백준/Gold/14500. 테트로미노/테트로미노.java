import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int maxSum = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                checkException(i, j);
            }
        }

        System.out.println(maxSum);
    }
    
    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false; 
                }
            }
        }
    }

    static void checkException(int x, int y) {
        int wings = 4; 
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (wings <= 2) {
                return;
            } 
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                wings--;
                continue;
            }

            min = Math.min(min, arr[nx][ny]);
            sum += arr[nx][ny];
        }

        if (wings == 4) {
            sum -= min;
        }

        maxSum = Math.max(maxSum, sum);
    }
}