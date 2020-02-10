package Lesson6;

public class Calculation {
    private static double a, b;
    private static String operation;
    private static  double result;


    public Calculation() {
        this.a = 0;
        this.b = 0;
        this.operation = "";
    }


    public double getA() {
        return a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }


    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    public static double calculate() {
        if (operation == "+") a = (a + b);
        else if (operation == "-") a = (a - b);
        else if (operation == "*") a = (a * b);
        else if (operation == "/") a = (a / b);
        else if (operation == "^") {
            for (int i = 0; i < b; i++) {
                a *= a;
            }
        }

        return a;
     }
}
