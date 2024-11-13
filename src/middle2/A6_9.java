package middle2;

//O(n^2)
public class A6_9 {
    public static int rodCutting(int[] prices, int n) {
        int[] maxVal = new int[n+1];
        maxVal[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxvalue = 0;
            //{3, 5, 10, 12,14}; // 길이 1, 2, 3, 4, 5의 가격
            for (int j = 1; j <= i; j++) {
                System.out.println("price: " +  prices[j-1] + " maxVal : "+maxVal[i-j]);// maxVal = Maxsell
                maxvalue = Math.max(maxvalue, prices[j-1] + maxVal[i-j]);
                System.out.println("i = " + i + ", j = " + j + ", maxvalue = " + maxvalue);
            }
            maxVal[i] = maxvalue;
            System.out.println(maxVal[i]);
            System.out.println();
        }
        return maxVal[n];
    }

    public static void main(String[] args) {
        int[] prices = {3, 5, 10, 12,14}; // 길이 1, 2, 3, 4, 5의 가격
        int n = 5; // 원하는 막대의 길이
        System.out.println("최대 이익: " + rodCutting(prices, n));
    }
    public static int curRod_DP(int[] p,int n){
        int[] maxSell = new int[n+1];
        maxSell[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                maxSell[j] = Math.max(maxSell[j],maxSell[i-j]+p[i]);
            }
        }
        return maxSell[n];
    }
}

//
//public class RodCutting {
//
//    public static int cutRod_DC(int[] p, int i) {
//        // 기저 사례: 길이가 0인 막대일 때, 판매 금액은 0이다.
//        if (i == 0) {
//            return 0;
//        }
//
//        int maxSell = 0;
//
//        // 길이 j만큼 잘라서 판매하는 경우를 모두 계산하여 최대 판매 금액을 찾는다.
//        for (int j = 1; j <= i; j++) {
//            // p[j-1]은 길이 j에 대한 가격이므로, p 배열 인덱스를 맞추기 위해 j-1로 접근
//            maxSell = Math.max(maxSell, p[j - 1] + cutRod_DC(p, i - j));
//        }
//
//        return maxSell;
//    }
//
//    public static void main(String[] args) {
//        int[] prices = {1, 5, 8, 9}; // 각 길이의 막대에 대한 가격
//        int n = 4; // 막대의 전체 길이
//
//        int maxSellValue = cutRod_DC(prices, n);
//        System.out.println("최대 판매 금액: " + maxSellValue);
//    }
//}
