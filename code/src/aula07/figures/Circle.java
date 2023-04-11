package aula07.figures;

public class Circle extends Figure {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Circle other = (Circle) obj;
        return this.radius == other.radius && this.color.equals(other.color);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + color.hashCode();
        hash = hash * 31 + Double.hashCode(radius);
        return hash;
    }

}
