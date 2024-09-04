package silver;

import java.util.Scanner;

public class Stack2 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        stack = new int[N];
        for(int i = 0; i < N; i++) {

            String str = sc.next();

            switch (str) {

                case "1":
                    push(sc.nextInt());
                    break;

                case "2":
                    sb.append(pop()).append('\n');
                    break;

                case "3":
                    sb.append(size()).append('\n');
                    break;

                case "4":
                    sb.append(empty()).append('\n');
                    break;

                case "5":
                    sb.append(top()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }
}
