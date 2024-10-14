package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n갯수 입력
        int n = sc.nextInt();
        //인출하는데 걸리는 시간 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arr);

        int prev = 0;	// 이전까지의 대기시간 누적합
        int sum = 0;	// 사람별 대기시간 총합

        for(int i = 0; i < n; i++) {
            sum += prev + arr[i];
            prev += arr[i];
        }
        System.out.println(sum);
    }
}
