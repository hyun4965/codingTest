package bronze;

import java.util.Scanner;

public class BJ11549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[5];
        int count = 0;


        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if(arr[i]== n){
                count++;
            }
        }
        System.out.println(count);
    }
}
