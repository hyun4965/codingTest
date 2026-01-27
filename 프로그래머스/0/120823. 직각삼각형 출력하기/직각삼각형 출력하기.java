import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                answer.append('*');
            }
            answer.append('\n');
        }

        System.out.println(answer.toString());
    }
}