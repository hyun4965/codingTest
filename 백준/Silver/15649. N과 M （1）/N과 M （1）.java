import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int n,m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr=new int[m];
        visited =new boolean[n];
        backtrack(0);
    }
    static void backtrack(int depth){
        if(m == depth){
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth]=i+1;
                backtrack(depth+1);
                visited[i] = false;
            }
        }
    }
}
