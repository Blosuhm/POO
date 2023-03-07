package src.aula04.geometric_figures;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be positive.");
        }

        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(1, 1);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be positive.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + ", area=" + getArea() + ", perimeter="
                + getPerimeter() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(rectangle.width, width) != 0) {
            return false;
        }
        return Double.compare(rectangle.height, height) == 0;
    }
}