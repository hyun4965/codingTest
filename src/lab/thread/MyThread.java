package lab.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " - " + i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
