package gold;

import java.io.*;
import java.util.*;

public class BJ2042 {

    static int N;
    static long[] tree;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        tree = new long[4 * N];
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 1, N, b, c);
            } else {
                int left = b;
                int right = (int) c;
                long sum = query(1, 1, N, left, right);
                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int node, int start, int end, int idx, long newValue) {
        if (idx < start || end < idx) return;

        if (start == end) {
            arr[idx] = newValue;
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, newValue);
        update(node * 2 + 1, mid + 1, end, idx, newValue);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        long sum1 = query(node * 2, start, mid, left, right);
        long sum2 = query(node * 2 + 1, mid + 1, end, left, right);
        return sum1 + sum2;
    }
}
