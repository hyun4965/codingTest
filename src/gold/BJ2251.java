package gold;

import java.util.Scanner;

public class BJ2251 {
    static int A,B, C;
    static boolean[][][] visited;
    static boolean[] possibleC;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[201][201][201];
        possibleC = new boolean[201];
        dfs(0,0,C);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=C; i++){
            if(possibleC[i]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb.toString().trim());
    }
    static void dfs(int a, int b, int c) {
        if(visited[a][b][c]){
            return;
        }
        visited[a][b][c] = true;
        if(a==0){
            possibleC[c] = true;
        }
        if(c>0 && a<A){
            int move = Math.min(c, A-a);
            int na = a+move;
            int nb = b;
            int nc = c-move;
            dfs(na,nb,nc);
        }
        if (c > 0 && b < B) {
            int move = Math.min(c, B - b);
            int na = a;
            int nb = b + move;
            int nc = c - move;
            dfs(na, nb, nc);
        }
        if (b > 0 && a < A) {
            int move = Math.min(b, A - a);
            int na = a + move;
            int nb = b - move;
            int nc = c;
            dfs(na, nb, nc);
        }
        if (b > 0 && c < C) {
            int move = Math.min(b, C - c);
            int na = a;
            int nb = b - move;
            int nc = c + move;
            dfs(na, nb, nc);
        }
        if (a > 0 && b < B) {
            int move = Math.min(a, B - b);
            int na = a - move;
            int nb = b + move;
            int nc = c;
            dfs(na, nb, nc);
        }
        if (a > 0 && c < C) {
            int move = Math.min(a, C - c);
            int na = a - move;
            int nb = b;
            int nc = c + move;
            dfs(na, nb, nc);
        }
    }
}
