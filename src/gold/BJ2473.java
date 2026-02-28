package gold;

import java.io.*;
import java.util.*;

public class BJ2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long bestAbs = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0, ans3 = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long abs = Math.abs(sum);

                if (abs < bestAbs) {
                    bestAbs = abs;
                    ans1 = arr[i];
                    ans2 = arr[left];
                    ans3 = arr[right];
                }

                if(sum == 0){
                    System.out.println(ans1 + " " + ans2 + " " + ans3);
                    return;
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }
}
