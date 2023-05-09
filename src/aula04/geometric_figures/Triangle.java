package aula04.geometric_figures;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Sides must be positive.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Invalid triangle.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
        this(1, 1, 1);
    }

    public double[] getSides() {
        return new double[]{side1, side2, side3};
    }

    public void setSides(double side1, double side2, double side3) {
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Sides must be positive.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Invalid triangle.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" + "side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", area="
            + getArea()
            + ", perimeter=" + getPerimeter() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.side1, side1) != 0) {
            return false;
        }
        if (Double.compare(triangle.side2, side2) != 0) {
            return false;
        }
        return Double.compare(triangle.side3, side3) == 0;
    }
}