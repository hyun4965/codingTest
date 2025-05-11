package gold;

import java.util.Scanner;

public class BJ1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //배열 갯수
        int S = sc.nextInt(); //넘어야할 수

        //배열 입력
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minLen = Integer.MAX_VALUE; //후보
        int sum = 0; //현재 구간 합
        int start = 0; //시작

        for (int end = 0; end < N; end++) {
            sum += arr[end];


            while (sum >= S) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start++];
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
