package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //용액의 수
        long[] arr = new long[n];// 용액의 특성값

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        /*
            1초. for문 1개로 끝내야함
         */
        long minAbsSum = Long.MAX_VALUE;
        long ansLeft = 0;
        long ansRight = 0;
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            long currentSum = arr[left] + arr[right];

            if (Math.abs(currentSum) < minAbsSum) {
                minAbsSum = Math.abs(currentSum);
                ansLeft = arr[left];
                ansRight = arr[right];
            }

            if (currentSum == 0) {
                break;
            } else if (currentSum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.print(ansLeft + " " + ansRight);
    }
}