import java.io.*;
import java.util.*;

public class Main {

    static class Doc {
        int index, pr;
        Doc(int idx, int pr) {
            this.index = idx;
            this.pr = pr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] cnt = new int[10]; 
            ArrayDeque<Doc> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.addLast(new Doc(i, p));
                cnt[p]++;
            }

            int currentMax = 9;
            while (currentMax >= 1 && cnt[currentMax] == 0) currentMax--;

            int printed = 0;

            while (!q.isEmpty()) {
                Doc cur = q.pollFirst();

                if (cur.pr == currentMax) {
                    printed++;
                    cnt[currentMax]--;

                    if (cur.index == M) {
                        out.append(printed).append('\n');
                        break;
                    }

                    while (currentMax >= 1 && cnt[currentMax] == 0) currentMax--;
                } else {
                    q.addLast(cur);
                }
            }
        }

        System.out.print(out.toString());
    }
}
