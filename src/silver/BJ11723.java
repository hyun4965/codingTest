package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitSet = 0; // 비트마스크로 집합을 관리할 변수

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet |= (1 << x); // x번째 비트를 1로 설정

            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet &= ~(1 << x); // x번째 비트를 0으로 설정

            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if ((bitSet & (1 << x)) != 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet ^= (1 << x); // x번째 비트를 토글

            } else if (command.equals("all")) {
                bitSet = (1 << 21) - 1; // {1, 2, ..., 20}을 모두 추가

            } else if (command.equals("empty")) {
                bitSet = 0; // 공집합으로 설정
            }
        }

        System.out.print(sb.toString());
    }
}
