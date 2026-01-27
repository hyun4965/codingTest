package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray(); // 본문
        char[] p = br.readLine().toCharArray(); // 패턴

        int n = s.length; //본문의 길이
        int m = p.length; //패턴의 길이

        int[] pi = buildPi(p);

        List<Integer> list = new ArrayList<>();
        int j = 0;

        //kmp
        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }

            if (s[i] == p[j]) {
                j++;
                if (j == m) {
                    list.add(i - m + 2);
                    j = pi[j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i + 1 < list.size()) {
                sb.append(' ');
            }
        }
        System.out.print(sb.toString());


    }
    static int[] buildPi(char[] p) {
        int m = p.length;
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
