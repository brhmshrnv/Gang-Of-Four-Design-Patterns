package az.ibrahimshirinov.abstractFactoryMethod.factory.topping;


import az.ibrahimshirinov.abstractFactoryMethod.cheese.Cheese;
import az.ibrahimshirinov.abstractFactoryMethod.cheese.GoatCheese;
import az.ibrahimshirinov.abstractFactoryMethod.sauce.CaliforniaOilSauce;
import az.ibrahimshirinov.abstractFactoryMethod.sauce.Sauce;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class GourmetToppingFactory extends BaseToppingFactory{

    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

    @Override
    public Sauce createSauce() {
        return new CaliforniaOilSauce();
    }
}
