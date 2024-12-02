package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int scenario = 1;

        //0입력시 종료
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            //학생 입력 받기.
            String[] students = new String[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = br.readLine();
            }

            HashMap<Integer, Integer> earring = new HashMap<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                String[] input = br.readLine().split(" ");
                int studentNumber = Integer.parseInt(input[0]);

                // 등장 횟수 카운트
                // 있으면 반환 없으면 0 그리고 +1
                earring.put(studentNumber, earring.getOrDefault(studentNumber, 0) + 1);
            }

            // 귀걸이를 받지 못한 학생 찾기
            int missingStudent = 0;
            for (int key : earring.keySet()) {
                if (earring.get(key) % 2 != 0) {
                    missingStudent = key;
                    break;
                }
            }

            sb.append(scenario).append(" ").append(students[missingStudent]).append("\n");
            scenario++;
        }

        System.out.print(sb);
    }
}
