package silver;
import java.io.*;
import java.util.*;

    public class PocketMon {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<Integer, String> poketArray_String = new HashMap<>(); //value가 숫자인
            HashMap<String, Integer> pocketArray_int = new HashMap<>(); //value가 문자열

            for(int i = 1; i <= N; i++){
                String str = br.readLine();
                //두번 다 넣어줘야한다.
                poketArray_String.put(i, str);
                pocketArray_int.put(str, i);
            }

            for(int i = 0; i < M; i++){
                String pocket = br.readLine();
                if(isNum(pocket)){ //숫자이면
                    bw.write(poketArray_String.get(Integer.parseInt(pocket)) + "\n");
                }else{
                    bw.write(pocketArray_int.get(pocket) + "\n");
                }
            }

            br.close();
            bw.flush();
            bw.close();
        }
        public static boolean isNum(String str) { //숫자 체크 함수(숫자이면 true, 숫자아니면 false)
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
