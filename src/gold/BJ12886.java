package gold;

import java.util.*;

public class BJ12886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        System.out.println(bfs(A, B, C));
    }
    public static int bfs(int A, int B, int C) {
        int sum = A + B + C;
        // 3으로 나눴을때, 나머지가 없어야 계산함. 아니면 0반환
        if (sum % 3 != 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[]{A, B, C});
        visited.add(A + "," + B + "," + C);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];

            // 종료 조건
            if (x == y && y == z) {
                return 1;
            }

            // 가능한 두 개 그룹을 선택하여 돌을 이동시키는 경우를 고려
            int[][] pairs = {{x, y}, {x, z}, {y, z}};

            for (int[] pair : pairs) {
                int a = pair[0];
                int b = pair[1];
                if (a != b) {
                    // 작은 값이 X, 큰 값이 Y
                    if (a > b) {
                        int temp = a;
                        a = b;
                        b = temp;
                    }

                    int newA = a + a;
                    int newB = b - a;
                    int newC = sum - (newA + newB);

                    // 새로운 상태가 방문한 적 없으면 큐에 추가
                    String state = newA + "," + newB + "," + newC;
                    if (!visited.contains(state)) {
                        queue.add(new int[]{newA, newB, newC});
                        visited.add(state);
                    }
                }
            }
        }

        return 0;
    }
}
