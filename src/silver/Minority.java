package silver;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Minority {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        for(int i = 0; i < n; i++) {
//            long num = Long.parseLong(br.readLine());
//
//            if(num == 0 || num == 1 || num == 2) {
//                System.out.println(2);
//                continue;
//            }
//
//            while(true) {
//                boolean isBreak = true;
//                double d = Math.sqrt((double)num);
//                for(long j = 2; j <= d; j++) {
//                    if(num % j == 0) {
//                        isBreak = false;
//                        break;
//                    }
//                }
//                if(isBreak) {
//                    System.out.println(num);
//                    break;
//                }
//                num++;
//            }
//        }
//    }
//}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Minority {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            long num = Long.parseLong(br.readLine());

            // BigInteger를 사용하여 가장 가까운 소수를 찾는다.
            BigInteger bigNum = BigInteger.valueOf(num);
            BigInteger nextPrime = bigNum.isProbablePrime(10) ? bigNum : bigNum.nextProbablePrime();

            System.out.println(nextPrime);
        }
    }
}