package threads;

public class Semaphore {
    private boolean canWrite = true;
    public synchronized void beginRead(){
        while(canWrite){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void endRead(){
        canWrite = true;
        notifyAll();
    }
    public synchronized void beginWrite(){
        while(!canWrite){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void endWrite(){
        canWrite = false;
        notifyAll();
    }
}
