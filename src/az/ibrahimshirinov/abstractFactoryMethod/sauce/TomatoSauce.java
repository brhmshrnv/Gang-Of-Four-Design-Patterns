package az.ibrahimshirinov.abstractFactoryMethod.sauce;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class TomatoSauce implements Sauce{

    public TomatoSauce() {
        prepareSauce();
    }

    @Override
    public void prepareSauce() {
        System.out.println("Prepare tomato sauce");
    }
}
