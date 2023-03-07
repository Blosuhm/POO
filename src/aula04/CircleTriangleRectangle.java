package src.aula04;

import src.aula04.geometric_figures.Circle;
import src.aula04.geometric_figures.Rectangle;
import src.aula04.geometric_figures.Triangle;

public class CircleTriangleRectangle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(10);

        Rectangle rectangle = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(5, 10);
        Rectangle rectangle3 = new Rectangle(10, 10);

        Triangle triangle = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(3, 4, 5);
        Triangle triangle3 = new Triangle(10, 10, 10);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);

        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());

        System.out.println("Circle circumference: " + circle.getCircumference());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());

        System.out.println("Circle radius: " + circle.getRadius());
        System.out.println("Rectangle width: " + rectangle.getWidth());
        System.out.println("Rectangle height: " + rectangle.getHeight());
        System.out.println("Triangle sides: " + triangle.getSides()[0] + ", " + triangle.getSides()[1] + ", "
                + triangle.getSides()[2]);

        System.out.println("Circle equals circle2: " + circle.equals(circle2));
        System.out.println("Circle equals circle3: " + circle.equals(circle3));
        System.out.println("Rectangle equals rectangle2: " + rectangle.equals(rectangle2));
        System.out.println("Rectangle equals rectangle3: " + rectangle.equals(rectangle3));
        System.out.println("Triangle equals triangle2: " + triangle.equals(triangle2));
        System.out.println("Triangle equals triangle3: " + triangle.equals(triangle3));
    }
}
