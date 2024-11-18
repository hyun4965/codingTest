package silver;

import java.util.*;

public class BJ15666 {

    static int N, M;
    static int[] Narr;
    static List<Integer> sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Narr = new int[N];
        sequence = new ArrayList<>();

        // 입력받기
        for (int i = 0; i < N; i++) {
            Narr[i] = sc.nextInt();
        }

        // 배열 정렬 (중복 제거를 위해 TreeSet 사용)
        Set<Integer> uniqueNumbers = new TreeSet<>();
        for (int num : Narr) {
            uniqueNumbers.add(num);
        }
        Narr = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();

        // 백트래킹 시작
        sc.close();
        backtrack(0, 0);
    }

    static void backtrack(int depth, int start) {
        if (depth == M) {
            // 수열이 완성된 경우 출력
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < Narr.length; i++) {
            sequence.add(Narr[i]);
            backtrack(depth + 1, i);
            sequence.remove(sequence.size() - 1);
        }
    }
}
