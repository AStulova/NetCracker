import java.lang.reflect.Array;
import java.util.Arrays;

class Sort {
    private static  void arrOutput(int[] arr)
    {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    // Алгоритм пузырьковой сортировки
    private static void bubble(int[] arr, int size) {
        int t;
        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= i; j--) {
                {
                    if (arr[j - 1] > arr[j]) {
                        t = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = t;
                    }
                }
            }
        }
        System.out.println("Отсортированный массив методом пузырька: ");
        arrOutput(arr);
    }
    // Алгоритм сортировки методом выбора
    private static void selection(int[] arr, int size) {
        int t, max, n;
        for (int i = size - 1; i > 0; i--) {
            max = arr[0];
            n = 0;
            for (int j = 1; j < i + 1; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    n = j;
                }
            }
            t = arr[i];
            arr[i] = arr[n];
            arr[n] = t;
        }
        System.out.println("Отсортированный массив методом выбора: ");
        arrOutput(arr);
    }

    // С использованием Arrays.sort()
    private static void arrSort(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Отсортированный массив методом Arrays.sort():");
        arrOutput(arr);
    }

    public static void main(String[] args) {
        int[] arr, arr1, arr2;
        long startTime;
        arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)((Math.random() * 200) - 100);
        }
        arr1 = arr2 = arr.clone();
        int t, size = arr.length;
        System.out.println("Исходный массив: ");
        arrOutput(arr);
        System.out.println();

        startTime = System.nanoTime();
        bubble(arr, size);
        System.out.println("Время выполнения алгоритма: " + (System.nanoTime() - startTime));
        System.out.println();

        startTime = System.nanoTime();
        selection(arr1, size);
        System.out.println("Время выполнения алгоритма: " + (System.nanoTime() - startTime));
        System.out.println();

        startTime = System.nanoTime();
        arrSort(arr2);
        System.out.println("Время выполнения алгоритма: " + (System.nanoTime() - startTime));
    }
}