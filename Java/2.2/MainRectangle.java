class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public String toString() {
        return ("Rectangle[length=" + length + ", width=" + width + "]");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) obj;
        return rectangle.length == length && rectangle.width == width;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(length);
        result = 31 * result + Float.floatToIntBits(width);
        return result;
    }
}

public class MainRectangle {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10.5f, 4.7f);
        System.out.println(rectangle.toString());
        System.out.println("Rectangle's area is " + rectangle.getArea() + " and perimeter is " + rectangle.getPerimeter());
        rectangle.setLength(8.76f);
        rectangle.setWidth(2.14f);
        System.out.println(rectangle.toString());
        System.out.println("Rectangle's area is " + rectangle.getArea() + " and perimeter is " + rectangle.getPerimeter());
        Rectangle rectangle1 = new Rectangle(8.76f, 2.14f);
        System.out.println(rectangle.hashCode());
        System.out.println(rectangle1.hashCode());
        System.out.println(rectangle.equals(rectangle1));
    }
}
