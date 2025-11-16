package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ15665 {
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] arr;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        dfs(0);
        System.out.println(sb.toString());
    }
    public static void dfs(int depth){
        if(depth == m){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        int last = 10001;
        for(int i=0; i<n; i++){
            if(num[i]==last){
                continue;
            }
            arr[depth] = num[i];
            last = num[i];
            dfs(depth+1);
        }
    }
}
