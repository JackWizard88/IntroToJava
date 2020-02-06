package Lesson5;

public class Bowl {
    private int id;
    private int volume;
    private int filling;
    private static int counter;

    public Bowl(int _volume) {
        this.id = ++Bowl.counter;
        this.volume = _volume;
        this.filling = 0;
    }

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public int getFilling() {
        return filling;
    }

    public void setFilling(int filling) {
        try {
            if (filling < 0) {
                throw new MyException("Нужно вводить положительное число");
            } else if (filling > this.volume) {
                this.filling = this.volume;
            } else {
                this.filling = filling;
            }
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        finally {

            System.out.println("Миска " + this.id + " наполнена на " + this.filling +" из "+ this.volume + " единиц");
        }

    }

    @Override
    public String toString() {
        return "\nВ миске " + this.id + " cейчас лежит " + this.filling + " единиц еды. \nА всего в ней может находиться " + this.volume + " единиц еды." +
                "\n ----------------------- конец данных --------------------";
    }
}