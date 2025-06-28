import java.util.*;

public class Main {
    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        int[] result = new int[N];
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int currHeight = heights[i];

            while (!stack.isEmpty()) {
                if (stack.peek().height >= currHeight) {
                    result[i] = stack.peek().index;
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            }

            stack.push(new Tower(i + 1, currHeight)); // 1-based index
        }

        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
