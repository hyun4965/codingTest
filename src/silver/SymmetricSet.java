package silver;

import java.util.HashSet;
import java.util.Scanner;

public class SymmetricSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
            B.add(sc.nextInt());
        }
        int A_count=0;
        int B_count=0;

        for (int i : A) {
            if(!B.contains(i)) {
                A_count++;
            }
        }

        for (int i : B) {
            if(!A.contains(i)) {
                B_count++;
            }
        }
        System.out.println(A_count+B_count);
    }
}
