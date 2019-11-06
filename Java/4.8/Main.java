public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(11.1);
        System.out.println("Area = " + circle.getArea());
        System.out.println("Perimeter = " + circle.getPerimeter());
        System.out.println();
        ResizableCircle resizableCircle = new ResizableCircle(8.4);
        System.out.println("Area = " + resizableCircle.getArea());
        System.out.println("Perimeter = " + resizableCircle.getPerimeter());
        resizableCircle.resize(20);
        System.out.println("Area = " + resizableCircle.getArea());
        System.out.println("Perimeter = " + resizableCircle.getPerimeter());
    }
}
