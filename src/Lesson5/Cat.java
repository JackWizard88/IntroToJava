package Lesson4;

public class Cat extends Animal implements Runnable, Jumpable {
    private String name;
    private int runLimit;
    private double jumpLimit;

    public Cat(String _name, int _runLimit, double _jumpLimit ) {
        this.name = _name;
        this.runLimit = _runLimit;
        this.jumpLimit = _jumpLimit;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean run(int distance) {
        return this.runLimit > distance;
    }

    @Override
    public boolean jump(double height) {
        return this.jumpLimit > height;
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + "\nДистанция бега: " + this.runLimit + " метров\nВысота прыжка: " + jumpLimit + " метров" +
                "\n--------------------конец-данных----------------------------------- ";
    }

}
