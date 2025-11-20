import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum= 0;
        int answer =0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            int num = arr[i];
            answer+=(num+sum);
            sum+=num;
        }
        System.out.println(answer);
    }
}
