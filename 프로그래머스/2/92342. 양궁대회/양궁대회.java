import java.util.*;
class Solution {
    
    static int[] answer = new int[11];
    static int[] apeach = new int[11];
    static int[] ryan = new int[11];
    static int maxScore = 0;
    static int N;
    public int[] solution(int n, int[] info) {

        apeach = info;
        N = n;
        backtracking(0,0);
        return maxScore == 0 ? new int[]{-1} : answer;

    }

    public void backtracking(int count, int start){

        if( count == N ){
            int apeach_score = 0;
            int ryan_score = 0;

            for( int i = 0; i < 11; i++ ){
                if( ryan[i] == 0 && apeach[i] == 0 ) {
                    continue;
                }
                if( ryan[i] > apeach[i] ){
                    ryan_score += ( 10 - i );
                } else if( ryan[i] <= apeach[i] ){
                    apeach_score += ( 10 - i );
                }
            }

            if(ryan_score - apeach_score > maxScore){
                maxScore = ryan_score - apeach_score;
                answer = ryan.clone();
            } else if( ryan_score - apeach_score == maxScore){
                for( int i = 10; i > -1 ; i-- ){
                    
                    if( answer[i] < ryan[i] ){
                        answer = ryan.clone();
                        break;
                    }
                    
                    if( answer[i] > ryan[i] ){
                        break;
                    }
                }
            }

            return;

        }


        for( int i = start; i < 11; i++ ){
            if(apeach[i] < ryan[i]) {
                continue;
            }
            ryan[i] ++;
            backtracking(count + 1, i);
            ryan[i]--;
        }

    }
}