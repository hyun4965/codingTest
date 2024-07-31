package silver;
//     18870번 백준 Java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        int[] arrSort = new int[N];
        HashMap<Integer, Integer> RankMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            arrSort[i] = arr[i];
        }
        Arrays.sort(arrSort);

        int rank = 0;

        for(int value : arrSort){
            if(!RankMap.containsKey(value)){
                RankMap.put(value,rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int value : arr){
            sb.append(RankMap.get(value)).append(' ');
        }

        System.out.println(sb);
        sc.close();
    }
}