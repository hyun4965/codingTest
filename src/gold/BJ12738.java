package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class BJ12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        ArrayList<Integer> lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        if (N > 0) {
            lis.add(sequence[0]);
        }

        for (int i = 1; i < N; i++) {
            int num = sequence[i];
            if (num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                int pos = Collections.binarySearch(lis, num);
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                lis.set(pos, num);
            }
        }

        System.out.println(lis.size());
    }
}
