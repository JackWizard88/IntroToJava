package Lesson5;

public class MyException extends Exception {
    String message;

    public MyException(String _message) {
        this.message = _message;
    }

    public String getMessage() {
        return message;
    }

}
