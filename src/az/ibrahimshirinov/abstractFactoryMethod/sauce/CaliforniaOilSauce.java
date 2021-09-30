package az.ibrahimshirinov.abstractFactoryMethod.sauce;

/**
 * @author IbrahimShirinov
 * @since 27.09.2021
 */
public class CaliforniaOilSauce implements Sauce{

    public CaliforniaOilSauce() {
        prepareSauce();
    }

    @Override
    public void prepareSauce() {
        System.out.println("Preparing california oil sauce");
    }
}
