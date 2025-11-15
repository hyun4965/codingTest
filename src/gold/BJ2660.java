package gold;

import java.util.*;

public class BJ2660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //회원 수
        int[][] arr = new int[n+1][n+1];

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==-1 && b==-1) break;
            arr[a][b]=1;
            arr[b][a]=1;
        }
        int[] score = new int[n+1];
        int minScore = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            int k = bfs(i,arr,n);
            score[i] = k;
            minScore = Math.min(minScore,k);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());
        for (int c : candidates) {
            System.out.print(c + " ");
        }

    }
    public static int bfs(int start,int[][] arr,int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1;i<=n;i++){
                if(arr[cur][i]==1 && dist[i] == -1){
                    dist[i] = dist[cur]+1;
                    q.offer(i);
                }
            }
        }
        int score = 0;
        for(int i=1;i<=n;i++){
            score = Math.max(score,dist[i]);
        }
        return score;
    }
}
