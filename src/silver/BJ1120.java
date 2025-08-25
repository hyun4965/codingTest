package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int n = A.length();
        int m = B.length();
        int minDiff = Integer.MAX_VALUE;

        for (int offset = 0; offset <= m - n; offset++) {
            int diff = 0;
            for (int i = 0; i < n; i++) {
                if (A.charAt(i) != B.charAt(offset + i)) diff++;
            }
            if (diff < minDiff) minDiff = diff;
        }

        System.out.println(minDiff);
    }
}
