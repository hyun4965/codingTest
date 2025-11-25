package news;

import java.util.Scanner;

public class BJ2563 {
    static boolean[][] visited = new boolean[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();


            for(int j = x; j < x + 10; j++) {
                for(int k = y; k < y + 10; k++) {
                    if (j < 100 && k < 100) {
                        visited[j][k] = true;
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}