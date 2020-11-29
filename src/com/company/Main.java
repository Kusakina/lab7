package com.company;

import functions.*;
import functions.basic.Exp;
import functions.basic.Log;
import threads.SimpleGenerator;
import threads.SimpleIntegrator;
import threads.Task;
//import functions.basic.Cos;
//import functions.basic.Exp;
//import functions.basic.Log;
//import functions.basic.Sin;
//import functions.meta.Composition;
//import functions.meta.Power;
//import functions.meta.Sum;

import java.io.*;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static double rand(double left, double right){
        double x = random.nextDouble();
       return( x *= (right - left));
    }
    public static void nonThread(){
        Task a = new Task();
        a.setOperations(100);
        double base;
        double leftB;
        double rightB;
        double step;
       // Random random = new Random();

        for (int i =0; i< 100; ++i){
            double x = random.nextDouble();
            base= 10 - rand(0, 10);
            Function log = new Log(base);
            a.setFunction(log);
            leftB = rand(0, 100);
            a.setLeftBorder(leftB);
            rightB = 200 - rand(100, 200);
            a.setRightBorder(rightB);
            step = random.nextDouble();
            a.setStep(step);
            System.out.println("Source <"+leftB+"> <"+rightB+"> <"+step+">");
            double res = Functions.inegral(a.getFunction(), leftB, rightB, step);
            System.out.println("Result <"+leftB+"> <"+rightB+"> <"+step+"> <"+res+">");

        }
    }
    public static void simpleThreads(){
        Task a = new Task();
        a.setOperations(100);
        SimpleGenerator generator = new SimpleGenerator(a);
        SimpleIntegrator integrator = new SimpleIntegrator(a);
        new Thread(integrator).start();
        new Thread(generator).start();


    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*TabulatedFunction a = new TabulatedFunction(1.0, 3.0, 5);

        for(int i = 0; i < a.getPointCount(); ++i){
            System.out.println(a.getPointX(i)+";"+ a.getPointY(i));
        }
        FunctionPoint d = new FunctionPoint();
        FunctionPoint dd = new FunctionPoint(2.3, 7);
        a.addPoint(d);
        a.addPoint(dd);
        a.deletePoint(1);
        for(int i = 0; i<a.getPointCount(); ++i){
            System.out.println(a.getPointX(i)+";"+ a.getPointY(i));
        }*/

        /*double[] value = {2, 0, 3};
        //TabulatedFunction parabola = new ArrayTabulatedFunction(-1, 1, value);
        //System.out.println(parabola.getPoint(2));
        TabulatedFunction funk = new LinkedListTabulatedFunction(-1, 1, value);
        for(int i = 0; i<funk.getPointCount(); ++i){
            System.out.println(funk.getPointX(i)+";"+ funk.getPointY(i));
        }
        try {
            funk.addPoint(new FunctionPoint(2, 8));
        } catch (InappropriateFunctionPointException e){System.out.println(e);}
        for(int i = 0; i<funk.getPointCount(); ++i){
            System.out.println(funk.getPointX(i)+";"+ funk.getPointY(i));
        }*/
       /* Sin a =new Sin();
        System.out.println("It's sin");
        for (double i= 0; i<2*Math.PI;i+=0.1 ) {
            System.out.print(i + " ");
            System.out.println(a.getFunctionValue(i));
        }

        Cos b =new Cos();
        System.out.println("It's cos");
        for (double i= 0; i<2*Math.PI;i+=0.1 ){
            System.out.print(i+" ");
            System.out.println(b.getFunctionValue(i));
        }
        System.out.println("It's sin again");
        Function A = TabulatedFunctions.tabulate(a, 0, 2*Math.PI, 20);
        for (double i= 0; i<2*Math.PI;i+=0.1 ){
            System.out.print(i+" ");
            System.out.println(A.getFunctionValue(i));
        }
        TabulatedFunction B = TabulatedFunctions.tabulate(b, 0, 2*Math.PI, 20);
        System.out.println("It's cos again");
        for (double i= 0; i<2*Math.PI;i+=0.1 ){
            System.out.print(i+" ");
            System.out.println(B.getFunctionValue(i));
        }
        Power C = new Power(A, 2);
        Function Ad = Functions.power(A,2);
        Power D = new Power(B, 2);
        Sum E = new Sum(C, D);
        System.out.println("It's Sum of sin^2 & cos^2");
        for (double i= 0; i<2*Math.PI;i+=0.1 ){
            System.out.print(i+" ");
            System.out.println(E.getFunctionValue(i));
        }
        TabulatedFunction Ex = TabulatedFunctions.tabulate(new Exp(), 0, 10, 11);
        try (Writer out = new FileWriter("1.txt")) {
            TabulatedFunctions.writeTabulatedFunction(Ex,out);
        }

        try (BufferedReader in = new BufferedReader(new FileReader("1.txt"))) {
            TabulatedFunction Ex2  = TabulatedFunctions.readTabulatedFunction(in);
            System.out.println("It's tabulated Exp");
            for (double i= 0; i<11 ;i+=1 ){
                System.out.print(i+" ");
                System.out.println(Ex2.getFunctionValue(i));
            }
        } catch (InappropriateFunctionPointException e) {
            e.printStackTrace();
        }

        System.out.println("It's Ex");
        for (double i= 0; i<11 ;i+=1 ){
            System.out.print(i+" ");
            System.out.println(Ex.getFunctionValue(i));
        }
        TabulatedFunction Lo = TabulatedFunctions.tabulate(new Log(Math.E), 0, 10, 11);
        try (OutputStream out  = new FileOutputStream("2.bin")) {
            TabulatedFunctions.outputTabulatedFunction(Lo,out);
        }
        try (InputStream in = new FileInputStream("2.bin")) {
            TabulatedFunction Lo2 = TabulatedFunctions.inputTabulatedFunction(in);
            System.out.println("It's Log");
            for (double i= 0; i<11 ;i+=1 ){
                System.out.print(i+" ");
                System.out.println(Lo2.getFunctionValue(i));
            }
        } catch (InappropriateFunctionPointException e) {
            e.printStackTrace();
        }
        TabulatedFunction Lex = TabulatedFunctions.tabulate(new Composition(new Log(Math.E), new Exp() ), 0, 10, 11);
        try (ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("3.txt"))) {
            out.writeObject(Lex);
        }
        System.out.println("It's Lex");
        for (double i = 0; i < 11; i += 1) {
            System.out.print(i + " ");
            System.out.println(Lex.getFunctionValue(i));
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("3.txt"))) {
            TabulatedFunction Lex2 = (TabulatedFunction) in.readObject();
            System.out.println("It's Lex2");
            for (double i= 0; i<11 ;i+=1 ){
                System.out.print(i+" ");
                System.out.println(Lex2.getFunctionValue(i));
             }

        }

        try (FileOutputStream out2 = new FileOutputStream("4.txt")) {
            ObjectOutputStream obj = new ObjectOutputStream(out2);
            obj.writeObject(Lex);
        }

        try( ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("4.txt")))
        {
            TabulatedFunction Lex3 = (TabulatedFunction) in2.readObject();
            System.out.println("It's Lex3");
            for (double i = 0; i < 11; i += 1) {
                System.out.print(i + " ");
                System.out.println(Lex3.getFunctionValue(i));
            }
        }
         TabulatedFunction aa = new ArrayTabulatedFunction(1.0, 3.0, 5);

        for(int i = 0; i < aa.getPointCount(); ++i){
            System.out.println(aa.getPointX(i)+";"+ aa.getPointY(i));
        }
        try (Writer out = new FileWriter("7.txt")) {
            TabulatedFunctions.writeTabulatedFunction(aa,out);
        }*/

      Function a = new Exp();
      double res = Functions.inegral(a, 0, 1, 0.001);//отличие в 7 знаке
      System.out.println(res);
      Function b = new Log(4);
      try {
          double res2 = Functions.inegral(b, -5, 3, 0.001);//отличие в 7 знаке
          System.out.println(res2);
      } catch (Exception e){
          System.out.println(e.getMessage());
      }
      //nonThread();
      System.out.println("simpleThreads here");
      simpleThreads();




/*       TabulatedFunction a = new LinkedListTabulatedFunction(1.0, 3.0, 5);
       double[] value = {2, 0, 3};
       TabulatedFunction parabola = new ArrayTabulatedFunction(-1, 1, value);
       TabulatedFunction parabola2 = new LinkedListTabulatedFunction(-1, 1, value);
       System.out.println(a.toString());
       System.out.println(parabola.toString());
       System.out.println(parabola2.toString());
       System.out.println(parabola.hashCode());
       System.out.println(parabola2.hashCode());
       System.out.println(parabola2.equals(parabola));
       System.out.println(parabola.equals(parabola));
       TabulatedFunction parabola3 =  parabola2.clone();
       TabulatedFunction parabola4 = parabola.clone();
       System.out.println(parabola3.toString());
       System.out.println(parabola4.toString());
       System.out.println(parabola.hashCode());
       System.out.println(parabola2.hashCode());
       FunctionPoint b = new FunctionPoint(-1.001, 2);
        try {
            parabola4.setPoint(0,b);
        } catch (InappropriateFunctionPointException e) {
            e.printStackTrace();
        }
        try {
            parabola2.setPoint(0,b);
        } catch (InappropriateFunctionPointException e) {
            e.printStackTrace();
        }
        System.out.println("замена точки");
        System.out.println(parabola.toString());
        System.out.println(parabola4.toString());
        System.out.println(parabola.getPoint(0).hashCode());
        System.out.println(parabola4.getPoint(0).hashCode());
        System.out.println(parabola2.toString());
        System.out.println(parabola3.toString());
        System.out.println(parabola2.getPoint(0).equals(parabola3.getPoint(0)));
        System.out.println(parabola2.getPoint(1).equals(parabola3.getPoint(1)));
        System.out.println(parabola2.getPoint(2).equals(parabola3.getPoint(2)));
        System.out.println(parabola2.toString());
        System.out.println(parabola3.toString());
        System.out.println(parabola2.equals(parabola));
        System.out.println(parabola2.equals(parabola3));
        System.out.println(parabola.hashCode());
        System.out.println(parabola.equals(parabola4));
        System.out.println(parabola2.equals(parabola4));*/








        /*FunctionPoint a= new FunctionPoint(-10, 2);
        System.out.println(parabola.getFunctionValue(0.5));
        System.out.println();
        try {
            parabola.setPoint(2, a);
        } catch (InappropriateFunctionPointException e){System.out.println(e.getMessage());};
        for(int i = 0; i<parabola.getPointCount(); ++i){
            System.out.println(parabola.getPointX(i)+";"+ parabola.getPointY(i));
        }
        System.out.println();
        try {
            parabola.setPointX(0, -3);
        } catch (InappropriateFunctionPointException e){System.out.println(e.getMessage());};
        for(int i = 0; i<parabola.getPointCount(); ++i){
            System.out.println(parabola.getPointX(i)+";"+ parabola.getPointY(i));
        }
        System.out.println();

        try {
            funk.setPointX(1, -9);
        } catch (InappropriateFunctionPointException e){System.out.println(e.getMessage());};
        try {
            funk.setPointX(1, 2);
        } catch (InappropriateFunctionPointException e){System.out.println(e.getMessage());};
        System.out.println();
        try {
            funk.setPoint(0, a);
        } catch (InappropriateFunctionPointException e){System.out.println(e.getMessage());};
        for(int i = 0; i<funk.getPointCount(); ++i){
            System.out.println(funk.getPointX(i)+";"+ funk.getPointY(i));
        }
        System.out.println(funk.getRightDomainBorder());
        System.out.println();
        System.out.println(funk.getPoint(0));
       // System.out.println(funk.getPointX(4));
        try {
            funk.addPoint(new FunctionPoint(-7, 8));
        } catch (InappropriateFunctionPointException e){System.out.println(e);}
        for(int i = 0; i<funk.getPointCount(); ++i){
            System.out.println(funk.getPointX(i)+";"+ funk.getPointY(i));
        }
        System.out.println();
        try {
            funk.addPoint(new FunctionPoint(-7, 8));
        } catch (InappropriateFunctionPointException e){System.out.println(e);}
        System.out.println();
        //funk.deletePoint(-7);
        funk.deletePoint(0);
        funk.deletePoint(0);
        try {
            funk.deletePoint(0);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        for(int i = 0; i<funk.getPointCount(); ++i){
            System.out.println(funk.getPointX(i)+";"+ funk.getPointY(i));
        }
        try{
            funk.deletePoint(0);
        } catch (IllegalStateException e){
            System.out.println(e);
        }*/
       // System.out.println();
        /*parabola.setPoint(1, new FunctionPoint(1.5, 2));

        for(int i = 0; i<parabola.getPointCount(); ++i){
            System.out.println(parabola.getPointX(i)+";"+ parabola.getPointY(i));
        }
        System.out.println();

        parabola.deletePoint(1);
        for(int i = 0; i<parabola.getPointCount(); ++i){
            System.out.println(parabola.getPointX(i)+";"+ parabola.getPointY(i));
        }
        System.out.println();*/



    }

}
