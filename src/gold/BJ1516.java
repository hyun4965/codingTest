package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        int[] buildTime = new int[N + 1];
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int prereq = Integer.parseInt(st.nextToken());
                if (prereq == -1) {
                    break;
                }
                list.get(prereq).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : list.get(current)) {
                result[next] = Math.max(result[next], result[current] + buildTime[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}