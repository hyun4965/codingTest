package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //물이 새는 곳 갯수
        int l = sc.nextInt(); //테이프 길이 무제한 갯수
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;
        int covered = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > covered) {
                count++;
                covered = arr[i] + l - 1;
            }
        }
        System.out.println(count);
    }
}
