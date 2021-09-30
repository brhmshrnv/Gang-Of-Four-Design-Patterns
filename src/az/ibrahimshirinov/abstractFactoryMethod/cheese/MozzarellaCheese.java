package az.ibrahimshirinov.abstractFactoryMethod.cheese;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class MozzarellaCheese implements Cheese{

    public MozzarellaCheese() {
        prepareCheese();
    }

    @Override
    public void prepareCheese() {
        System.out.println("Preparing mozzarella cheese...");
    }
}
