public class MealBuilder {
    public Meal vegMeal(){
        Meal m = new Meal();
        m.addItem(new VegBurger());
        m.addItem(new Coke());
        return m;
    }
    public Meal nonVegMeal(){
        Meal m = new Meal();
        m.addItem(new ChickenBurger());
        m.addItem(new Pepsi());
        return m;
    }
}
