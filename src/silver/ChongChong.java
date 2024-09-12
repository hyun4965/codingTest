package silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ChongChong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> s = new HashSet<>();
        s.add("ChongChong");

        for (int i = 0; i < N; i++) {
            String[] meeting = br.readLine().split(" ");
            String A = meeting[0];
            String B = meeting[1];

            if (s.contains(A) || s.contains(B)) {
                s.add(A);
                s.add(B);
            }
        }

        System.out.println(s.size());
    }
}