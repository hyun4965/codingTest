package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 전체 이동 횟수 출력 (2^N - 1)
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        // 이동 과정 처리
        MoveToTower(N, 1, 3, 2);

        // 한 번에 출력
        System.out.println(sb.toString());
    }

    static void MoveToTower(int N, int start, int end, int mid) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append('\n');
            return;
        }

        // 원판 N-1개를 중간 기둥으로 이동
        MoveToTower(N - 1, start, mid, end);

        // N번째 원판을 목표 기둥으로 이동
        sb.append(start).append(" ").append(end).append('\n');

        // 중간 기둥에 있던 N-1개 원판을 목표 기둥으로 이동
        MoveToTower(N - 1, mid, end, start);
    }
}