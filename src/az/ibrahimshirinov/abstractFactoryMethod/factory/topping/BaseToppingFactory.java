package az.ibrahimshirinov.abstractFactoryMethod.factory.topping;


import az.ibrahimshirinov.abstractFactoryMethod.cheese.Cheese;
import az.ibrahimshirinov.abstractFactoryMethod.sauce.Sauce;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public abstract class BaseToppingFactory {

    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}
