package silver;

import java.util.Scanner;

public class FacOfZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result=1;
        int count=0;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        while(true){
            if(result%10==0){
                count++;
                result=result/10;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
}
