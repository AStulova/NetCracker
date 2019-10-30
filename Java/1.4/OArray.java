import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class OArray {
    private static void printArray(int[] arr) {
        for(int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
    private static void fillOdd(int[] oddArr) {
        for(int i = 0, j = 0; i <= 99; i++)
            if(i % 2 != 0) {
                oddArr[j] = i;
                j++;
            }
    }
    private  static void  fillRandom(int[] randArr, int range1, int range2) {
        Random random = new Random();
        int randNum;
        for (int i = 0; i < randArr.length; i++){
            randNum = random.nextInt(range2 - range1 + 1);
            randArr[i] = randNum + range1;
        }
    }
    private static void reverseArray(int[] arr) {
        int t;
        for (int i = 0; i < arr.length / 2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
    }

    private static void countOddEven(int[] arr){
        int odd, even;
        odd = even = 0;
        for (int value : arr) {
            if (value % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Number of even numbers: " + even);
        System.out.println("Number of odd numbers: " + odd);
    }

    private static void  replaceOdd(int[] arr) {
        for (int i = 0; i < arr.length; i += 2)
            arr[i] = 0;
    }

    private static void findMaxMin(int[] arr){
        int max, min, iMax, iMin;
        max = min = arr[0];
        iMax = iMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                iMax = i;
            }
            if(arr[i] < min){
                min = arr[i];
                iMin = i;
            }
        }
        System.out.println("Maximum element is " + max + " and last entry index is " + iMax);
        System.out.println("Minimum element is " + min + " and last entry index is " + iMin);
    }

    private static double countAverage(int[] arr){
        int sum = 0;
        for (int value: arr)
            sum += value;
        return ((double)sum / arr.length);
    }

    private static void  compareAverage(int[] arr1, int[] arr2){
        double averageE1, averageE2;
        averageE1 = countAverage(arr1);
        averageE2 = countAverage(arr2);
        if (averageE1 > averageE2)
            System.out.println("Average of first(= " + averageE1 + ") array is larger than second(= " + averageE2+ ")");
        else if (averageE1 < averageE2)
            System.out.println("Average of first(= " + averageE1 + ") array is smaller than second(= " + averageE2+ ")");
        else
            System.out.println("Average of first(= " + averageE1 + ") and second(= " + averageE2 + ") arrays is the same");
    }

    private static void countFrequency(int[] arr) {
        int fr, key, maxFreq = 0;
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        Set<Map.Entry<Integer, Integer>> entrySet = frequency.entrySet();
        frequency.put(-1, 0);
        frequency.put(0, 0);
        frequency.put(1, 0);
        for (int value : arr) {
            fr = frequency.get(value);
            fr++;
            frequency.put(value, fr);
        }
        System.out.print("The most common element(s) in array: ");
        for (int i = -1; i < 2; i++)
            if (frequency.get(i) > maxFreq)
                maxFreq = frequency.get(i);
        for (Map.Entry<Integer, Integer> pair : entrySet)
            if (maxFreq == pair.getValue())
                System.out.print(pair.getKey() + " ");
        //System.out.println(frequency.values());
    }

    public static void main(String[] args) {
        int[] oddArr = new int[50];
        int[] randArrB = new int[20];
        int[] randArrC = new int[10];
        int[] randArrD = new int[15];
        int[] randArrE1 = new int[10];
        int[] randArrE2 = new int[10];
        int[] randArrF = new int[20];

        System.out.println("Array of odd numbers ascending in the interval [1; 99]:");
        fillOdd(oddArr);
        printArray(oddArr);
        System.out.println("Array of odd numbers descending in the interval [1; 99]:");
        reverseArray(oddArr);
        printArray(oddArr);
        System.out.println();

        System.out.println("Array of random numbers in the interval [0; 10]:");
        fillRandom(randArrB, 0, 10);
        printArray(randArrB);
        countOddEven(randArrB);
        System.out.println();

        System.out.println("Array of random numbers in the interval [1; 100]:");
        fillRandom(randArrC, 1, 100);
        printArray(randArrC);
        System.out.println("Numbers with odd index are replaced by zero:");
        replaceOdd(randArrC);
        printArray(randArrC);
        System.out.println();

        System.out.println("Array of random numbers in the interval [-50; 50]:");
        fillRandom(randArrD, -50, 50);
        printArray(randArrD);
        findMaxMin(randArrD);
        System.out.println();

        System.out.println("First array of random numbers in the interval [0; 10]:");
        fillRandom(randArrE1, 0, 10);
        printArray(randArrE1);
        System.out.println("Second: ");
        fillRandom(randArrE2, 0, 10);
        printArray(randArrE2);
        compareAverage(randArrE1, randArrE2);
        System.out.println();

        System.out.println("Array of random numbers in the interval [-1; 1]:");
        fillRandom(randArrF, -1, 1);
        printArray(randArrF);
        countFrequency(randArrF);
        System.out.println();
    }
}