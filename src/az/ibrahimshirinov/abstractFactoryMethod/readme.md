# Abstract Factory Pattern
*Abstract Factory Pattern* nədir?

Abstract Factory Pattern, bir ailənin obyektlərinin birlikdə işləməsi üçün dizayn edildiyi obyektlərin ailələrini yaratmaq üçün istifadə olunan Gang of Four creational design pattern-lərindən biridir.
Abstract Factory Pattern-də əlaqəli və ya asılı obyektlərin ailələrini yaratmaq üçün bir interfeys təmin edirsiniz, ancaq yaradılacaq obyektlərin konkret siniflərini göstərmirsiniz.
Client baxımından, bu, bir client-in obyekt anlayışlarını və konkret sinif adlarını bilmədən əlaqəli obyektlər ailəsi yarada bilməsi deməkdir.  

Abstract Factory Pattern-i Factory Method Pattern-i ilə qarışdırmaq asandır, çünki hər iki dizayn nümunəsi obyektin yaradılması ilə məşğul olur
Hər iki pattern, obyektlərin necə yaradıldığını mücərrədləşdirmək üçün "Program to an interface, not an implementation" Obyekt Yönümlü Proqramlaşdırma (OOP) prinsipini müdafiə edir.
Her iki pattern-nin oxşar xüsusiyyətlərinə və hər iki pattern-nin tez-tez birlikdə istifadəsinə baxmayaraq, aralarında nəzərə çarpacaq fərqliliklər mövcuddur.

## Abstract Factory Pattern vs Factory Method Pattern
Abstract Factory, Factory Method-una əlavə abstractlaşdırma səviyyəsi əlavə edir. Factory Method obyektlərin necə yaradıldığını abstractlaşdırır.
Abstract Factory isə həmin obyektlərin yaranmasında rolu olan fabrik(factory)lərin yaradılmasını abstractlaşdırır. Fabriklər öz növbəsində obyektlərin necə yaradıldığını abstractlaşdırır.
Tez-tez “factory of factories“ olaraq adlandırılan abstract factory method patterni barədə eşidəcəksiniz.  

İcra nöqteyi nəzərdən *factory method* ilə *abstract factory* patternləri arasındakı əsas farq budur ki, *factory method* patterni tək növ obyekt yaratmaq üçün bir üsuldur, *abstract factory* isə obyektlərin ailələrini yaratmaq üçün bir obyektdir.
Başqa bir fərq isə *factory method* patterni inheritance(varislik) istifadə edir, *abstract factory* patterni isə composition(kompozisiya) istifadə edir.
Factory Method inheritance(varislik) istifadə edir, cünki bu pattern tələb olunan obyektin hazırlanması üçün bir alt sinifə əsaslanır.
Abstract bir sinifdə *createPizza()* factory methodunu yaratdığımız və tələb olunan Pizza obyekti nümunəsi üçün *PizzaFactory* alt sinifində fabrik methodunu tətbiq etdiyimiz *Factory Method Pattern* nümunəsini xatırlayın.
Digər tərəfdən abstract factory patterni, əlaqəli obyektlərin ailəsini yaratmaq üçün ayrılmış bir obyektə(abstract factory) həvalə edir.
Daha sonra, kompozisiya vasitəsilə, abstract factory obyekti əlaqəli obyektlərin ailəsini əldə etmək üçün(factory method əvəzinə) istifadə edəcək clientə ötürə bilər.


### Nümunə

Abstract Factory Method-un necə işlədiyini başa düşmək üçün *Factory Method Pattern* yazısında hazırladığımız pizza mağazasına yenidən baxaq.
Mağaza rəhbərliyi müştəri bazasının süratlə artmağını gördü və indi mövcud pizza növlərinə: Cheese, Pepperoni və Veggie pizzalarını iki farqli üslubda təqdim etmək istəyir.
Qurman üsulu və Siciliya üsulu. Hər üsulun bəzənməsi məhsulların fərqli kombinasiyada olmağını tələb edir. Siciliyan üsulu pizza-da Goat Cheese və Tomato Sauce, Qurman üsulu pizzada isə Mozzarella Cheese və California Oil Sauce istifadə olunmalıdır.
Programda yeni tələbləri modelləmək üçün konkret *Cheese* məhsulları: *Goat Cheese*, *Mozzarella Cheese* və konkret *Sauce* məhsulları: *TomatoSauce*, *CaliforniaOilSauce* yarada bilərik.
İndi, heç bir müştərinin məhsulları birbaşa nümunələndirməsini istəmədiyimiz üçün, abstract bir fabrik yaradaraq məhsulların yaradılmasını abstract-laşdıracağıq.
*BaseToppingFactory* abstract fabrik sinifi yaradacağıq və onun da iki alt sinifini yaradacağıq: *SicillianToppingFactory* və *GourmetToppingFactory* bizim məhsullarımızı yaradacaq siniflər olacaqlar.
Beləliklə *SicilianToppingFactory*-dən *Mozzarella Cheese* və *TomatoSauce* inqredientlərindən təşkil olunan məhsulu, *GourmetToppingFactory*-dən isə *GoatCheese* və *CaliforniaOilSauce* inqredientlərindən təşkil olunan məhsulu yaratmaq üçün modelləyə bilərik.


