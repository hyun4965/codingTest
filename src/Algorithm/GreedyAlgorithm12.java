package Algorithm;

public class GreedyAlgorithm12 {
    public static void main(String[] args) {
        // 액면가 배열, 인덱스 1부터 사용 (0번 인덱스는 무시)
        int[] denominations = {0, 500, 100, 50, 10, 5, 1}; // 예: 500원, 100원, 50원, 10원, 5원, 1원
        int m = 6; // 동전의 종류 수 (500, 100, 50, 10, 5, 1)

        // 거스름돈 예시
        int change1 = 1260;
        int change2 = 789;
        int change3 = 34;

        // 결과 출력
        System.out.println("1260원을 거슬러 주는 동전의 수: " + coinChange(denominations, m, change1));
        System.out.println("789원을 거슬러 주는 동전의 수: " + coinChange(denominations, m, change2));
        System.out.println("34원을 거슬러 주는 동전의 수: " + coinChange(denominations, m, change3));
    }
    private static int coinChange(int[] d,int m,int n){
        /*
            m은 다른 동전의 수
            d는 액면가 저장 배열
            n거스름돈
         */

        int count=0;
        int i=1;
        while(n>0 && i<=m){
            count +=n/d[i];
            n%=d[i];
            i++;
        }
        return count;
    }
}
