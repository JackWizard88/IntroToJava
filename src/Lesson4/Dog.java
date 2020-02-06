package Lesson4;

public class Dog extends Animal implements Swimmable, Runnable, Jumpable  {
    private String name;
    private int runLimit, swimLimit;
    private double jumpLimit;

    public Dog(String _name, int _runLimit, int _swimLimit, double _jumpLimit ) {
        this.name = _name;
        this.runLimit = _runLimit;
        this.swimLimit = _swimLimit;
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
    public boolean swim(int distance) {
        return this.swimLimit > distance;
    }

    @Override
    public String toString() {
         return "Имя: " + this.name + "\nДистанция заплыва: " + this.swimLimit + " метров.\nДистанция бега: " + this.runLimit + " метров\nВысота прыжка: " + jumpLimit + " метров" +
                "\n--------------------конец-данных----------------------------------- ";
    }



}
