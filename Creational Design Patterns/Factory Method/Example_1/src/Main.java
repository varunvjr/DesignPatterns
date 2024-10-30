import java.util.*;
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        System.out.println("Enter the shape type");
        Scanner sc = new Scanner(System.in);
        String shapeType = sc.next();
        Shape obj = shapeFactory.getShape(shapeType);
        obj.draw();

    }
}