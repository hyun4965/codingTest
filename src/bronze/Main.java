package bronze;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(" + ");
        sb.append(b);
        System.out.println(sb.toString()+" = " +(a + b));
    }

//    public static int solution(int num, int k) {
//        int answer = 0;
//
//        String numStr = String.valueOf(num);
//        String kStr = String.valueOf(k);
//        for(int i = 0; i < numStr.length(); i++){
//            if(numStr.charAt(i) ==kStr.charAt(0)){
//                return i+1;
//            }
//        }
//        return -1;
//    }
}

