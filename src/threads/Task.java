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

    private volatile Function function;
    private volatile double leftBorder;

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

    private volatile double rightBorder;
    private volatile double step;
    int operations;
    public Task(int operations){
        this.operations = operations;
    }

    public void setOperations (int n){
        operations = n;
    }
}
