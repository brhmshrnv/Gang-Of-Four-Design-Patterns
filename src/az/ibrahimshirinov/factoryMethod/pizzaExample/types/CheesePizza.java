package az.ibrahimshirinov.factoryMethod.pizzaExample.types;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class CheesePizza extends Pizza {

    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for cheese pizza");
    }
}
