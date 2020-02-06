package Lesson4;

public class Employer {
    private String name;        //ФИО
    private String position;   //должность
    private int age;            //возраст
    private String email;       //почта
    private String phoneNumber; //телефон
    private double salary;      //указывается в рублях

    //конструктор
    public Employer(String _name, String _position, int _age, String _email, String _phoneNumber, double _salary) {
        this.name = _name;
        this.position = _position;
        this.age = _age;
        this.email = _email;
        this.phoneNumber = _phoneNumber;
        this.salary = _salary;
    }

    public int getAge() {
        return this.age;
    }


    //перегруженны метод toString для формирования текстовых данных для вывода
    @Override
    public String toString() {
        return "Ф.И.О.: " + this.name + "\nВозраст: "+ this.age + "\nЗанимает должность: " + this.position + " с окладом: " +
                this.salary +  " руб/месяц.\nКонтактные данные: тел." + this.phoneNumber + "| e-mail:" + this.email +
                "\n--------------------конец-данных----------------------------------- ";
    }

}
