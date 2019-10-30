import java.lang.reflect.Array;
import java.util.Arrays;

class Sort {
    private static void printArray(int[] arr)
    {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    // Bubble sort algorithm
    private static void sortByBubble(int[] arr, int size) {
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
        System.out.println("Sorted array by bubble method: ");
        printArray(arr);
    }
    // Selection sort algorithm
    private static void sortBySelection(int[] arr, int size) {
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
        System.out.println("Sorted array by selection method: ");
        printArray(arr);
    }
    // With using Arrays.sort()
    private static void sortByMethod(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted array by Arrays.sort():");
        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr, arr1, arr2;
        long startTime;
        arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)((Math.random() * 200) - 100);
        }
        arr1 = arr2 = arr.clone();
        int size = arr.length;
        System.out.println("Source array: ");
        printArray(arr);
        System.out.println();

        startTime = System.nanoTime();
        sortByBubble(arr, size);
        System.out.println("Algorithm execution time: " + (System.nanoTime() - startTime));
        System.out.println();

        startTime = System.nanoTime();
        sortBySelection(arr1, size);
        System.out.println("Algorithm execution time: " + (System.nanoTime() - startTime));
        System.out.println();

        startTime = System.nanoTime();
        sortByMethod(arr2);
        System.out.println("Algorithm execution time: " + (System.nanoTime() - startTime));
    }
}