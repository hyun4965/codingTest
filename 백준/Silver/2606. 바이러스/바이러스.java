import java.util.Scanner;

public class Main {
    static int n;
    static int m; 
    static int[][] graph; 
    static boolean[] visited; 
    static int count = 0; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int start) {
        visited[start] = true; 
        count++; 

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i); 
            }
        }
    }
}