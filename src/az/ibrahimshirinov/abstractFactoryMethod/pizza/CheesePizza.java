package az.ibrahimshirinov.abstractFactoryMethod.pizza;


import az.ibrahimshirinov.abstractFactoryMethod.factory.topping.BaseToppingFactory;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public class CheesePizza extends Pizza{
    BaseToppingFactory toppingFactory;

    public CheesePizza(BaseToppingFactory toppingFactory) {
        this.toppingFactory = toppingFactory;
    }

    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for cheese pizza.");
        toppingFactory.createCheese();
        toppingFactory.createSauce();
    }
}
