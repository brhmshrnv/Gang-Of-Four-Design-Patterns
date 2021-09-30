package az.ibrahimshirinov.abstractFactoryMethod.pizza;

/**
 * @author IbrahimShirinov
 * @since 28.09.2021
 */
public abstract class Pizza {

    public abstract void addIngredients();
    public void bakePizza () {
        System.out.println("Pizza baked at 400 for 20 minutes.");
    }
}
