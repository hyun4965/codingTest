package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PoppingBalloons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> d = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            d.add(new int[]{i + 1, value});  // {풍선 번호, 안에 적힌 값}
        }

        int[] currentBalloon = d.pollFirst();  // 첫 번째 풍선 꺼내기
        sb.append(currentBalloon[0]).append(" ");  // 풍선 번호를 StringBuilder에 추가

        while (!d.isEmpty()) {
            int steps = currentBalloon[1];  // 풍선 안에 적힌 값을 기준으로 이동
            if (steps > 0) {
                // 양수인 경우 오른쪽(시계방향)으로 이동
                for (int i = 0; i < steps - 1; i++) {
                    d.addLast(d.pollFirst());  // 오른쪽으로 회전
                }
            } else {
                // 음수인 경우 왼쪽(반시계방향)으로 이동
                for (int i = 0; i < -steps; i++) {
                    d.addFirst(d.pollLast());  // 왼쪽으로 회전
                }
            }
            currentBalloon = d.pollFirst();
            sb.append(currentBalloon[0]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}