package az.ibrahimshirinov.factoryMethod;


import az.ibrahimshirinov.factoryMethod.pizzaExample.factory.BasePizzaFactory;
import az.ibrahimshirinov.factoryMethod.pizzaExample.factory.PizzaFactory;
import az.ibrahimshirinov.factoryMethod.pizzaExample.types.Pizza;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class FactoryMethod {

    public static void main(String[] args) {

        BasePizzaFactory factory = new PizzaFactory();
        Pizza cheesePizza=factory.createPizza("cheese");
        Pizza veggiePizza=factory.createPizza("veggie");

    }
}
