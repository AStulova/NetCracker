interface Resizable {
    void resize(int percent);
}

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        super.radius += super.radius * (double) percent / 100;
    }
}
