package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2357 {

    static int N, M;
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        initMin(1, 1, N);
        initMax(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int minVal = findMin(1, 1, N, a, b);
            int maxVal = findMax(1, 1, N, a, b);
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static int initMin(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(initMin(node * 2, start, mid), initMin(node * 2 + 1, mid + 1, end));
    }

    private static int initMax(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(initMax(node * 2, start, mid), initMax(node * 2 + 1, mid + 1, end));
    }

    private static int findMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(findMin(node * 2, start, mid, left, right), findMin(node * 2 + 1, mid + 1, end, left, right));
    }

    private static int findMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(findMax(node * 2, start, mid, left, right), findMax(node * 2 + 1, mid + 1, end, left, right));
    }
}