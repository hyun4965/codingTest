package silver;

import java.util.Scanner;

public class BJ2630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tree = new int[N];
        int maxHeight = 0;
        for(int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if(tree[i] > maxHeight) {
                maxHeight = tree[i];
            }
        }
        int result = binarySearch(tree,N,M,maxHeight);

        System.out.println(result);

    }
    public static int binarySearch(int[] tree, int start, int end, int  maxHeight) {
        int left = 0;
        int right = maxHeight;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for (int i : tree) {
                if(i > mid) {
                    total += i-mid;
                }
            }
            if(total >=end){
                result = mid;
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return result;
    }
}
