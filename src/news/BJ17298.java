package news;

import java.util.Scanner;
import java.util.Stack;

public class BJ17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] seq = new int[n];
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
            ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                ans[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int val : ans) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}