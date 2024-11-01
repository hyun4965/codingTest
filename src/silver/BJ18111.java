package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = 0;

        // 입력값 처리 및 높이 범위 파악
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                land[i][j] = height;
                minHeight = Math.min(minHeight, height);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int optimalHeight = 0;

        // 가능한 모든 목표 높이를 순회하며 최소 시간 계산
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int height = land[i][j] - targetHeight;

                    if (height > 0) { // 블록을 제거하는 경우
                        time += height * 2;
                        inventory += height;
                    } else if (height < 0) { // 블록을 추가하는 경우
                        time -= height; // heightDiff가 음수이므로 양수로 변환하여 더함
                        inventory += height;
                    }
                }
            }

            // 인벤토리가 0 이상이어야 목표 높이로 만들 수 있음
            if (inventory >= 0 && time <= minTime) {
                minTime = time;
                optimalHeight = targetHeight;
            }
        }

        System.out.println(minTime + " " + optimalHeight);
    }
}
