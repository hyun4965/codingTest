package lab.thread;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 쓰레드 동작할 코드
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
