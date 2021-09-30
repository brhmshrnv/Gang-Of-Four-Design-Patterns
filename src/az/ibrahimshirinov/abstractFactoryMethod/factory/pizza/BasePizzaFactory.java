package az.ibrahimshirinov.abstractFactoryMethod.factory.pizza;


import az.ibrahimshirinov.abstractFactoryMethod.pizza.Pizza;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public abstract class BasePizzaFactory {

    public abstract Pizza createPizza(String type);
}
