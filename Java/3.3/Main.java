public class Main {
    public static void main(String[] args) {
        Container container = new Container(0, 0, 20,20);
        Ball ball = new Ball(18,12, 1, 2, 2);
        System.out.println(container);
        for (int i = 0; i < 10; i++) {
            container.rollBall(ball);
            System.out.println(ball + " " + container.collides(ball));
        }
    }
}
