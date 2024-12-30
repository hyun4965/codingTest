package silver;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(8,4,7));
    }

    public static int solution(int n, int a, int b){
        int answer = 1;
        int[] fight = new int[n+1];
        fight[0] = 0;
        for(int i = 1; i <= n; i++){
            fight[i] = i;
        }
        while(true) {
            if (a==b) {
                return answer;
            }
            a/=2;
            b/=2;
            answer++;
        }
    }
}