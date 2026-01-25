package gold;

import java.io.*;
import java.util.*;

public class BJ1253 {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int good = 0;

        for (int k = 0; k < n; k++) {
            int i = 0, j = n - 1;
            long target = arr[k];

            while (i < j) {
                if (i == k) {
                    i++;
                    continue;
                }
                if (j == k) {
                    j--;
                    continue;
                }

                long sum = arr[i] + arr[j];
                if (sum == target) {
                    good++;
                    break;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(good);
    }
}
