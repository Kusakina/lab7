package threads;

import functions.Function;
import functions.basic.Log;

import java.util.Random;

public class Generator extends Thread {
    private Task task;
    private Semaphore semaphore;

    public Generator(Task a, Semaphore b) {
        task = a;
        semaphore = b;
    }
    static Random random = new Random();
    static double rand(double left, double right){
        double x = random.nextDouble();
        return( x *= (right - left));
    }

    public void run() {
        try {

            for (int i = 0; i < task.getOperations() && !Thread.currentThread().isInterrupted(); ++i) {
                double step;
                double leftB;
                double rightB;
                double x = random.nextDouble();
                double base = 10 - rand(0, 10);
                Function log = new Log(base);
                leftB = rand(0, 100);
                rightB = 200 - rand(100, 200);
                step = random.nextDouble();
                semaphore.beginWrite();
                task.setFunction(log);
                task.setLeftBorder(leftB);
                task.setRightBorder(rightB);
                task.setStep(step);
                semaphore.endWrite();
                System.out.println(i + "Source <" + leftB + "> <" + rightB + "> <" + step + ">");

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}