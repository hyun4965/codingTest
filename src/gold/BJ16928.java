package gold;

import java.util.*;

public class BJ16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사다리수
        int M = sc.nextInt(); //뱀의 수

        int[] board = new int[101]; // 1~100번 칸을 사용
        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 기본적으로 각 칸은 자기 자신을 가리킴
        }
        //사다리
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x] = y; // x번 칸 도착 시 y번 칸으로 이동
        }
        //뱀
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            board[u] = v; // u번 칸 도착 시 v번 칸으로 이동
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101]; // 방문 여부 체크
        int[] moves = new int[101]; // 각 칸에 도달하기 위한 주사위 굴린 횟수
        // BFS 시작
        queue.add(1); // 1번 칸에서 시작
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 100번 칸에 도착하면 최소 횟수 출력 후 종료
            if (current == 100) {
                System.out.println(moves[current]);
                return;
            }

            // 주사위 굴리기 (1부터 6까지)
            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next <= 100 && !visited[next]) {
                    // 사다리 또는 뱀에 의한 이동 처리
                    next = board[next];

                    // 방문 처리 및 큐에 추가
                    if (!visited[next]) {
                        visited[next] = true;
                        moves[next] = moves[current] + 1;
                        queue.add(next);
                    }
                }
            }
        }
    }
}
