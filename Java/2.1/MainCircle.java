class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ("Circle[radius=" + radius + ", color=" + color + "]");
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Circle)) return false;
        Circle circle = (Circle) obj;
        return circle.color.equals(color) && circle.radius == radius;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + color.hashCode();
        result = 31 * result + (int)(Double.doubleToLongBits(radius) ^ (Double.doubleToLongBits(radius) >>> 32));
        return result;
    }
}

public class MainCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(9.7);
        circle.setColor("blue");
        System.out.println(circle.toString());
        System.out.println("Circle's area is " + circle.getArea());
        Circle circle1 = new Circle(3.5, "blue");
        Circle circle2 = circle1;
        System.out.println(circle.hashCode());
        System.out.println(circle1.hashCode());
        System.out.println(circle.equals(circle1));
        System.out.println(circle1.hashCode());
        System.out.println(circle2.hashCode());
        System.out.println(circle1.equals(circle2));
    }
}
