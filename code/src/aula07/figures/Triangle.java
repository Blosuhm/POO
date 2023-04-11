package aula07.figures;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC, String color) {
        super(color);
        validDimensions(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private void validSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
    }

    private void validSides(double sideA, double sideB, double sideC) {
        if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    private void validDimensions(double sideA, double sideB, double sideC) {
        validSide(sideA);
        validSide(sideB);
        validSide(sideC);
        validSides(sideA, sideB, sideC);
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        validSide(sideA);
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        validSide(sideB);
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        validSide(sideC);
        this.sideC = sideC;
    }

    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "]";
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
        Triangle other = (Triangle) obj;
        return this.sideA == other.sideA && this.sideB == other.sideB && this.sideC == other.sideC
                && this.color.equals(other.color);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + Double.hashCode(sideA);
        hash = hash * 31 + Double.hashCode(sideB);
        hash = hash * 31 + Double.hashCode(sideC);
        return hash;
    }
}
