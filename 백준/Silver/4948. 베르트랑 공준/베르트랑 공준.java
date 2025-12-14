import java.util.Scanner;

public class Main {

    public static final int MAX = 123456 * 2;
    public static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getPrime();
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;

            int count = 0;
            for(int i = n + 1; i <= 2 * n; i++) {
                if(isPrime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static void getPrime() {
        for(int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(MAX); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}