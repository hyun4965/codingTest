package platinum;

import java.util.Scanner;

public class BJ11868 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int num = arr[0];
        for (int i = 1; i < n; i++) {
            num^=arr[i];
        }
        if(num == 0){
            System.out.println("cubelover");
        }else{
            System.out.println("koosaga");
        }
    }
}
