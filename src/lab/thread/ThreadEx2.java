package lab.thread;

public class ThreadEx2 {
    public static void main(String[] args) {
        // Runnable 구현체 생성
        MyRunnable myRunnable = new MyRunnable();

        // Thread 객체에 Runnable 구현체 전달
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        // 쓰레드 시작
        t1.start();
        t2.start();
    }
}
