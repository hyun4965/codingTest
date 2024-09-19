package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ODKS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //N갯수 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ngf = new int[N];
        int[] freq = new int[1000001]; // 등장 횟수 저장 배열 (Ai의 범위가 1 <= Ai <= 1,000,000)
        Stack<Integer> stack = new Stack<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            freq[arr[i]]++; // 각 숫자의 등장 횟수 기록
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
                ngf[stack.pop()] = arr[i]; // 오등큰수 설정
            }
            stack.push(i); // 인덱스를 스택에 넣음
        }
        while (!stack.isEmpty()) {
            ngf[stack.pop()] = -1;
        }
        //출력
        for (int i = 0; i < N; i++) {
            sb.append(ngf[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
