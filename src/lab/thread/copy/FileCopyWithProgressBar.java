package lab.thread.copy;

import java.io.*;
public class FileCopyWithProgressBar {
    static final int BUFFER_SIZE = 1024;
    static volatile long copiedBytes = 0;
    static volatile boolean done = false;
    static long totalBytes;

    public static void main(String[] args) {
        File source = new File("sample.txt");
        File target = new File("copy_sample.txt");
        if (!source.exists()) {
            System.out.println("sample.txt 입력파일이 존재하지 않습니다.");
            return;
        }
        totalBytes = source.length();
        Thread copier = new Thread(new FileCopier(source, target));
        Thread printer = new Thread(new ProgressPrinter());
        copier.start();
        printer.start();
        try {
            copier.join();
            printer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n복사 완료!");
    }

    static class FileCopier implements Runnable { // 파일 복사 스레드
        File source, target;

        FileCopier(File source, File target) {
            this.source = source;
            this.target = target;
        }

        public void run() {
            try {
                FileInputStream in = new FileInputStream(source);
                FileOutputStream out = new FileOutputStream(target);
                byte[] buffer = new byte[BUFFER_SIZE];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                    copiedBytes += len;
                    Thread.sleep(500); // 0.5초 지연
                }
                in.close();
                out.close();
                done = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ProgressPrinter implements Runnable {// 진행바 출력 스레드

        public void run() {
            while (!done) {
                printBar(copiedBytes, totalBytes);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printBar(totalBytes, totalBytes); // 100% 출력
        }

        void printBar(long copied, long total) {
            int percent = (int) (copied * 100 / total);
            int filled = percent / 5;
            StringBuilder bar = new StringBuilder("[");
            for (int i = 0; i < 20; i++) {
                bar.append(i < filled ? "=" : " ");
            }
            bar.append("] ").append(percent).append("%");
            System.out.print("\r" + bar);
        }
    }
}