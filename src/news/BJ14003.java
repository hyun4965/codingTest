package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BJ14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] idxAtLen = new int[n+1];
        int[] parent = new int[n+1];

        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            long num = arr[i];
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                parent[i] = (list.isEmpty()) ? -1 : idxAtLen[list.size() - 1];

                list.add(num);
                idxAtLen[list.size() - 1] = i;

            } else {
                int index = Collections.binarySearch(list, num);
                if (index < 0) {
                    index = -index - 1;
                }

                parent[i] = (index == 0) ? -1 : idxAtLen[index - 1];

                list.set(index, num);
                idxAtLen[index] = i;
            }
        }
        System.out.println(list.size());

        int len = list.size();
        long[] answer = new long[len];

        int cur = idxAtLen[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = arr[cur];
            cur = parent[cur];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
