package Lesson4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //создадим массив из 5 сотрудников
        ArrayList<Employer> arrayOfEmployers = new ArrayList<>();

        arrayOfEmployers.add(new Employer("Иванов Иван", "Старший менеджер", 45, "ivanovI@pochta.ru", "8-999-99-99-99", 75000.00));
        arrayOfEmployers.add(new Employer("Кириллов Кирилл", "менеджер", 35, "kirillovK@pochta.ru", "8-999-99-35-80", 65000.00));
        arrayOfEmployers.add(new Employer("Андреев Андрей", "менеджер", 52, "andreevA@pochta.ru", "8-999-99-67-75", 65000.00));
        arrayOfEmployers.add(new Employer("Сергеев Сергей", "менеджер-консультант", 27, "SergeevS@pochta.ru", "8-999-99-24-60", 45000.00));
        arrayOfEmployers.add(new Employer("Михайлов Михаил", "менеджер-консультант", 41, "MikhailovM@pochta.ru", "8-999-99-62-55", 50000.00));

        //выведем информацию о сотрудниках старше 40 лет в консоль используя перегруженный метод toString и цикл for each
        System.out.println("Вот список сотрудников старше 40 лет: \n--------------------------------------");
        int counter = 0;
        for (Employer employer : arrayOfEmployers) {
            if (employer.getAge() > 40) {
                System.out.println(++counter);
                System.out.println(employer.toString());
            }
        }

        System.out.println("\n\nА теперь создадим кошечек и собачек и пустим их побегать попрыгать и поплавать (ну кроме кошек, они не плавают). " +
                "\nОграничения по дистанциям и высотам зададим через конструктор при создании объектов \n");

        //лимиты из пунтка 7 задания не актуальны. Все лимиты будем задавать вручную
        Cat cat1 = new Cat("Барсик", 500, 5.0 );
        Cat cat2 = new Cat("Мурзик", 450, 3.5);
        Dog dog1 = new Dog("Барбос", 1000, 75, 1.5);
        Dog dog2 = new Dog("Тузик", 900, 50, 2.0);

        //выведем информацию о наших подопечных в консоль
        System.out.println(cat1.toString());
        System.out.println(cat2.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        System.out.println("\nТеперь побегаем и попрыгаем!");

        //выведем пару примеров в консоль для наглядности. Обойдемся без создания методов
        System.out.println("\n>> Кошка " + cat1.getName() + " бежит 150 метров и " + (cat1.run(150) ? "добежал!" : "не добежал..."));
        System.out.println("\n>> Собака " + dog2.getName() + " бежит 500 метров и ей попадается препятсвие высотой 2 метра. И пёс " + (dog2.run(500) ? "добежал" : "не добежал...") + ". " +
                "\n   А что с препятствием? А препятствие "  + (dog2.jump(2) ? "преодолено!" : "не преодолел..."));
        System.out.println("\n>> Собака " + dog1.getName() + " бежит 800 метров и ей попадается препятсвие высотой 1 метр. И пёс " + (dog2.run(800) ? "добежал" : "не добежал...") + ". " +
                "\n   А что с препятствием? А препятствие "  + (dog2.jump(1) ? "преодолено!" : "не преодолел..."));

        //плавать не будем. утонувшие нам не нужны.

    }
}
