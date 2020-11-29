package functions;

import functions.meta.*;

public abstract class Functions {
    public static Function shift(Function f, double shiftX, double shiftY){
        return(new Shift(f, shiftX, shiftY));
    }
    public static Function scale(Function f, double scaleX, double scaleY){
        return (new Scale(f, scaleX, scaleY));
    }
    public static Function power (Function f, double power){
        return (new Power(f, power));
    }
    public static Function sum(Function f1, Function f2){
        return (new Sum(f1, f2));
    }
    public static Function mult(Function f1, Function f2){
        return (new Mult(f1, f2));
    }
    public static Function composition(Function f1, Function f2){
        return (new Composition(f1,f2));
    }
    public static double inegral (Function f, double left_border, double right_border, double step){
        if (left_border< f.getLeftDomainBorder() || right_border> f.getRightDomainBorder())
            throw new IllegalArgumentException("Incorrect range of values");
       double left =  left_border;
       double count = (right_border - left_border)/step;
       double integ = 0;
       if (count<0) {
           return (integ += (f.getFunctionValue(left) + f.getFunctionValue(right_border)) / 2 * (right_border - left_border));

       } else {
           for (int i = 0; i < (int) count; ++i) {
               integ += (f.getFunctionValue(left) + f.getFunctionValue(left + step))/2*(step);
               left+=step;
           }
           if (count%1!=0)
               integ+=(f.getFunctionValue(left) + f.getFunctionValue(right_border))/2*(right_border-left);
       }
       return integ;
    }
}

