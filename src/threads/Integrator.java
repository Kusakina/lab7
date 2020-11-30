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
    public void run() {
        try {


            for (int i = 0; i < 100; ++i) {
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
                System.out.println("Result <" + leftB + "> <" + rightB + "> <" + step + "> <" + res + ">");

            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
