public class RoundedShapeFactory extends AbstractFactory{
    public Shape getFactory(String factoryType){
        if(factoryType.equals("square")){
            return new RoundedSquare();
        }
        if(factoryType.equals("rectangle")){
            return new RoundedRectangle();
        }
        return null;
    }
}
