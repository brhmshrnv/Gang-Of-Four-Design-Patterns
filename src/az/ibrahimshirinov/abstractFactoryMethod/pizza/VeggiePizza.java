package az.ibrahimshirinov.abstractFactoryMethod.pizza;


import az.ibrahimshirinov.abstractFactoryMethod.factory.topping.BaseToppingFactory;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public class VeggiePizza extends Pizza{

    BaseToppingFactory toppingFactory ;

    public VeggiePizza(BaseToppingFactory toppingFactory) {
        this.toppingFactory = toppingFactory;
    }

    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for veggie pizza");
        toppingFactory.createCheese();
        toppingFactory.createSauce();
    }
}
