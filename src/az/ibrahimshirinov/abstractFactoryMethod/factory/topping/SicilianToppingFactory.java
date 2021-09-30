package az.ibrahimshirinov.abstractFactoryMethod.factory.topping;


import az.ibrahimshirinov.abstractFactoryMethod.cheese.Cheese;
import az.ibrahimshirinov.abstractFactoryMethod.cheese.MozzarellaCheese;
import az.ibrahimshirinov.abstractFactoryMethod.sauce.Sauce;
import az.ibrahimshirinov.abstractFactoryMethod.sauce.TomatoSauce;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class SicilianToppingFactory extends BaseToppingFactory{

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Sauce createSauce() {return new TomatoSauce(); }
}
