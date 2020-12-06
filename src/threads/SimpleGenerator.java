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
        for (int i =0; i< task.getOperations(); ++i){
            double step;
            double leftB;
            double rightB;
            double x = random.nextDouble();
            double base = 10 - rand(0, 10);
            Function log = new Log(base);
            leftB = rand(0, 100);
            rightB = 200 - rand(100, 200);
            step = random.nextDouble();
            synchronized (task) {
                task.setFunction(log);
                task.setLeftBorder(leftB);
                task.setRightBorder(rightB);
                task.setStep(step);
            }
                System.out.println("simple: " + i +"Source <" + leftB + "> <" + rightB + "> <" + step + ">");

        }
    }
}
