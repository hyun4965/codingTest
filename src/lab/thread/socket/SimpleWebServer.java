package lab.thread.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    public static void main(String[] args) {
        // 서버를 열 포트 번호
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 포트 " + port + "에서 대기 중...");

            // 클라이언트 연결을 계속해서 기다리는 루프
            while (true) {
                // 클라이언트 연결 수락
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                // 새 쓰레드 생성 -> 클라이언트 소켓 처리
                Thread t = new Thread(() -> handleClient(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 각 클라이언트 연결을 처리하는 메서드 (쓰레드 동작)
    private static void handleClient(Socket clientSocket) {
        try {
            // 요청 읽기 위한 입력 스트림
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            // 응답 보내기 위한 출력 스트림
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            // 1) 간단한 HTTP 요청의 첫 줄(요청 라인)만 읽어보자
            String requestLine = in.readLine();
            System.out.println("요청 라인: " + requestLine);

            // 추가로 Header 들을 읽으려면 반복문으로 in.readLine() 사용 가능
            // 빈 줄(헤더 끝)까지 읽으면 실제 요청 바디 위치로 이동할 수 있음
            // 여기는 간단히 헤더만 무시
            String header;
            while ((header = in.readLine()) != null && !header.isEmpty()) {
                // 필요 시 헤더 정보 처리
                System.out.println("헤더: " + header);
            }

            // 2) 간단한 HTML 응답 예시 (HTTP/1.1 200 OK)
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println(); // 헤더 끝 줄

            out.println("<html>");
            out.println("<head><title>Simple WebServer</title></head>");
            out.println("<body>");
            out.println("<h1>안녕하세요. 간단한 웹 서버입니다.</h1>");
            out.println("<p>요청 라인 : " + requestLine + "</p>");
            out.println("</body></html>");
            out.flush(); // 출력 버퍼 비우기

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 소켓 닫기
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
