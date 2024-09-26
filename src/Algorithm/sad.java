package Algorithm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS 예제문제
public class sad {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] farm = new int[N][M];  // 배추 농장 상태 배열
        int[][] days = new int[N][M];  // 배추가 익는 날짜를 기록할 배열

        // 농장 상태 입력
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                farm[i][j] = sc.nextInt();
                if (farm[i][j] == 1) {
                    // 익은 배추(전염된 배추)의 위치를 큐에 추가
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 농장 범위를 벗어나지 않으며, 아직 익지 않은 배추(0)를 찾으면 전염
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && farm[nx][ny] == 0) {
                    farm[nx][ny] = 1;  // 전염
                    days[nx][ny] = days[x][y] + 1;  // 날짜 증가
                    queue.offer(new int[]{nx, ny});  // 큐에 추가하여 다음 단계에서 처리
                }
            }
        }

        // 결과 계산
        int maxDays = 0;
        boolean allInfected = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 익지 않은 배추가 있는지 확인
                if (farm[i][j] == 0) {
                    allInfected = false;
                }
                // 가장 오래 걸린 날짜를 찾음
                maxDays = Math.max(maxDays, days[i][j]);
            }
        }

        // 출력
        if (!allInfected) {
            System.out.println("-1");  // 모든 배추가 전염되지 못하는 경우
        } else {
            System.out.println(maxDays);  // 최소 날짜 출력
        }

        sc.close();
    }
}
