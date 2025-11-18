
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 이 문제는 항상 테스트케이스가 10개로 고정
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int[] height = new int[N];    

            for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }

            int answer = 0;

            for (int i = 2; i <= N - 3; i++) {
                int left2 = height[i - 2];
                int left1 = height[i - 1];
                int right1 = height[i + 1];
                int right2 = height[i + 2];

                int maxNeighbor = Math.max(Math.max(left2, left1), Math.max(right1, right2));

                if (height[i] > maxNeighbor) {
                    answer += height[i] - maxNeighbor;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
