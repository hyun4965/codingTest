package gold;

import java.util.Scanner;

public class BJ2467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //전체 용액의 수
        long[] arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        //결과 저장
        long[] answer = new long[2];
        answer[0] = arr[0];
        answer[1] = arr[n-1];
        long sum = answer[0]+ answer[1];
        int left = 0;
        int right = n - 1;

        while (left < right) {
            long num = arr[left] + arr[right];

            if (Math.abs(num) <= Math.abs(sum)) {
                sum = num;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (num > 0) {
                right--;
            } else {
                left++;
            }

        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
