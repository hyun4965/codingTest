package platinum;

import java.util.*;

public class BJ1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //1~N 숫자
        int M = sc.nextInt(); //가장 긴 증가 부분 수열
        int K = sc.nextInt(); //가장 긴 감소 부분 수열

        if (M + K - 1 > N || M * K < N) {
            System.out.println(-1);
            return;
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            seq.add(i);
        }

        int remaining = N;
        int currentSize = M;

        for (int i = 0; i < M; i++) {
            int size = Math.min(K, remaining - (currentSize - 1));
            List<Integer> sublist = seq.subList(N - remaining, N - remaining + size);
            Collections.reverse(sublist);
            result.addAll(sublist);
            remaining -= size;
            currentSize--;
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
