# Zadanie 1

## S - single responsibility
### Klasa **SuperPhone** była typową  *God Function*: oprócz dzwonienia i SMS-owania, łaczyła się z internetem i ładowała telefon. Teraz za łączenie się z internetem odpowiada osobna klasa **Internet**.

## O - open close
### Różne typy kamer były obsługiwane przez if/else w klasie **SuperPhone**, co oznaczało, że dodanie nowej marki oznaczało konieczność zmiany działającej już klasy. Teraz dodajemy nową markę kamer, tworząc nową klasę implementującą **CameraType**. 

## L - Liskov substitution principle
### Metoda **setCamera()** wymaga klasy implementującej **CameraType** zamiast stringa mogącego zawierać błędną nazwę. Dzięki temu nie musimy rzucać IllegalArgumentException.

## I - interface segregation
### Interfejs **IPhone** był zbyt obszerny - klasa **StaraNokia** nie była w stanie zaimplementować wszystkich metod. Dlatego stworzyłem protszy interfejs **Phone** dla **StaraNokia**. Natomiast klasa **SuperPhone** implementuje oba interfejsy - więc dalej posiada te same metody.

## D - dependency inversion
### Do komunikacji między **SuperPhone** a jego kamerami wprowadziłem klasę **PhoneCamerasManager**.

# Zadanie 2
### Dodanie nowego clouda było utrudnione przez złamanie zasady O.
### Aby otworzyć projekt na rozszerzenie, utworzyłem interfejs **CloudStorage**, aby do dodania nowej chmury wystarczyło go zaimplementować, bez modyfikowania zewnętrznych klas.
### Wprowadziłem funkcjonalność GPS. Została dodana dzięki klasie **GPS** oraz interfejsu **BatteryDevice** celem zachowania zasady L. GPS nie jest w stanie dzwonić i SMS-ować, ale też jest na baterię.
