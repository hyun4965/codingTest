package gold;

import java.io.*;
import java.util.*;

public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine(); // 배열 입력
            Deque<Integer> deque = new LinkedList<>();

            // 배열의 숫자 파싱
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            if (!arrStr.isEmpty()) {
                String[] nums = arrStr.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean errorOccurred = false;

            // 함수 실행
            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        errorOccurred = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (!errorOccurred) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}
