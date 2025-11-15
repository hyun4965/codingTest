class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gA = arrayA[0];
        int gB = arrayB[0];

        for(int i=1 ; i<arrayA.length; i++){
            gA = gcd(gA,arrayA[i]);
        }
        for (int i = 1; i < arrayB.length; i++) {
            gB = gcd(gB, arrayB[i]);
        }        
        int answerA = check(gA,arrayB);
        int answerB = check(gB,arrayA);
        
        return Math.max(answerA,answerB);
    }
    private int gcd(int a,int b){
        while(b!=0){
            int c = a%b;
            a=b;
            b=c;
        }
        return a;
    }
    private int check(int g, int[] other) {
        if (g == 0) {
            return 0;
        }
        for (int x : other) {
            if (x % g == 0) {
                return 0; 
            }
        }
        return g;
    }
}