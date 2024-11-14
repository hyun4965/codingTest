package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 (집의 개수 N, 공유기 개수 C)
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        // 두 번째 줄부터 N개의 집 좌표 입력
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 좌표 정렬
        Arrays.sort(houses);

        // 이분 탐색
        int low = 1; // 최소 거리
        int high = houses[N - 1] - houses[0]; // 최대 거리
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2; //이분탐색 준비
            if (possible(houses, C, mid)) {
                result = mid; // 가능
                low = mid + 1; // 더 큰 거리
            } else {
                high = mid - 1; // 더 작은
            }
        }
        System.out.println(result);
    }

    // 공유기 설치 가능 여부 확인
    private static boolean possible(int[] houses, int C, int distance) {
        int count = 1; // 첫 번째 집에 공유기 설치
        int last = houses[0]; // 마지막으로 설치된 공유기 위치

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - last >= distance) {
                count++;
                last = houses[i]; // 공유기 설치
                if (count >= C) {
                    return true; // 필요한 공유기 개수만큼 설치 완료
                }
            }
        }
        return false; // 공유기 부족
    }
}
