import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (pos[idx] == -1) {  // 처음 등장한 경우만 기록
                pos[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(pos[i]);
            if (i < 25) sb.append(' ');
        }

        System.out.println(sb);
    }
}
