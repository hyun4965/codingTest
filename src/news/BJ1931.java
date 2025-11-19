package news;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //회의의 수
        int[][] time = new int[n][2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            time[i][0] = sc.nextInt(); //시작
            time[i][1] = sc.nextInt(); //끝
        }
        Arrays.sort(time, (a,b)->{
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int endTime = 0;
        for(int i=0; i<n; i++) {
            if(endTime<=time[i][0]) {
                endTime=time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
