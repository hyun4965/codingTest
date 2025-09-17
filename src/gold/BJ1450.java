package gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
    1개~ for 1
    2개~ for 2
    C개.. for C?

    Time Limit = 1 ..
    반복문 1개 .. for Or while

 */
public class BJ1450 {
    static int n;
    static long c;
    static int[] bag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // N개의 물건
        c = sc.nextLong(); // 가방 용량 입력
        bag = new int[n];
        for (int i = 0; i < n; i++) {
            bag[i] = sc.nextInt();
        }
        ArrayList<Long> left = new ArrayList<>();
        ArrayList<Long> right = new ArrayList<>();

        dfs(0, n / 2 - 1, 0L, left);
        dfs(n / 2, n - 1, 0L, right);

        Collections.sort(left);
        Collections.sort(right);

        long ans = 0L;
        int e = right.size() - 1;
        for (Long num : left) {
            while (e >= 0 && num + right.get(e) > c)
                e--;
            ans += (e + 1L);
        }

        System.out.println(ans);



    }
    static void dfs(int start, int end, long sum, ArrayList<Long> list ) {
        if(sum > c){
            return;
        }
        if(start > end){
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum, list);
        dfs(start+1, end, sum + bag[start], list);
    }
}
