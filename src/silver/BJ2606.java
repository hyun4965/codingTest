package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ2606 {
    static boolean[] visited; //방문 체크 배열.
    static ArrayList<Integer>[] graph; //DFS 표현할 그래프 배열.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computer_num = sc.nextInt(); //컴퓨터 수
        int num = sc.nextInt(); //컴퓨터 연결 쌍의 수
        int count =0; // 바이러스 걸리는 횟수

        //컴퓨터수는 100이하의 양의 정수
        if(computer_num>100 || computer_num<0) {
            System.out.println("다시 입력하세요~ ^^ ");
            computer_num=sc.nextInt();
        }
        //그래프 생성후 1부터 시작이므로 1추가하고 입력
        graph = new ArrayList[computer_num+1];
        for(int i=1;i<=computer_num;i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[computer_num+1]; //방문 배열 초기화.
        for(int i=0;i<num;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //무방향 그래프이므로 아래와 같이 한다.
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(1);//1시작 인걸 입력.
        for(int i=2;i<=computer_num;i++) {
            if(visited[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
    public static void dfs(int node){
        visited[node]=true;
        for(int next:graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
