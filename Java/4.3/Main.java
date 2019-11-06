public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(5.1f, 1.4f, 1.1f, 0.7f);
        System.out.println(point);
        point.move();
        System.out.println(point);
    }
}
