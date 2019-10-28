import java.util.Scanner;
public class Lattice {
    /*
    # # # # #
    # # # # #
    # # # # #
    # # # # #
    # # # # #
    */
    private static void rectangle(int size) {
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= size; ++col) {
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    # # # # # # #
    #           #
    #           #
    #           #
    #           #
    #           #
    # # # # # # #
    */
    private static void emptyRectangle(int size) {
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= size; ++col) {
                if(row == 1 || row == size)
                    System.out.print("# ");
                else{
                    if(col > 1 & col < size)
                        System.out.print("  ");
                    else
                        System.out.print("# ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    #
    # #
    # # #
    # # # #
    # # # # #
    # # # # # #
    # # # # # # #
    # # # # # # # #
    */
    private static void triangleA(int size) {
        for (int row = 1, num = 1; row <= size; ++row, ++num) {
            for (int col = 1; col <= num;  ++col) {
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
        #
        # #
        # # #
        # # # #
        # # # # #
        # # # # # #
        # # # # # # #
        # # # # # # # #
        */
    private static void triangleB(int size) {
        for (int row = 1, num = size; row <= size; ++row, --num) {
            for (int col = 1; col <= num;  ++col) {
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter shape size: ");
        int size = in.nextInt();

        triangleA(size);
        rectangle(size);
        emptyRectangle(size);
        triangleB(size);
        in.close();
    }
}