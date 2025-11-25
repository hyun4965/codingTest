package news;

import java.util.Scanner;

public class BJ15651 {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(1,0);
        System.out.println(sb.toString());
    }
    static void dfs(int start,int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=n; i++){
            arr[depth] = i;
            dfs(1,depth+1);
        }
    }
}
