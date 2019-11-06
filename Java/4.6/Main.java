public class Main {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(8, 15, 4, 7);
        MovableCircle movableCircle = new MovableCircle(4, 6, 4, 7, 2);

        movablePoint.moveUp();
        System.out.println(movablePoint);
        movablePoint.moveDown();
        System.out.println(movablePoint);
        movablePoint.moveLeft();
        System.out.println(movablePoint);
        movablePoint.moveRight();
        System.out.println(movablePoint);
        System.out.println();
        movableCircle.moveUp();
        System.out.println(movableCircle);
        movableCircle.moveDown();
        System.out.println(movableCircle);
        movableCircle.moveLeft();
        System.out.println(movableCircle);
        movableCircle.moveRight();
        System.out.println(movableCircle);
    }
}
