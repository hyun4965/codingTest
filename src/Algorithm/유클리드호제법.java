package Algorithm;

public class 유클리드호제법 {
    public static void main(String[] args) {
        int a=0,b=0;
        //최대
        int gcd = gcd(a, b);
        ///최소
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법을 이용한 최대공약수(GCD) 함수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
