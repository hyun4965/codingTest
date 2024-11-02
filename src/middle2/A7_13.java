package middle2;

public class A7_13 {
    public static int coinChange(int[] d, int m, int n) {
        int count = 0; // 동전 개수 초기화
        int i = 0; // 동전 종류 인덱스 초기화

        while (n > 0 && i < m) {
            count += n / d[i]; // 가장 큰 동전을 최대한 사용
            n %= d[i]; // 남은 거스름돈 계산
            i++; // 다음 동전 종류로 이동
        }

        return count; // 최소 동전 개수 반환
    }

    public static void main(String[] args) {
        int[] d = {500, 100, 10, 5, 1}; // 동전 종류
        int m = d.length; // 동전 종류의 수
        int n = 2738; // 거스름돈

        int result = coinChange(d, m, n);
        System.out.println("최소 동전 개수: " + result);
    }
}
