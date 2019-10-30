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
}

public class MainCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(9.7);
        circle.setColor("blue");
        System.out.println(circle.toString());
        System.out.println("Circle's area is " + circle.getArea());
    }
}
