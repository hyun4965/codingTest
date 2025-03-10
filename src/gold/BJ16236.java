package gold;

import java.util.*;

public class BJ16236 {
    static int N;
    static int[][] map;
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 상어 초기 위치 설정
                }
            }
        }
        System.out.println(simulate());
    }

    static int simulate() {
        int time = 0;

        while (true) {
            int[] target = findFish();
            if (target == null) break; // 먹을 수 있는 물고기가 없으면 종료

            // 먹을 물고기 위치로 이동
            sharkX = target[0];
            sharkY = target[1];
            eatCount++;
            map[sharkX][sharkY] = 0; // 먹은 칸을 빈칸으로

            time += target[2]; // 이동 시간 증가

            // 아기 상어 크기 증가 로직
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        return time;
    }

    static int[] findFish() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] != b[2] ? Integer.compare(a[2], b[2]) :
                        (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]))
        );

        boolean[][] visited = new boolean[N][N];
        pq.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        List<int[]> fishList = new ArrayList<>(); // 먹을 수 있는 물고기 리스트

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], dist = current[2];

            if (map[x][y] > 0 && map[x][y] < sharkSize) {
                fishList.add(new int[]{x, y, dist});
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    pq.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        // 먹을 수 있는 물고기가 하나 이상 존재하면, 최우선 순위 물고기 반환
        if (!fishList.isEmpty()) {
            Collections.sort(fishList, (a, b) ->
                    a[2] != b[2] ? Integer.compare(a[2], b[2]) :
                            (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]))
            );
            return fishList.get(0);
        }

        return null;
    }
}
