package silver;

import java.util.HashSet;
import java.util.Scanner;

public class BJ3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //배열의 크기
        int[] arr = new int[n]; //수열의수

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt(); //자연수 x
        int count = 0; // 결과

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            int target = x - arr[i];
            if(set.contains(target)){
                count++;
            }
            set.add(arr[i]);
        }
        System.out.println(count);
    }
}
