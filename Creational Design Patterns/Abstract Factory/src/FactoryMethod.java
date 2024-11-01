public class FactoryMethod  {
    public AbstractFactory shapeFactory(String type){
        if(type.equals("normal")){
            return new ShapeFactory();
        }else if(type.equals("rounded")){
            return new RoundedShapeFactory();
        }else
            return null;
    }
}
