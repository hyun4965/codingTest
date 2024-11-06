package bronze;

import java.util.Scanner;

public class BJ5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {500,100,50,10,5,1};
        int count = 0;
        int res = 1000-n;

        for(int i = 0; i < arr.length; i++) {
            if(res/arr[i] !=0){
                count +=(res/arr[i]);
                res %= arr[i];
            }
        }
        System.out.println(count);
    }
}
