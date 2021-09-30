package az.ibrahimshirinov.factoryMethod.pizzaExample.factory;


import az.ibrahimshirinov.factoryMethod.pizzaExample.types.CheesePizza;
import az.ibrahimshirinov.factoryMethod.pizzaExample.types.PepperoniPizza;
import az.ibrahimshirinov.factoryMethod.pizzaExample.types.Pizza;
import az.ibrahimshirinov.factoryMethod.pizzaExample.types.VeggiePizza;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class PizzaFactory extends BasePizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type.toLowerCase()){
            case "cheese":
                pizza=new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
            default:
                throw new IllegalArgumentException("No such pizza");
        }
        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}
