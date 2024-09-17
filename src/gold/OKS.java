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

        // N개의 숫자를 저장할 배열 생성
        int[] arr = new int[N];
        int[] nge = new int[N];  // 오큰수를 저장할 배열
        Stack<Integer> stack = new Stack<>();  // 인덱스를 저장할 스택

        // 두 번째 줄에서 수열 입력
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 스택을 이용해 오큰수 구하기
        for (int i = 0; i < N; i++) {
            // 스택이 비어 있지 않고, 현재 수열의 값이 스택에 저장된 인덱스의 값보다 클 때
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.pop()] = arr[i];  // 오큰수를 현재 값으로 설정
            }
            stack.push(i);  // 현재 인덱스를 스택에 추가
        }

        // 스택에 남아있는 인덱스에 대해서는 오큰수가 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            sb.append(nge[i]).append(" ");
        }

        // StringBuilder에 저장된 값 한 번에 출력
        System.out.println(sb.toString().trim());
    }
}
