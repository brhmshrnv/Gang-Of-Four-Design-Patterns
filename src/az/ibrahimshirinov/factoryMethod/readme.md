# Factory Method Pattern
*Factory method nədir?*

Java programlarında siniflərin obyektlerini yaratmaq üçün tez-tez "new" operatorundan istifadə edirik.
Bu, kiçik java programları üçün yaxşıdır. Ancaq nə vaxt ki böyük programlarda işləyirik, obyektləri yaratmaq ucun yazdığımız kodlar getdikcə artır
və program daxilində hər yerə səpələnir. Əgər siniflərin adları bu cür kodda sabit formada kodlanibsa, programa yeni siniflər əlavə olunduqca kodu idarə etmek getdikcə çətinləşəcək.
Bu cür problemləri aradan qaldırmaq üçün **factory method** istifadə etməliyik. Bu pattern obyektləri yaratmaq üçün olan bir **creational design pattern**-dir.
Adından da başa düşüldüyü kimi **factory method pattern** obyektləri yaratmaq üçün fabrik kimi siniflərdən istifadə edir.
Bu pattern obyektləri yaratmaq üçün konstruktorları çağırmaq əvəzinə metodları çağırır.


Factory Method-da obyektleri yaratmaq üçün bir interfeys istifadə edirsiniz. Bu **İnterface** və ya **Abstract class** ola bilər.
İnterfeysdəki factory method runtime zamani obyektlərin yaranmasını, bir vəya bir neçə alt sinifə tapşırır.
Altsiniflər obyektlərinin yaranması lazım olan sinifi seçmək üçün factory methodu istifadə edir.


### Nümunə
Factory method-un necə işlədiyini başa düşmək üçün pizza mağazası fikirləşin.
Programınızda  pizzaları yaratmaq üçün  konkret **Pizza** obyektleri, hansı ki **CheesePizza**, **PepperoniPizza**, **VeggiePizza** kimi modelləyə bilərsiniz.
Pizza mağazalarında olduğu kimi, müştəri ancaq pizza sifarişi verə bilər, pizzanı bişirə bilməz.
Programınızda **BasePizzaFactory** adında bir abstract sinif və daxilində pizza yaratmaq üçün abstract bir metod yarada bilərsiniz.
Factory metodu implement etmək üçün **PizzaFactory** adında BasePizzaFactory-nin alt sinifini yarada bilərsiniz.
Factory metodda eyni Pizza obyektini yarada və geri döndürə bilərsiniz.

### Pizza mağazası kontekstində  factory method komponentlərini belə ümumiləşdirmək olar.
**Product** (Pizza) : Alt sinifləri fabrik metodu ilə yaradılan bir interfeys və ya mücərrəd bir sinifdir.  

**ConcreteProduct** (CheesePizza, PepperoniPizza və VeggiePizza) : **Product**-ı implement/extend edən altsiniflər.  

**Creator** (BasePizzaFactory) : **Product** tipində bir obyekt geri qaytaran interface/abstract sinifdir.  

**ConcreteCreator** (PizzaFactory) :  factory metodu implement edən və **Client**-e qaytarmaq üçün object yaradan konkret sinifdir.  

**Client** : **Product** üçün  **Creator**-a sorğu verən sinif.

Bir **ConcreteProduct** istəyən **Client** hər hansısa bir obyekt yaratmaz, bunun yerinə **Creator**-dan  istəyər.
**ConcreteCreator** müştəriyə göstərmədən obyekti yaratmaq üçün factory methodunu implement edir.
Nəticədə **Client**-in **ConcreteProduct**-ın obyekti və bunların necə yaradıldığını bilməsinə ehtiyac yoxdur. 
Bu yanaşma obyektyönümlü programlaşdırmanın əsas prinsiplərindən olan polimorfizmə aid olan "**Program to an interface, not an implementation**" fəlsəfəsinə əsaslanır."
Əlavə olaraq obyektin yaradılması **ConcreteCreator**-da baş verdiyindən bir **Product** və ya  hər hansısa **ConcreteProduct**-da olan dəyişiklik **Client**-ə təsir etmir.

### Factory Method Pattern-in tətbiqi

**Factory Method Pattern**-ini pizza mağazası proqramında tətbiq etmək üçün ilk növbədə abstract **Pizza** sinifini və onun alt siniflərini yaratmalıyıq.  
**Pizza.java**
```java
public abstract class Pizza {
    public abstract void addIngredients();

    public void bakePizza() {
        System.out.println("Pizza baked at 400 for 20 minutes.");
    }
}
```

**CheesePizza.java**
```java
public class CheesePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for cheese pizza.");
    }
}
```

**PepperoniPizza.java**
```java
public class PepperoniPizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for pepperoni pizza.");
    }
}
```

**VeggiePizza.java**
```java
public class VeggiePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for veggie pizza.");
    }
}
```

Yuxarıda göstərilən nümunədə **Pizza** sinifi və daxilində abstract **addİngredients()** metodu və **bakePizza()** metodu yaradılıb.
Daha sonra  **Pizza** sinifinin  alt sinifləri olan **CheesePizza**, **PepperoniPizza**, **VeggiePizza** yaradılıb və **Pizza** sinifinin **addİngredients()** metodunu override edib.
Altsiniflər **Pizza** sinifinin **bakePizza()** metodunu inherit edirlər.

Növbəti olaraq abstract **BasePizzaFactory** sinifini yaradılır, hansı ki programda **Creator** rolunu oynayır.  

**BasePizzaFactory.java**
```java
public abstract class BasePizzaFactory {
    
    public abstract Pizza createPizza(String type);
}
```

Yuxarıda göstərilən nümunədə **BasePizzaFactory** sinifi və **createPizza()** factory method-u yazılıb. Diqqət yetirdinizsə **createPizza()** metodu abstract göstərilib. Factory metodunun tətbiqini
biz bu sinifin alt sinifi vasitəsilə edəcəyik. **PizzaFactory** sinifi bu proqramda **ConcreteCreator** rolunda olacaq.

**PizzaFactory.java**
```java
public class PizzaFactory extends BasePizzaFactory{
    @Override
    public  Pizza createPizza(String type){
        Pizza pizza;
        switch (type.toLowerCase())
        {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
            default: throw new IllegalArgumentException("No such pizza.");
        }
        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}
```

Yuxarıda göstərilən nümunədə **PizzaFactory** sinifi və daxilində **createPizza()** factory methodu override edilib.  
**createPizza()** factory methodunda qebul etdiyi parameter əsasında  Pizza yaratmaq üçün **switch** operatoru istifadə olunub.
Daha sonra obyekt geri qaytarılmamışdan əvvəl **addIngredients()** və **bakePizza()** metodları tətbiq edilib.


Və sonda aşağıda nümunədə göstərildiyi kimi factory metoduna müxtəlif *String* tipli parameterlər veririk. Bu parameter factory-ə bizim hansı növdə pizza istədiyimizi deyir.  

**FactoryMethod.java**
```java
public class FactoryMethod {
    
    public static void main(String[] args) {

        BasePizzaFactory factory = new PizzaFactory();
        Pizza cheesePizza=factory.createPizza("cheese");
        Pizza veggiePizza=factory.createPizza("veggie");

    }
}
```
Yuxarıda gördüyünüz kimi **Client** özü birbaşa heç bir obyekt yaratmadı. Əgər proqramın yeni versiyası yazılmalı olarsa bu halda client kodunda dəyişikliyə ehtiyyac qalmayacaq.
Bizi lazımi obyektlə təmin etməsi üçün **Creator**-a etibar edə bilərik
