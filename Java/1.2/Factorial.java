import java.util.Scanner;

public class Factorial {
    // Calculating factorial using a loop
    private  static  long cyclicF(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }
    // Calculating factorial using recursion
    private static long recursiveF(int num) {
        long res = 1;
        if (num == 1 || num == 0) {
            return res;
        }
        res = num * recursiveF(num - 1);
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;
        long startTime;
        System.out.print("Enter the number: ");
        int num = in.nextInt();
		
		System.out.println("Factorial calculation:");
        System.out.println("1) Using a loop:");
        startTime = System.nanoTime();
        res = cyclicF(num);
        System.out.println(num + "! = " + res);
        System.out.println(System.nanoTime() - startTime);

        System.out.println("2) Using recursion:");
        startTime = System.nanoTime();
        res = recursiveF(num);
        System.out.println(num + "! = " + res);
        System.out.println(System.nanoTime() - startTime);

        in.close();
    }
}