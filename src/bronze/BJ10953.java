package bronze;

import java.io.*;

public class BJ10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(",");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            sb.append(A + B).append("\n");
        }

        System.out.print(sb);
    }
}