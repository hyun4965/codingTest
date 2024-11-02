package middle2;

//O(n^2)
public class A6_9 {
    public static int rodCutting(int[] prices, int n) {
        int[] dp = new int[n + 1];

        // 길이 1부터 n까지 최대 이익 계산
        for (int i = 1; i <= n; i++) {
            int maxProfit = 0;
            for (int j = 1; j <= i; j++) {
                //maxProfit과 prices[j -1] 과 dp [ i - j ] 계산
                //prices [j-1] 하는 이유는 배열 시작 0이기 때문에
                maxProfit = Math.max(maxProfit, prices[j - 1] + dp[i - j]);
                System.out.println("i = "+ i+"  j= "+j+"  max = " + maxProfit);
            }
            dp[i] = maxProfit;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {2, 5, 9, 10}; // 길이 1, 2, 3, 4의 가격
        int n = 4; // 원하는 막대의 길이
        System.out.println("최대 이익: " + rodCutting(prices, n));
    }
}
