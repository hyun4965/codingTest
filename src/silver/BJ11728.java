package silver;

import java.util.Scanner;

public class BJ11728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A =new int[N];
        int[] B =new int[M];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < M; i++){
            B[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (A[i] < B[j]) {
                sb.append(A[i++]).append(" ");
            } else {
                sb.append(B[j++]).append(" ");
            }
        }

        // 남아있는 원소 추가
        while (i < N) {
            sb.append(A[i++]).append(" ");
        }
        while (j < M) {
            sb.append(B[j++]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
