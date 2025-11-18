package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //max =12

        int[] index = new int[max + 1];
        Arrays.fill(index, -1);

        for (int i = 0; i < n; i++) {
            index[arr[i]] = i;
        }

        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            for (int m = x * 2; m <= max; m += x) {
                int j = index[m];
                if (j != -1) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(score[i]).append(' ');
        }
        System.out.println(sb);
    }
}
