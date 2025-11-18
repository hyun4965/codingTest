package silver;

import java.util.*;

public class BJ1138 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n =scan.nextInt();
        int[] rank = new int[n +1];
        for(int i = 1; i< n +1; i++) {
            rank[i]=scan.nextInt();
        }

        List<Integer> line=new ArrayList<>();
        for(int i = n; i>=1; i--) {
            line.add(rank[i],i);
        }

        for(Integer e: line)
            System.out.println(e);
    }
}