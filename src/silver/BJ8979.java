package silver;

import java.util.Scanner;

public class BJ8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //국가의 수
        int k = sc.nextInt(); //등수를 알고 싶은 국가

        int[][] arr = new int[n][4];
        int k_gold = 0, k_silver = 0, k_bronze = 0;

        for (int i = 0; i < n; i++) {
            int countryId = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            
            arr[i][0] = countryId;
            arr[i][1] = gold;
            arr[i][2] = silver;
            arr[i][3] = bronze;

            if (countryId == k) {
                k_gold = gold;
                k_silver = silver;
                k_bronze = bronze;
            }
        }


        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > k_gold) {
                rank++;
            }
            else if (arr[i][1] == k_gold && arr[i][2] > k_silver) {
                rank++;
            }
            else if (arr[i][1] == k_gold && arr[i][2] == k_silver && arr[i][3] > k_bronze) {
                rank++;
            }
        }

        System.out.println(rank);
    }
}
