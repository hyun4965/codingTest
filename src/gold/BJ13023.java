package gold;

import java.util.*;

public class BJ13023 {
    static int n,m;
    static List<List<Integer>> list;
    static boolean visited[];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //사람수
        m = sc.nextInt(); //관계수

        visited = new boolean[n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtrack(i, 0);
            visited[i] = false;

            if (found) {
                break;
            }
        }
        System.out.print(found ? 1 : 0);

    }
    static void backtrack(int cur, int depth) {
        //찾음
        if (found) {
            return;
        }
        //끝
        if (depth == 4) {
            found = true;
            return;
        }

        for (int next : list.get(cur)) {
            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            backtrack(next, depth + 1);
            visited[next] = false;

            if (found) {
                return;
            }
        }
    }
}
