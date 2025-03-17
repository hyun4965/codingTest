package gold;

import java.util.*;

class BJ9019 {
    static class Node {
        int value;
        String path;

        Node(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(bfs(A, B));
        }
    }

    public static String bfs(int A, int B) {
        boolean[] visited = new boolean[10000];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int value = current.value;
            String path = current.path;

            if (value == B) return path;

            // D
            int D = (value * 2) % 10000;
            if (!visited[D]) {
                visited[D] = true;
                queue.add(new Node(D, path + "D"));
            }

            // S
            int S = (value == 0) ? 9999 : value - 1;
            if (!visited[S]) {
                visited[S] = true;
                queue.add(new Node(S, path + "S"));
            }

            // L
            int L = (value % 1000) * 10 + value / 1000;
            if (!visited[L]) {
                visited[L] = true;
                queue.add(new Node(L, path + "L"));
            }

            // R
            int R = (value % 10) * 1000 + value / 10;
            if (!visited[R]) {
                visited[R] = true;
                queue.add(new Node(R, path + "R"));
            }
        }
        return "";
    }

}