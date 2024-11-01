public class ShapeFactory extends AbstractFactory{
    public Shape getFactory(String factoryType){
        if(factoryType.equals("rectangle")){
            return new Rectangle();
        }
        if(factoryType.equals("square"))
            return new Square();
        return null;
    }
}
