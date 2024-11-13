package silver;

import java.io.*;

public class BJ11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        // 입력을 배열로 저장
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");  // 공백을 기준으로 분리
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);  // 배열에 숫자 저장
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
