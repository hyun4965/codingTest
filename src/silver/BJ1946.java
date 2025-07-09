package silver;

import java.io.*;
import java.util.*;

public class BJ1946 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int minInterview = applicants[0][1];

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < minInterview) {
                    count++;
                    minInterview = applicants[i][1];
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
