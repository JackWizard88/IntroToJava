package Lesson6;

public class Calculation {
    private String a, b;    //first and second operand
    private String operator; //operator
    private String result;  //result of calculation

    //basic null counstuctor
    public Calculation() {
        this.a = "";
        this.b = "";
        this.operator = "";
        this.result = "";
    }

    //getters and setters
    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setA(String a) {
        this.a = a;
    }


    public void setOperation(String operation) {
        this.operator = operation;
    }

    public String getOperation() {
        return operator;
    }

    //calculate and set result method
    public void calculate() {

        double x, y;
        x = Double.parseDouble(this.a);
        System.out.println(x);
        y = Double.parseDouble(this.b);
        System.out.println(y);
        switch (operator) {
            case "+":
                x = (x + y);
                break;
            case "-":
                x = (x - y);
                break;
            case "*":
                x = (x * y);
                break;
            case "/":
                x = (x / y);
                break;
            case "^":
                double buffer = x;
                for (int i = 1; i < y; i++) {
                    x = x * buffer;
                }
                break;
        }

        this.result =  ("" + x);
     }

    public String getResult() {
        return result;
    }

}
