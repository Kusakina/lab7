package threads;

import functions.Function;
import functions.Functions;
import functions.basic.Log;


public class SimpleIntegrator implements Runnable {
    private Task task;
    public SimpleIntegrator(Task a){
        task = a;
    }

    @Override
    public void run() {
        double leftB;
        double rightB;
        double step;
        for (int i =0; i< 100; ++i){
            leftB = task.getLeftBorder();
            rightB = task.getRightBorder();
            step = task.getStep();
            System.out.println("Source <"+leftB+"> <"+rightB+"> <"+step+">");
            double res = Functions.inegral(task.getFunction(), leftB, rightB, step);
            System.out.println("Result <"+leftB+"> <"+rightB+"> <"+step+"> <"+res+">");

        }

    }
}