Yenilənmiş və inkişaf etmiş pizza mağazası kontekstində abstract factory pattern komponentlərini ümumiləşdirək.

**AbstractProduct**( *Cheese* və *Sauce*): Alt sinifləri abstract factory obyektləri tərəfindən yaradılan bir interface və ya abstract class ola bilər.  
**ConcreteProduct**  (*GoatCheese*, *MozzarellaCheese*, *TomatoSauce*, və *CaliforniaOilSauce*): AbstractProduct-u extend/implement edən alt siniflərdir. Abstract Factory obyektləri bu altsinifləri abstractlaşdırır.  
**AbstractFactory** (*BaseToppingFactory*): Alt sinifləri bir *AbstractProduct* obyektləri ailəsini başladan bir interface vəya abstract sinif-dir.  
**ConcreteFactory** (*SicillianToppingFactory* və *GourmetToppingFactory*): *AbstractFactory*-ni implement/extend edən konkret altsiniflərdir. Bu altsinifin bir obyekti, *AbstractProduct* obyektləri ailəsini təcəssüm etdirir.  
**Client**: *AbstractProduct* obyektlərini əldə etmək üçün *AbstractFactory*-ni istifadə edir.

### Abstract Factory Pattern-in tətbiqi

Abstract Factory Pattern-ini proqramda tətbiq etmək üçün, əvvəlcə fabriklərin istehsal edəcəyi məhsulları yaradaq.

**Cheese.java**
```java
public interface Cheese {
     void prepareCheese();
}
```
**GoatCheese.java**
```java
public class GoatCheese implements Cheese {
    public  GoatCheese(){
       prepareCheese();
    }
    @Override
    public void prepareCheese(){
        System.out.println("Preparing goat cheese...");
    }
}
```
**MozzarellaCheese.java**
```java
public class MozzarellaCheese implements Cheese{
    public  MozzarellaCheese(){prepareCheese();
    }
    @Override
    public void prepareCheese() {
        System.out.println("Preparing mozzarella cheese...");
    }
}
```
**Sauce.java**
```java
public interface Sauce {
     void prepareSauce();
}
```
**TomatoSauce.java**
```java
public class TomatoSauce implements Sauce {
    public TomatoSauce(){
        prepareSauce();
    }
     @Override
    public void prepareSauce() {
        System.out.println("Preparing tomato sauce..");
    }
}
```

**CaliforniaOilSauce.java**
```java
public class CaliforniaOilSauce implements Sauce {
    public CaliforniaOilSauce(){
        prepareSauce();
    }
    @Override
    public void prepareSauce() {
        System.out.println("Preparing california oil sauce..");
    }
}
```

Yuxarıda göstərilən nümunədə **Cheese** interface-ini yaratdıq, hansı ki bir **AbstractProduct**-dır.
Daha sonra isə **GoatCheese** və **MozzarellaCheese** siniflərini yaratdıq, hansı ki **Cheese** interface-ni implement edən **ConcreteProduct**-lardır.
Eyniylə pizza sousu üçün, əvvəlcə **Sauce** interface-ini yaratdıq. Daha sonra bu interface-i implement edən **TomatoSauce** və **CaliforniaOilSauce** siniflərini yaratdıq.  

Növbəti olaraq məhsulları yaratması üçün factory-ləri yaradacağıq. Əvvəlcə abstract factory ilə başlayaq.

**BaseToppingFactory.java**
```java
public abstract class BaseToppingFactory {
    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}
```

Yuxarıdakı nümunədə proqramımızın abstract fabriki olan **BaseToppingFactory** abstract sinifini yazdıq. Abstract fabrikdə sırası ilə **Cheese** və **Sauce** inqredientlərinin obyektlərini qaytaran *createCheese()* və *createSauce()* abstract metodlarını elan edirik.
Daha əvvəl mücərrəd fabrik tərifində deyildiyi kimi, abstract fabrikimiz (BaseToppingFactory) "*əlaqəli və ya asılı obyektlərin ailələrini yaratmaq üçün bir interfeys*" təqdim edir.
Buradakı əlaqəli obyektlər, hər ikisi birlikdə pizza yaratmaq üçün istifad olunan *Cheese* və *Sauce*-dır.
Tərifdə də deyildiyi kimi "*... ancaq yaratmaq üçün obyektlərin konkret siniflərini təyin etmirsiniz*"
BaseToppingFactory kodunda gördüyünüz kimi, abstract fabrikimiz heç bir konkret productla əlaqəli deyil:  *GoatCheese*, *MozzarellaCheese*, *TomatoSauce*, or *CaliforniaOilSauce*.
İndi **ConcreteFactory** implementasiyalarını yazaq.

**SicillianToppingFactory.java**
```java
public class SicilianToppingFactory extends BaseToppingFactory{
    @Override
    public  Cheese createCheese(){return new MozzarellaCheese();}
    @Override
    public  Sauce createSauce(){return new TomatoSauce();}
}
```

**GourmetToppingFactory.java**
```java
public class GourmetToppingFactory extends BaseToppingFactory{
    @Override
    public Cheese createCheese(){return new GoatCheese();}
    @Override
    public Sauce createSauce(){return new CaliforniaOilSauce();}
}
```


