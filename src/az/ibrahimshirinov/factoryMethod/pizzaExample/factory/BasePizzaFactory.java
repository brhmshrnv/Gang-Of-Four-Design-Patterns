package az.ibrahimshirinov.factoryMethod.pizzaExample.factory;


import az.ibrahimshirinov.factoryMethod.pizzaExample.types.Pizza;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public abstract class BasePizzaFactory {

    public abstract Pizza createPizza(String type);
}
