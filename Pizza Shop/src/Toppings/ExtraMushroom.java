package Toppings;

import PizzaTypes.BasePizza;

public class ExtraMushroom extends ToppingDecorator{
    BasePizza pizza;
    public ExtraMushroom(BasePizza pizza){
        this.pizza = pizza;
    }
    @Override public int cost(){
        return  pizza.cost()+25;
    }
}
