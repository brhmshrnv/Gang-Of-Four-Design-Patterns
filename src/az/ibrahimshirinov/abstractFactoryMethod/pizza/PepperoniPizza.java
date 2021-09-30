package az.ibrahimshirinov.abstractFactoryMethod.pizza;


import az.ibrahimshirinov.abstractFactoryMethod.factory.topping.BaseToppingFactory;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public class PepperoniPizza extends Pizza{
    BaseToppingFactory toppingFactory ;

    public PepperoniPizza(BaseToppingFactory toppingFactory) {
        this.toppingFactory = toppingFactory;
    }

    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for pepperoni pizza");
        toppingFactory.createCheese();
        toppingFactory.createSauce();
    }
}
