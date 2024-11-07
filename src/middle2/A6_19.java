package middle2;

public class A6_19 {
    public static void main(String[] args) {
        int[] p = {3,5,10,12,14};
        int[] maxSell = new int[p.length+1];
        maxSell[0] = 0;

        for(int i=1;i<=p.length;i++){
            int maxVal=0;
            for(int j=1; j<=i;j++){
                maxVal = Math.max(maxVal,maxSell[i-j]+p[j-1]);
            }
            maxSell[i] = maxVal;
        }
        System.out.println(maxSell[p.length]);
    }
}