package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11657 {
    static int n; //도시의 갯수
    static int m; //버스 노선의 개수
    static ArrayList<Bus> buses; //버스들
    static long[] dist; //방문
    static final long INF = Long.MAX_VALUE; // 벨만포드를 위한 max value

    public static class Bus{
        private int start;
        private int end;
        private int time;
        //time 은 양수가 아닐 수 있다.
        /*
            c = 0 -> 순간이동
            c < 0 -> 시간을 되돌아감
         */

        public Bus(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        buses = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            buses.add(new Bus(start, end, time));
        }

        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        if (bellmanFord()) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb.toString());
        }
    }

    private static boolean bellmanFord() {
        for (int i = 1; i < n; i++) {
            for (Bus bus : buses) {
                if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.time) {
                    dist[bus.end] = dist[bus.start] + bus.time;
                }
            }
        }

        for (Bus bus : buses) {
            if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.time) {
                return true;
            }
        }

        return false;
    }
}
