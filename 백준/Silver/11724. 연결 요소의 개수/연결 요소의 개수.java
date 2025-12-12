import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++; 
            }
        }

        System.out.println(count);
    }

    static void dfs(int index) {
        visited[index] = true; 

        for (int i : list.get(index)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}