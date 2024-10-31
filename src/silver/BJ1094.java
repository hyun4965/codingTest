package silver;

import java.util.Scanner;

public class BJ1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        if(X>64){
            System.out.println("다시 입력하세요.");
        }
        //1,2,4,8,16,32,64
        int[] arr = {64,32,16,8,4,2,1};
        int count = 0; //카운트
        int sum = 0;// 합산
        for(int i = 0; i < 7; i++) {
            //원하는 값보다 작은 값들로만 연산한다.
            if(arr[i] <= X) {
                sum += arr[i];
                count++;
            }
            //더했는데 원하는 값보다 길면 빼준다. 뺐기때문에 개수에서도 빼준다.
            if(sum > X) {
                sum -= arr[i];
                count--;
            }
            //같아지면 반복문을 종료하고 개수를 출력한다.
            if(sum == X) {
                break;
            }
        }
        System.out.println(count);
    }
}
