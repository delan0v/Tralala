package com.example.vaadin.calculejter;

/**
 * Created by Błażej on 30.06.2016.
 */
// TODO - UWAGA! Tutaj można przyświrować - jeśli oznaczysz tę klasę adnotacją @Compononent to wtedy można ją wstrzykiwać adnotacją @Autowired :)
    // To znaczy, że nie musisz (a nawet nie powinieneś) robić ... = new DegreeCalculator - czyli wystarczy samo @Autowired DegreeCalculator degreeCalculator;
    // tak jak  w PoczatkoweView.java
public class DegreeCalculator{
    // TODO - nie potrzebujesz zmiennej dla tej klasy - zmienna equals powinna być lokalna dla każdej metody :) lepiej bo jak
    // stworzysz obiekt to nie musisz go za każdym razem odświeżać :) <3
    double equals;
    //TODO Rób odstępy miedzy zmiennymi a metodami
    //TODO KURWA!!! Nazwa metod z mały liter - wybacz przekleństwo, ale to konieczne! !!! Ogromny błąd!! Tylko klasy z wielkich liter!!!
    public String CelciusToFahrenheit(String celcius) {
        try{
            equals = (Double.parseDouble(celcius) * 1.8) + 32;
            //TODO użyj String.format żeby ograniczyc liczbę dziesiętną do dwóch miejsc po przecinku - albo inaczej - pełna dowolność :)
            return String.valueOf(equals);
        }
        // TODO jeśli robisz parseDouble - bardzo dobrze ! ale powinnieneś łapać szczegółowsze wyjątki : np NumberFormatException,
        // wtedy wiesz , że to błąd wpisania liczby, a Exception nie mówi wszystkiego :)
        catch (Exception e){
            return("Ustawiłeś złe dane");
        }
    }
    // TODO to co wyżej
    public String FafrenheitToCelcius(String fahrenheit){
        try {
            equals = (Double.parseDouble(fahrenheit) - 32) / 1.8;
            return String.valueOf(equals);
        }
        catch(Exception e){
            return("Ustawiłeś złe dane");
        }
    }
}
