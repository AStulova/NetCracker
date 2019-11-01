public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        boolean isInsideX, isInsideY;
        isInsideX = x1 <= ball.getX() - ball.getRadius() && x2 >= ball.getX() + ball.getRadius();
        isInsideY = y1 <= ball.getY() - ball.getRadius() && y2 >= ball.getY() + ball.getRadius();
        return isInsideX && isInsideY;
    }

    public void rollBall(Ball ball) {
        ball.move();
        if (!collides(ball)) {
            ball.reflectHorizontal();
            ball.reflectVertical();
        }
    }

    /*public void rollBall(Ball ball) {
        if(collides(ball)) {
            ball.move();
            if (y2 <= ball.getY() + ball.getRadius() || y1 >= ball.getY() - ball.getRadius())
                ball.reflectVertical();
            if (x2 <= ball.getY() + ball.getRadius() || x1 >= ball.getY() - ball.getRadius())
                ball.reflectHorizontal();
            ball.move();
        }
    }*/

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1
                + "), (" + x2 + "," + y2 + ")]";
    }
}
