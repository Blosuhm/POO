package aula07.figures;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color) {
        super(color);
        validDimensions(width, height);
        this.width = width;
        this.height = height;
    }

    private void validWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
    }

    private void validHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
    }

    private void validDimensions(double width, double height) {
        validWidth(width);
        validHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        validWidth(width);
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        validHeight(height);
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
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
        Rectangle other = (Rectangle) obj;
        return this.width == other.width && this.height == other.height && this.color.equals(other.color);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + Double.hashCode(width);
        hash = hash * 31 + Double.hashCode(height);
        return hash;
    }

}
