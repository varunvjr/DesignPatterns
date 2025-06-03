public class ShapeFactory implements Shape {
    Shape shape;
    public ShapeFactory(Shape shape){
        this.shape = shape;
    }
    public void calculateArea(){
        shape.calculateArea();
    }
}
