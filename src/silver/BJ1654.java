package silver;

import java.util.Scanner;

public class BJ1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //랜선의 갯수
        int k = sc.nextInt();
        //필요한 랜선의 갯수
        int n = sc.nextInt();

        int[] arr = new int[k];

        //배열 입력받기.
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        
        //결과
        long result = 0;
        //시작
        long left = 1;
        //끝
        long right = 0;

        // 최대 길이 계산
        for (int i = 0; i < k; i++) {
            right = Math.max(right, arr[i]);
        }
        
        while (left <= right) {
            long mid = (left + right) / 2;
            if (checking(arr, mid, n)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
    public static boolean checking(int[] arr, long length, int n) {
        long count =0;
        for (int i : arr) {
            count+=i/length;
        }
        return count >=n;
    }

}
