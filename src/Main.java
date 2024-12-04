import java.util.Arrays;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        backtrack(0, 0);
        System.out.println(minDifference);
        sc.close();
    }

    static void backtrack(int depth, int start) {
        if (depth == N / 2) {
            int startTeam = 0, linkTeam = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        startTeam += S[i][j]; // 스타트 팀 능력치 합산
                    } else if (!visited[i] && !visited[j]) {
                        linkTeam += S[i][j]; // 링크 팀 능력치 합산
                    }
                }
            }

            // 두 팀 간 능력치 차이 계산
            int difference = Math.abs(startTeam - linkTeam);
            minDifference = Math.min(minDifference, difference);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 선수를 스타트 팀으로 배정
                backtrack(depth + 1, i + 1); // 다음 선수를 배정
                visited[i] = false; // 배정을 해제하고 다음 경우 탐색
            }
        }
    }
}
