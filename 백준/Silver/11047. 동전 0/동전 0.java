import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count =0;
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            if((k/num)!=0){
                count+=(k/num);
                k%=num;
            }
        }
        System.out.println(count);
    }
}
