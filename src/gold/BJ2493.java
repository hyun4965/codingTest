package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int curHeight = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < curHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(i, curHeight));
        }

        System.out.println(sb.toString().trim());
    }
}
