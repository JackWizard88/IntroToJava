package Lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<CatL5> cats = new ArrayList<>();

        System.out.println("\n\nСоздадим массив котов\n");

        //создадим массив котов и одну тарелку с едой
        cats.add(new CatL5("Барсик", 500, 5.0, 50));
        cats.add(new CatL5("Мурзик", 450, 3.5, 70));
        cats.add(new CatL5("Вафля", 500, 5.0, 65));


        //выведем информацию о наших подопечных в консоль
        for (CatL5 cat : cats) {
            System.out.println(cat.toString());
        }

        System.out.println("\nСоздадим миску и выведем информацию о ней");
        Bowl bowl1 = new Bowl(65);                         //создадим миску с едой id=1 объем 65 единиц
        System.out.println(bowl1.toString());                       // выведем о ней информацию
        System.out.println("\n\nТеперь наполним миску");
        bowl1.setFilling(80);                                       //и наполним её до краев


        //Теперь коты по очереди будут пытаться кушать
        for (CatL5 cat : cats) {
            System.out.println("\nКот " + cat.getName() + " хочет поесть "+ cat.getAppetitus() + " еды из миски " + bowl1.getId() + " с помощью метода catEat(Bowl bowl)");
            cat.catEat(bowl1);
        }

        //Повторно выведем информацию о котах, посмотреть сыты ли они
        System.out.println();
        for (CatL5 cat : cats) {
            System.out.println(cat.toString());
        }

    }
}
