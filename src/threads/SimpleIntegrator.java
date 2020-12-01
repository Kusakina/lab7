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

        for (int i =0; i< task.getOperations(); ++i){
            double leftB;
            double rightB;
            double step;
            Function f;
            synchronized (task) {
                leftB = task.getLeftBorder();
                rightB = task.getRightBorder();
                step = task.getStep();
                f= task.getFunction();

            }
            if (null==f) {
                System.out.println("Неполная инициализация");
            } else {
                double res = Functions.inegral(f, leftB, rightB, step);
                System.out.println("Result <" + leftB + "> <" + rightB + "> <" + step + "> <" + res + ">");
            }
        }

    }
}
