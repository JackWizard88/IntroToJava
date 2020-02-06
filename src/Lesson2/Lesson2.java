package Lesson2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        //1
        //1.1
        System.out.print("1. Создадим массив из 10 элементов: ");
        int[] array = arrInit(10);
        System.out.println(Arrays.toString(array));
        //1.2
        System.out.print("С помощью цикла и условия заменить 0 на 1, 1 на 0: ");
        arrInvertor(array);
        System.out.println(Arrays.toString(array)+ "\n");
        //2
        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21:");
        int[] array2 = Method2();
        System.out.println(Arrays.toString(array2)+ "\n");
        //3
        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2:");
        int[] array3 = Method3();
        System.out.println(Arrays.toString(array3)+ "\n");
        //4
        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами:");
        int[][] array4 = Method4(11);
        twoDimArrayToString(array4);
        System.out.println("");
        //5
        System.out.println("5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (Для примера создаем масиив из 20 элементов, заполненный случайными числами от 0 до 100): ");
        Method5(20);
        System.out.println("");
        //6
        System.out.println("6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.");
        int[] array5 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 10};
        Method6(array5);
        System.out.println("");
        System.out.println("7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),\n" +
                        "при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами. ");
        System.out.println("Для простоты на вход передадим массив из предыдущего задания: ");
        System.out.println(Arrays.toString(array5));
        arrayShifter(array5, -13);
        System.out.println("Примем сдвиг равным -13: ");
        System.out.println(Arrays.toString(array5)+ "\n");

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] arrInit(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i]= ( (Math.random()<0.5) ? 0 : 1 );
        }
        return array;
    }

    public static void arrInvertor(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
    }


    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static int[] Method2() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        return arr;
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;

    public static int[] Method3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    public static int[][] Method4(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                arr[i][i] = 1;
                arr[i][arr.length -1 - i ] = 1;
            }
        }
        return arr;
    }

    //метод вывода двумерного массива
    public static void twoDimArrayToString(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + ints[j] + " ");
            }
            System.out.println("");
        }
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы:
    public static void Method5(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i]= (int) (Math.random()*100);
        }
        int min = array[0], max = array[0];
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
    }

    //6.Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) →
    // true, граница показана символами ||, эти символы в массив не входят;

    public static boolean Method6(int arr[]) {
        int summ = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            summ += arr[i];

            int restSumm = 0;
            for (int j = i + 1; j < arr.length; j++) {
                restSumm += arr[j];
            }

            if (summ == restSumm) {
                System.out.print("[");
                for (int k = 0; k <= i; k++) {
                    System.out.print(arr[k]+", ");
                }
                System.out.print("|| ");
                for (int l = i + 1; l < arr.length-1; l++) {
                    System.out.print(arr[l] + ", ");
                }
                System.out.print(arr[arr.length -1] + "] → true\n");

                return true;
            }
        }
        System.out.print(Arrays.toString(arr) + " → false\n");
        return false;
    }

    /*7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами. */
    public static void arrayShifter(int arr[], int shift) {
        if (shift != 0) {
            //приведем значение сдвига до наименьшего в пределах размерности массива
            int finalShift = shift;
            if (Math.abs(shift) > arr.length){
                finalShift = shift % arr.length;
            }

            //для положительного сдвига будем сдвигать массив вправо по 1 шагу "finalShift" раз, а для отрицательного влево
            if (shift > 0) {
                for (int i = 0; i < finalShift; i++) {

                    // убираем первый элемент в буфер, а на его место ставим хвостовой элемент
                    int buffer = arr[0];
                    arr[0] = arr[arr.length - 1];

                    // циклично сдвигаем весь массив
                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[arr.length - j] = arr[arr.length - j - 1];
                    }

                    // ставим буферный элемент в 1 ячейку
                    arr[1] = buffer;
                }

            } else {
                for (int i = 0; i > finalShift; i--) {
                    int buffer = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[0];

                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[j - 1] = arr[j];
                    }

                    arr[arr.length - 2] = buffer;
                }

            }
        }
    }
}
