package news;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ12015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();

        for(int i =0; i < n; i++){
            int num = arr[i];
            if(list.isEmpty() || num > list.get(list.size()-1)){
                list.add(num);
            }else{
                int index = Collections.binarySearch(list, num);
                if(index < 0){
                    index = -index - 1;
                }
                list.set(index, num);
            }
        }
        System.out.println(list.size());
    }
}
