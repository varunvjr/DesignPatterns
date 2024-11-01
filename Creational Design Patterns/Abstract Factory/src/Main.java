import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        FactoryMethod factory = new FactoryMethod();
        System.out.println("Enter the Factory Type");
        String factoryName = scanner.next();
        AbstractFactory factoryType = factory.shapeFactory(factoryName);
        System.out.println("Enter the Shape Type");
        String shapeType = scanner.next();
        Shape shapeFactory = factoryType.getFactory(shapeType);
        shapeFactory.draw();
    }
}