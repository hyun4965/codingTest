package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class TrivialDivisor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[N];

        for (int i=0;i<N;i++){
            int b=sc.nextInt();
            num[i]=b;
        }
        //정렬
        Arrays.sort(num);
        System.out.println(num[0]*num[N-1]);
    }
}