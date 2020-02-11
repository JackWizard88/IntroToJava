package Lesson6;

public class Calculation {
    private String a, b;    //first and second operand
    private String operator; //operator
    private String result;  //result of calculation

    //basic null constructor
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
            case "x^y":
                x = Math.pow(x, y);
                break;
        }

        // round if .0
        if (x % 1 == 0) {
            this.result = ((int) x + "");
        } else {
            this.result = (x + "");
        }
     }

    public String getResult() {
        return result;
    }

}
