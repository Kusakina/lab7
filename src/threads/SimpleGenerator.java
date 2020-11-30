package threads;

import functions.Function;
import functions.Functions;
import functions.basic.Log;
import java.util.Random;


public class SimpleGenerator implements Runnable {
    private Task task;
    public SimpleGenerator(Task a){
        task = a;
    }
    static Random random = new Random();
    static double rand(double left, double right){
        double x = random.nextDouble();
        return( x *= (right - left));
    }

    @Override
    public void run() {
        for (int i =0; i< 100; ++i){
            double step;
            double leftB;
            double rightB;
            synchronized (task) {
                double x = random.nextDouble();
                double base = 10 - rand(0, 10);
                Function log = new Log(base);
                task.setFunction(log);
                leftB = rand(0, 100);
                task.setLeftBorder(leftB);
                rightB = 200 - rand(100, 200);
                task.setRightBorder(rightB);
                step = random.nextDouble();
                task.setStep(step);
            }
                System.out.println("Source <" + leftB + "> <" + rightB + "> <" + step + ">");

        }
    }
}
