package az.ibrahimshirinov.abstractFactoryMethod;


import az.ibrahimshirinov.abstractFactoryMethod.factory.pizza.BasePizzaFactory;
import az.ibrahimshirinov.abstractFactoryMethod.factory.pizza.GourmetPizzaFactory;
import az.ibrahimshirinov.abstractFactoryMethod.factory.pizza.SicilianPizzaFactory;
import az.ibrahimshirinov.abstractFactoryMethod.pizza.Pizza;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public class AbstractFactoryMethod {

    public static void main(String[] args) {

        BasePizzaFactory gourmetPizzaFactory =  new GourmetPizzaFactory();
        Pizza cheesePizza = gourmetPizzaFactory.createPizza("pepperoni");

        System.out.println("================================================================");

        SicilianPizzaFactory sicilianPizzaFactory = new SicilianPizzaFactory();
        Pizza veggiePizza = sicilianPizzaFactory.createPizza("veggie");


    }
}
