import java.util.ArrayList;
import java.util.Random;

public class MArray {
    private static void printArray(int[][] arr) {
        for (int[] x : arr){
            for (int y : x)
                System.out.print(y +" ");
            System.out.println();
        }
    }

    private  static void fillRandom(int[][] arr, int range1, int range2) {
        Random random = new Random();
        int randNum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                randNum = random.nextInt(range2 - range1 + 1);
                arr[i][j] = randNum + range1;
            }
        }
    }

    private static void findMainDiagonal(int[][] arr) {
        int sum = 0, col = 0;
        long prod = 1;
        for (int[] x : arr){
            sum += x[col];
            prod *= x[col];
            col++;
        }
        System.out.println("Sum of elements of the main diagonal: " + sum);
        System.out.println("Product of elements of the main diagonal: " + prod);
    }

    private static void findSecDiagonal(int[][] arr) {
        int sum = 0, col = arr[0].length - 1;
        long prod = 1;
        for (int[] x : arr){
            sum += x[col];
            prod *= x[col];
            col--;
        }
        System.out.println("Sum of elements of the secondary diagonal: " + sum);
        System.out.println("Product of elements of the secondary diagonal: " + prod);
    }

    private static void findMaxElement(int[][] arr) {
        int max = -99;
        ArrayList<Integer> indexI = new ArrayList<Integer>();
        ArrayList<Integer> indexJ = new ArrayList<Integer>();
        int pairNum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max){
                    indexI.clear();
                    indexJ.clear();
                    pairNum = 0;
                    max = arr[i][j];
                    indexI.add(pairNum, i);
                    indexJ.add(pairNum, j);
                }
                else if (arr[i][j] == max){
                    pairNum++;
                    indexI.add(pairNum, i);
                    indexJ.add(pairNum, j);
                }
            }
        System.out.print("Max element in array is " + max + " with indices:");
        for (int i = 0; i < indexI.size(); i++)
            System.out.print(" (" + indexI.get(i) + "; " + indexJ.get(i) + ")");
        System.out.println();
    }

    private static void findMaxRowProduct(int[][] arr) {
        int index = 0, product, maxProduct = 0, maxIndex = 0;
        for (int x[] : arr) {
            product = 1;
            for (int y : x) {
                product *= (Math.abs(y));
                //System.out.print(product + " ");
            }
            if (product > maxProduct){
                maxProduct = product;
                maxIndex = index;
            }
            index++;
        }
        System.out.println("Maximum modulo product of elements is " + maxProduct + " in row with index " + maxIndex);
    }

    private static void sortRow(int[][] arr){
        int t;
        for (int x[] : arr) {
            for (int i = 1; i < x.length; i++)
                for (int j = x.length - 1; j >= i; j--)
                    if (x[j - 1] > x[j]) {
                        t = x[j - 1];
                        x[j - 1] = x[j];
                        x[j] = t;
                    }
            for (int i = 0; i < x.length / 2; i++) {
                t = x[i];
                x[i] = x[x.length - i - 1];
                x[x.length - i - 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arrA = new int[8][8];
        int[][] arrB = new int[8][5];
        int[][] arrC = new int[8][5];
        int[][] arrD = new int[10][7];

        System.out.println("Two-dimensional array size 8 by 8:");
        fillRandom(arrA, 1,99);
        printArray(arrA);
        findMainDiagonal(arrA);
        findSecDiagonal(arrA);
        System.out.println();

        System.out.println("Two-dimensional array size 8 rows and 5 columns:");
        fillRandom(arrB, -99, 99);
        printArray(arrB);
        findMaxElement(arrB);
        System.out.println();

        System.out.println("Two-dimensional array size 8 rows and 5 columns:");
        fillRandom(arrC, -10,10);
        printArray(arrC);
        findMaxRowProduct(arrC);
        System.out.println();

        System.out.println("Two-dimensional array size 10 rows and 7 columns:");
        fillRandom(arrD, 0,100);
        printArray(arrD);
        System.out.println();
        System.out.println("Sorted array in decreasing order by row:");
        sortRow(arrD);
        printArray(arrD);
    }
}
