package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GomGomE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set.clear();
            } else {
                if (!set.contains(s)) {
                    count++;
                    set.add(s);
                }
            }
        }

        System.out.println(count);
    }
}
