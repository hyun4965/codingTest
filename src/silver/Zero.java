package silver;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();

            if(n==0){
                stack.pop();
            }else{
                stack.push(n);
            }
        }
        int num=0;
        for (Integer integer : stack) {
            num+=integer;
        }
        System.out.println(num);
    }
}
