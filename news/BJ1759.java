import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {

    private static int L, C;
    private static char[] chars;
    private static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        generate(0, 0);
    }

    private static void generate(int length, int start) {
        if (length == L) {
            if (isValid()) {
                System.out.println(new String(code));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[length] = chars[i];
            generate(length + 1, i + 1);
        }
    }

    private static boolean isValid() {
        int vowels = 0;
        int consonants = 0;
        for (char x : code) {
            if (isVowel(x)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels >= 1 && consonants >= 2;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
