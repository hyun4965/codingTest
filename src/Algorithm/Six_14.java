package Algorithm;

public class Six_14 {
    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20};
        int i = 4;

        System.out.println(solution(p, i));
    }
    public static int solution(int[] p, int i) {
        int MaxSell=0;
        if(i==0){
            return 0;
        } else{
            for(int j=1;j<=i;j++){
                MaxSell=Math.max(MaxSell, p[j-1] + solution(p, i - j));
            }
            return MaxSell;
        }
    }
}