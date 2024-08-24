package silver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Deck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = sc.next();

            switch (command) {
                case "push_back":
                    int x = sc.nextInt();
                    deck.addLast(x);  // 덱의 뒤에 값을 추가
                    break;

                case "push_front":
                    int y = sc.nextInt();
                    deck.addFirst(y);  // 덱의 앞에 값을 추가
                    break;

                case "pop_front":
                    if (deck.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deck.pollFirst());  // 덱의 앞에서 값을 제거하고 출력
                    }
                    break;

                case "pop_back":
                    if (deck.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deck.pollLast());  // 덱의 뒤에서 값을 제거하고 출력
                    }
                    break;

                case "size":
                    System.out.println(deck.size());  // 덱의 크기를 출력
                    break;

                case "empty":
                    if (deck.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "front":
                    if (deck.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deck.peekFirst());  // 덱의 앞의 값을 출력
                    }
                    break;

                case "back":
                    if (deck.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deck.peekLast());  // 덱의 뒤의 값을 출력
                    }
                    break;
            }
        }
    }
}