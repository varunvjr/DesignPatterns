import PizzaTypes.BasePizza;
import PizzaTypes.Farmhouse;
import PizzaTypes.Vegdelight;
import PizzaTypes.Margherita;
import Toppings.ToppingDecorator;
import Toppings.ExtraCheese;
import Toppings.ExtraMushroom;
public class Main {
    public static void main(String[] args)
    {
        BasePizza pizza = new Farmhouse();
        System.out.println("Farmhose pizza cost "+pizza.cost());
        System.out.println("Add cheese to it");
        BasePizza withCheese = new ExtraCheese(new Farmhouse());
        System.out.println("Farmhose with cheese cost "+withCheese.cost());
        System.out.println("Add extra mushroom with cheese on top ");
        BasePizza mushroomaCheese = new ExtraMushroom(new ExtraCheese(new Farmhouse()));
        System.out.println(mushroomaCheese.cost());

    }
}