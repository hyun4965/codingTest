/////////////////////////////////////////////////////////////////////////////////////////////
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
import java.util.HashSet;


class Solution {

    static int maxValue;              // 최댓값 저장
    static int swapCount;             // 교환 횟수 K
    static HashSet<String>[] visited; // depth별 방문 상태

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            String number = sc.next();   // 숫자판 정보 (문자열로 받기)
            swapCount = sc.nextInt();    // 교환 횟수

            maxValue = 0;
            visited = new HashSet[swapCount + 1];
            for (int i = 0; i <= swapCount; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(number, 0);

            System.out.println("#" + test_case + " " + maxValue);
        }

        sc.close();
    }

    private static void dfs(String s, int depth) {
        // 교환을 swapCount번 모두 사용한 경우
        if (depth == swapCount) {
            int value = Integer.parseInt(s);
            if (value > maxValue) {
                maxValue = value;
            }
            return;
        }

        // 이 depth에서 이 상태를 이미 방문했으면 더 진행할 필요 없음
        if (visited[depth].contains(s)) {
            return;
        }
        visited[depth].add(s);

        int len = s.length();
        char[] arr = s.toCharArray();

        // i, j 두 인덱스를 골라 자리 교환
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 자리 교환
                swap(arr, i, j);
                dfs(new String(arr), depth + 1);
                // 원상 복구
                swap(arr, i, j);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
