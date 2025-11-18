package news;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num < X){
                list.add(num);
            }
        }
        for (int s : list){
            System.out.print(s+ " ");
        }
    }
}
