package silver;

import java.util.Scanner;

public class NandM2 {
    static int n, m;
    static int[] s;
    static boolean[] visited;

    //main 함수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[m];
        visited = new boolean[m + 1]; //m+1개 boolean값
        dfs(0,1);// depth와 start를 첫번째것 입력
    }

    //재귀로 부름.
    static void dfs(int depth, int start) {
        // 길이가 M인 수열을 완성한 경우
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
            return;
        }

        // start부터 n까지 숫자를 하나씩 선택
        for (int i = start; i <= n; i++) {
            s[depth] = i;  // 현재 깊이 위치에 i를 저장
            dfs(depth + 1, i + 1);  // 다음 깊이로 재귀 호출, i+1부터 시작
        }
    }
}
