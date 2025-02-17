package gold;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BJ13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//수빈이 위치
        int K = sc.nextInt();//동생의 위치

        /*
            걷거나 순간이동
            걷기 : 현재위치 +-1       1초
            순간이동: 현재위치 * 2     0초
         */
        System.out.println(bfs(N, K));

    }
    public static int bfs(int N, int K) {
        int MAX = 100000; // 최대 좌표값
        int[] time = new int[MAX + 1];
        Arrays.fill(time,Integer.MAX_VALUE);
        Deque<Integer> deque = new ArrayDeque<>();

        time[N]=0;
        deque.addFirst(N);
        while(!deque.isEmpty()) {
            int now = deque.poll();
            if(now==K){
                return time[now];
            }
            // 순간이동 (0초) → 덱 앞쪽에 추가
            if (now * 2 <= MAX && time[now * 2] > time[now]) {
                time[now * 2] = time[now];
                deque.addFirst(now * 2);
            }

            // 걷기 (1초) → 덱 뒤쪽에 추가
            if (now + 1 <= MAX && time[now + 1] > time[now] + 1) {
                time[now + 1] = time[now] + 1;
                deque.addLast(now + 1);
            }

            if (now - 1 >= 0 && time[now - 1] > time[now] + 1) {
                time[now - 1] = time[now] + 1;
                deque.addLast(now - 1);
            }
        }
        return -1;
    }
}
