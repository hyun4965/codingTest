package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class OKS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄에서 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] nge = new int[N];  // 오큰수를 저장할 배열
        Stack<Integer> stack = new Stack<>();

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 스택을 이용해 오큰수 구하기
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(nge[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
