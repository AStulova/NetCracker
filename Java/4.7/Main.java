public class Main {
    public static void main(String[] args) {
        MovableRectangle movableRectangle = new MovableRectangle(5, 12, 15, 8, 4,2);

        System.out.println(movableRectangle);
        movableRectangle.moveUp();
        System.out.println(movableRectangle);
        movableRectangle.moveDown();
        System.out.println(movableRectangle);
        movableRectangle.moveLeft();
        System.out.println(movableRectangle);
        movableRectangle.moveRight();
        System.out.println(movableRectangle);
    }
}
