public class ShapeFactory {
    public Shape getShape(String shapeType){
        shapeType = shapeType.toLowerCase();
        if(shapeType.equals("square")) {
            return new Square();
        }
        if(shapeType.equals("rectangle")) {
            return new Rectangle();
        }
        if(shapeType.equals("circle")) {
            return new Circle();
        }
        return null;
    }
}
