package silver;

import java.util.*;

public class BJ15664 {
    static int n, m;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        result = new int[m];
        dfs(0,0);
        System.out.println(sb.toString());
    }
    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        int lastUse = -1;
        for(int i=start; i<n; i++){
            if(lastUse == nums[i]){
                continue;
            }
            result[depth] = nums[i];
            lastUse = nums[i];
            dfs(depth+1, i+1);
        }
    }
}
