package az.ibrahimshirinov.factoryMethod.pizzaExample.types;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public abstract class Pizza {
    public abstract void addIngredients();

    public void bakePizza() {
        System.out.println("Pizza baked at 400 for 20 minutes");
    }
}
