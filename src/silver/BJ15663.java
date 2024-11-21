package silver;

import java.util.*;

public class BJ15663 {
    static int N, M;
    static int[] Narr;
    static boolean[] visited;
    static List<Integer> sequence;
    static Set<String> resultSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Narr = new int[N];
        visited = new boolean[N];
        sequence = new ArrayList<>();
        resultSet = new HashSet<>();

        // 입력받기
        for (int i = 0; i < N; i++) {
            Narr[i] = sc.nextInt();
        }

        // 배열 정렬 (사전 순 출력을 위해)
        Arrays.sort(Narr);

        // 백트래킹 시작
        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == M) {
            // 수열이 완성된 경우
            StringBuilder sb = new StringBuilder();
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            String result = sb.toString().trim();

            // 중복 제거 및 출력
            if (!resultSet.contains(result)) {
                resultSet.add(result);
                System.out.println(result);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence.add(Narr[i]);
                backtrack(depth + 1);
                sequence.remove(sequence.size() - 1); // 되돌리기
                visited[i] = false;
            }
        }
    }
}

