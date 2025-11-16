package silver;

import java.util.Scanner;

public class BJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int start=0, end=0;
        int sum=0, count =0;
        while(start<=N) {
            while(++end<=N) {
                sum += end;
                if(sum>=N) {
                    if(sum==N) count++;
                    break;
                }
            }
            while(++start<=N) {
                sum -= start;
                if(sum<=N) {
                    if(sum==N) count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
