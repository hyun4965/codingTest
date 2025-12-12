import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long d = y - x; 
            long n = (long) Math.sqrt(d);

            long result;
            if (d == n * n) {
                result = 2 * n - 1;
            } else if (d <= n * n + n) {
                result = 2 * n;
            } else {
                result = 2 * n + 1;
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());
    }
}
