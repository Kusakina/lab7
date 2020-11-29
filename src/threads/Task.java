package threads;

import functions.Function;

public class Task {
    public void setFunction(Function function) {
        this.function = function;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public void setStep(double step) {
        this.step = step;
    }

    private Function function;
    private double leftBorder;

    public Function getFunction() {
        return function;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public double getStep() {
        return step;
    }

    public int getOperations() {
        return operations;
    }

    private double rightBorder;
    private double step;
    int operations;
    public Task(){
    }
    public Task(Function f, double left, double right, double step){
        function = f;
        leftBorder=left;
        rightBorder = right;
        this.step=step;
    }
    public void setOperations (int n){
        operations = n;
    }
}
