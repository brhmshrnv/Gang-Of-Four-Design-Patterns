package az.ibrahimshirinov.abstractFactoryMethod.cheese;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class GoatCheese implements Cheese{

    public GoatCheese() {
        prepareCheese();
    }

    @Override
    public void prepareCheese() {
        System.out.println("Preparing goat cheese ...");
    }
}
