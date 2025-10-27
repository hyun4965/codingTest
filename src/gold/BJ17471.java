package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17471 {

    static int n,min;
    static int[] people;
    static boolean[] check;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();//간선표시
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        people = new int[n];
        arr = new int[n+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            people[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<Integer>());

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++)
                list.get(i).add(Integer.parseInt(st.nextToken()));
        }

        //선거구 조합
        back(1);
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    //선거구 조합, depth: 지역을 몇개 사용했는지 나타내줄 변수
    //1부터 시작하는 이유는 arr의 크기를 인덱스와 지역번호를 맞추기 위해 n+1로 했기때문.
    public static void back(int depth) {
        //모든 지역에 선거구가 정해졌을때
        if(depth==n+1) {
            check = new boolean[n+1];
            int a=0, b=0;//a:1번 선거구 총 인구수, b:0번 선거구 총 인구수
            for(int i=0; i<n; i++) {
                if(arr[i+1]==1) a+=people[i];
                else b+=people[i];
            }

            //cnt는 연결된 선거구를 나타냄.
            //즉, 선거구가 2개로 잘 분할됐는지 확인하기 위한 변수임.
            int cnt=0;
            //bfs돌리면서 지역들을 연결시킴.
            //예를들어, 문제에서 처럼 1:{1,2,3,4}, 0:{5,6} 이라면
            //i==1에서 1,2,3,4가 연결됨. 이후 i==5에선 6으로 연결된 간선이 없기 때문에
            //i==6일때 link함수가 한번더 실행됨. 그래서 cnt==3이 돼서 불가능한 선거구가 되는것임.
            for(int i=1; i<=n; i++) {
                if(check[i]) continue;
                link(i,arr[i]);//지역 연결 시키기(bfs)
                cnt++;
            }

            //선거구가 2개 나왔을때 인구수 차이 계산.
            if(cnt==2) min = Math.min(min, Math.abs(a-b));
            return;
        }

        //먼저 1번선거구 부터 지역 뽑음.
        arr[depth] = 1;
        back(depth+1);

        //1번 선거구를 depth지역까지 다뽑으면 하나씩 줄이면서 0번선거구 지역 뽑기.
        arr[depth] = 0;
        back(depth+1);
    }

    //num:지역, local:선거구(1or0)
    public static void link(int num, int local) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);
        check[num] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            //현재 지역과 연결된 다음 지역들 탐색
            for(int next:list.get(cur)) {
                //현재 지역의 선거구와 다음 지역의 선거구가 같을때 방문처리.
                if(arr[next]==local && !check[next]) {
                    check[next]=true;
                    q.add(next);
                }
            }
        }
    }
}