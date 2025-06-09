package silver;

import java.util.*;

public class BJ1015 {
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value == other.value) {
                return this.index - other.index;
            }
            return this.value - other.value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] A = new Pair[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Pair(sc.nextInt(), i);
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            P[A[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}