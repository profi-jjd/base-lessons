package lesson4;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        System.out.println("Массивы");
        int len = 10;
        // длина массива - положительное значение типа int
        int[] ints = new int[len];
        int[] ints1 = new int[4];
        int[] ints2 = new int[len * 2];

        int[] ints3 = {12, 67, -90, 1421, 6032, 0};
        // ints3 = {89, 12, -9};
        // new int[]{89, 12, -9} - безымянный массив
        ints3 = new int[]{89, 12, -9};

        // вывод массива в консоль
        System.out.println(ints3);
        // import java.util.Arrays;
        System.out.println(Arrays.toString(ints3));

        // доступ к элементам массива
        // получили значение элемента массива ints3 с индексом 1
        int elem = ints3[1];
        System.out.println(elem); // 12
        // изменили значение элемента массива ints3 с индексом 0
        ints3[0] = 13009;
        System.out.println(Arrays.toString(ints3));

        // обращение к несуществующему элементу массива
        // приведет к ошибке времени выполнения:
        // java.lang.ArrayIndexOutOfBoundsException
        // System.out.println(ints3[10]);

        // многомерные массивы
        int[][] ints4 = new int[3][4];
        // [[0, 0, 0, 0], [0, 0, 90, 0], [0, 0, 0, -4021]]
        // доступ к элементам многомерного массива
        ints4[1][2] = 90;
        ints4[2][3] = -4021;
        // вывод в консоль многомерного массива
        System.out.println(Arrays.deepToString(ints4));

        int[][] ints5 = new int[4][];
        // [null, null, null, null]
        ints5[0] = new int[1]; // [[0], null, null, null]
        ints5[1] = new int[2]; // [[0], [0, 0], null, null]
        ints5[2] = new int[3]; // [[0], [0, 0], [0, 0, 0], null]
        ints5[3] = new int[4]; // [[0], [0, 0], [991, 0, 0], [0, 0, 0, 0]]
        ints5[2][0] = 991;
        System.out.println(Arrays.deepToString(ints5));

        // ==
        // ints5[0] == null

        // перебор массивов
        int[] ints6 = {45, 90, 1, -32, 100};

        // цикл for позволяет изменять значения элементов массива
        // fori + enter
        // length - размер массива, свойство доступно только на чтение
        for (int i = 0; i < ints6.length; i++) {
            ints6[i] += 10;
        }
        System.out.println(Arrays.toString(ints6));

        // foreach не имеет доступа к индексам,
        // не позволяет изменять значения элементов массива
        // iter int[] ints6 = {55, 100, 11, -22, 110};
        for (int arrElem: ints6) {
            System.out.println(arrElem);
            // arrElem *= arrElem;
        }
        // объявить массив типа double на 7 элементов,
        // заполнить его в цикле рандомными значениями (3, 100)
        // найти минимальное значение в массиве
        // Math.random() * 97 + 3
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;

        double[] doubles = new double[7];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.random() * 97 + 3;
            if (doubles[i] < max) max = doubles[i];
        }
        System.out.println(Arrays.toString(doubles));
        System.out.println(max);

        int[] ints7 = {90, 12, 67, -100, 56, 32};
        // foreach
        // найти сумму значений элементов массива
        int sum = 0;
        for (int elemVal : ints7) {
            sum += elemVal;
        }
        System.out.println(sum);
        // for
        // если значение элемента массива попадает
        // в диапазон (12, 60), то меняем это значение
        // на значение по умолчанию
        for (int i = 0; i < ints7.length; i++) {
            if (ints7[i] > 12 && ints7[i] < 60) ints7[i] = 0;
        }



        // сравнение массивов
        int[] a = {34, 78, 10};
        int[] b = {34, 78, 10};
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // false

        System.out.println(Arrays.equals(a, b)); // true

        // сортировка массива
        // алгоритм быстрой сортировки
        // {34, 78, 10};
        Arrays.sort(a);
        // Arrays.parallelSort(a);
        System.out.println(Arrays.toString(a)); // 10, 34, 78

        // копирование массивов
        a = new int[]{34, 90, -1};
        int[] newInt = a; // создание дополнительной ссылки

        int[] cloneArr = a.clone(); // создание полной копии массива

        int[] copyArr = new int[10];
        // a {34, 90, -1, 803}
        // copyArr [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.arraycopy(a, 1, copyArr, 4, 2);
        System.out.println(Arrays.toString(copyArr));

        // Arrays.copyOf()

        a = new int[]{34, 90, -1, 200, -12};

        // метод бинарного поиска в массиве
        // алгоритм бинарного поиска
        Arrays.sort(a); // [-12, -1, 34, 90, 200]
        int res = Arrays.binarySearch(a, -1); // 1
        System.out.println(res);
        res = Arrays.binarySearch(a, 35); // -4: 3+1
        System.out.println(res);
















    }
}
