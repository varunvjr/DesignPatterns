public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Strategy Pattern");
        Shape shape = new ShapeFactory(new Rectangle());
        shape.calculateArea();
        Shape shape1 = new ShapeFactory(new Square());
        shape1.calculateArea();

    }
}