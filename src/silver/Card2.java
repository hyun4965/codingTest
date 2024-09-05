package silver;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//
//public class Card2 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Deque<Integer> d = new ArrayDeque<Integer>();
//        int N = Integer.parseInt(br.readLine());
//
//        //N개 입력
//        for (int i = 1; i <= N; i++) {
//            d.addFirst(i);
//        }
//        //1개남을때까지 반복
//        for(int i = 1; i < N; i++){
//            d.pollLast();
//            d.addFirst(d.pollLast());
//        }
//        System.out.println(d.poll());
//    }
//}
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> d = new ArrayDeque<Integer>();

        // 1부터 N까지 카드를 덱에 추가
        for (int i = 1; i <= N; i++) {
            d.addLast(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (d.size() > 1) {
            d.poll();               // 제일 위의 카드를 버림
            d.addLast(d.poll());    // 그 다음 카드를 제일 아래로 이동
        }

        // 마지막 남은 카드 출력
        System.out.println(d.peek());
    }
}