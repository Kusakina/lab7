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
        double base;
        double leftB;
        double rightB;
        double step;
        for (int i =0; i< 100; ++i){
            double x = random.nextDouble();
            base= 10 - rand(0, 10);
            Function log = new Log(base);
            task.setFunction(log);
            leftB = rand(0, 100);
            task.setLeftBorder(leftB);
            rightB = 200 - rand(100, 200);
            task.setRightBorder(rightB);
            step = random.nextDouble();
            task.setStep(step);
            System.out.println("Source <"+leftB+"> <"+rightB+"> <"+step+">");
            double res = Functions.inegral(task.getFunction(), leftB, rightB, step);
            System.out.println("Result <"+leftB+"> <"+rightB+"> <"+step+"> <"+res+">");

        }
    }
}
