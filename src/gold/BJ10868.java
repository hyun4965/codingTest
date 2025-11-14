package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10868 {
    static long[] tree;
    static int N, leafStart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(N) / Math.log(2));
        leafStart = 1 << k;
        int size = 2 * leafStart;
        tree = new long[size];

        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static long min(int start, int end) {
        start = leafStart + start - 1;
        end = leafStart + end - 1;
        long minValue = Long.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) minValue = Math.min(tree[start++], minValue);
            if (end % 2 == 0) minValue = Math.min(tree[end--], minValue);
            start /= 2;
            end /= 2;
        }

        return minValue;
    }
}