public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle("orange", true,8.7);
        Rectangle rectangle = new Rectangle(2.7, 4.9);
        Square square = new Square("green", true, 4.3);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
    }
}
