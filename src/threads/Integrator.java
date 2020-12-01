package threads;

import functions.Function;
import functions.Functions;

public class Integrator extends Thread {
    private Task task;
    private Semaphore semaphore;
    public Integrator(Task a, Semaphore b){
        task = a;
        semaphore =b;
    }
    public void interrupt(){
        super.interrupt();
    }
    public void run() {
        try {
            for (int i = 0; i < task.getOperations() && !Thread.currentThread().isInterrupted(); ++i) {
                double leftB;
                double rightB;
                double step;
                Function f;
                semaphore.beginRead();
                leftB = task.getLeftBorder();
                rightB = task.getRightBorder();
                step = task.getStep();
                f = task.getFunction();
                semaphore.endRead();
                double res = Functions.inegral(f, leftB, rightB, step);
                System.out.println(i + "Result <" + leftB + "> <" + rightB + "> <" + step + "> <" + res + ">\n");

            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}