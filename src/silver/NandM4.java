package silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM4 {
    static int n, m;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]); // N 입력
        m = Integer.parseInt(inputs[1]); // M 입력
        seq = new int[m];
        def(0, 1);
        System.out.print(sb.toString());
    }

    public static void def(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            seq[depth] = i;
            def(depth + 1, i);
        }
    }
}
