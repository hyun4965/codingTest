package silver;

import java.util.*;

public class BJ2529 {
    static int k;
    static char[] operators;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        operators = new char[k];

        for (int i = 0; i < k; i++) {
            operators[i] = sc.next().charAt(0);
        }

        backtrack("", 0);

        Collections.sort(results);
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    public static void backtrack(String current, int depth) {
        if (depth == k + 1) {
            results.add(current);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(current.charAt(depth - 1) - '0', i, operators[depth - 1])) {
                    visited[i] = true;
                    backtrack(current + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean isValid(int prev, int next, char operator) {
        if (operator == '<') return prev < next;
        if (operator == '>') return prev > next;
        return false;
    }
}
