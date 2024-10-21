package gold;

import java.io.*;
import java.util.Scanner;

//0행, 0열 시작임.
//0.5 time limit . 2중 for문 X
public class BJ1074 {
    static int count =0;
    public static void main(String[] args)  {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();// N입력받기
        int r = sc.nextInt(); //r 입력
        int c = sc.nextInt(); //c 입력

        int size = (int) Math.pow(2,N);
        findMin(size,r,c);
        System.out.println(count);
    }
    private static void findMin (int size, int r, int c){
        // 0,0 ~ 1,1, 0,0 ~ 3,3 2^n * 2^n
        //00 01 10 11   // n=1
        //00 01 10 11 03 13 04 14 20 21 30 31 22 23 32 33 //n=2
        if(size ==1){
            return;
        }

        if(r< size/2 && c<size/2){
            findMin(size/2,r,c);
        }else if(r<size/2 && c>=size/2){
            count += size * size /4;
            findMin(size/2,r,c-size/2);
        }else if(r>=size/2 && c<size/2){
            count += (size * size /4)*2;
            findMin(size/2,r-size/2,c);
        }else{
            count += (size * size /4)*3;
            findMin(size/2,r-size/2,c-size/2);
        }
    }
}
