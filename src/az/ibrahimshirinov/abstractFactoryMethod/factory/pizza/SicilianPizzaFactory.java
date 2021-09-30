package az.ibrahimshirinov.abstractFactoryMethod.factory.pizza;


import az.ibrahimshirinov.abstractFactoryMethod.factory.topping.BaseToppingFactory;
import az.ibrahimshirinov.abstractFactoryMethod.factory.topping.SicilianToppingFactory;
import az.ibrahimshirinov.abstractFactoryMethod.pizza.CheesePizza;
import az.ibrahimshirinov.abstractFactoryMethod.pizza.PepperoniPizza;
import az.ibrahimshirinov.abstractFactoryMethod.pizza.Pizza;
import az.ibrahimshirinov.abstractFactoryMethod.pizza.VeggiePizza;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public class SicilianPizzaFactory extends BasePizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        BaseToppingFactory toppingFactory = new SicilianToppingFactory();
        switch (type.toLowerCase()) {
            case "cheese":
                pizza = new CheesePizza(toppingFactory);
                break;
            case "pepperoni":
                pizza = new PepperoniPizza(toppingFactory);
                break;
            case "veggie":
                pizza = new VeggiePizza(toppingFactory);
                break;
            default:
                throw new IllegalArgumentException("No such pizza");
        }
        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}
