public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MealBuilder m = new MealBuilder();
        System.out.println("Adding Veg Meal");
        Meal meal = m.vegMeal();
        System.out.println("Showing Items");
        meal.showItems();
        System.out.println("Total Cost");
        System.out.println(meal.getCost());
        System.out.println("Adding Non Veg Meal");
        Meal nonVegmeal = m.nonVegMeal();
        System.out.println("Showing Items");
        nonVegmeal.showItems();
        System.out.println("Total Cost");
        System.out.println(nonVegmeal.getCost());

    }
}