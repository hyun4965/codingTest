package silver;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[] stack = new int[K]; // 최대 K개의 숫자를 저장할 수 있는 배열
        int top = 0; // 현재 stack의 top을 나타내는 인덱스

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();

            if (n == 0) {
                if (top > 0) {
                    top--; // pop과 동일하게 top을 감소시킴
                }
            } else {
                stack[top] = n; // push와 동일하게 top 위치에 값 저장
                top++; // top을 증가시킴
            }
        }

        int num = 0;
        for (int i = 0; i < top; i++) {
            num += stack[i];
        }
        System.out.println(num);
    }
}