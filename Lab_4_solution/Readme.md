# Laboratorium: Wzorce Projektowe w Systemie Bistro-Logic

## Wprowadzenie do projektu
W ramach dzisiejszego laboratorium będziecie rozwijać **Bistro-Logic** – nowoczesny system informatyczny do zarządzania procesami w restauracji. System ten docelowo pozwala na elastyczne budowanie menu, personalizację zamówień klientów oraz zarządzanie przepływem akcji (np. wysyłaniem zamówień do kuchni).

Aby zrealizować te założenia w sposób czysty, rozszerzalny i zgodny z dobrymi praktykami programowania obiektowego, wykorzystacie trzy wzorce projektowe:
* **Kompozyt (Composite)**
* **Dekorator (Decorator)**
* **Komenda (Command)**

## Dostarczone elementy bazowe
Na start otrzymujecie szkielet systemu w postaci bazowych klas. Z racji że w produkcyjnych projektach takie cos jak *dokumentacja* jest często opcją dodatkową (nie ma jej), po nazwach klas powinniście się domyśleć co jest czym (i tak są dość opisowe).

Elementy bazowe można zmieniać wedle swoich upodobań, nie musicie się przywiązywać do istniejących implementacji.

Waszym zadaniem jest nadbudowanie na nich docelowych funkcjonalności.
---

## Wymagania systemowe

### 1. Wielopoziomowa kalkulacja kosztów i utargu
* **Opis biznesowy:** System musi precyzyjnie wyliczać ceny na różnych poziomach działalności restauracji. Punktem wyjścia są surowe składniki posiadające swoją cenę za kilogram. Z nich tworzone są odmierzone porcje (określona waga danego składnika), które z kolei składają się na gotowe potrawy. Klienci składają zamówienia zawierające wiele potraw, a wszystkie zamówienia trafiają do rejestru dziennego. Chcemy mieć opcję pobrania ceny z dziennego rejestru, a także dla konkrentych dań. Cena dania to po prostu łączna cena składników + 10 ziko (prowizja)
* **Wzorzec:** Kompozyt (Composite)
* **Techniczne tipy** Wspólny interfejs kompozytu, przypisany do tych klas z których chcemy mieć cenę. Później może się okazać że chcemy aby inne klasy w dole drzewa też ten interfejs implementowały.
  *Uwaga* Czy ten wzorzec jest tutaj potrzebny? Można się kłócić że niekoniecznie, bo zawsze znamy klase obiektu który posiadamy, niemniej wprowadzenie go raczej nie zaszkodzi, nie wiemy co przyniesie przyszłość + tutaj jest to robione w celach ćwczeniowych, więc odpuszczamy takie dywagacje :))

### 2. Personalizacja dań dodatkami
* **Opis biznesowy:** Klienci często proszą o modyfikacje, które można zastosować do właściwie każdego dania z karty. Wśród modyfikacji wyróżniamy:
    * **`TakeawayDecorator` (Na wynos)** – dolicza stałą kwotę za opakowanie (np. 2 PLN).
    * **`ExtraSauceDecorator` (Dodatkowy sos)** – dolicza koszt sosu (3 PLN)
    * **`SpicyDecorator` (Wersja pikantna)** – dolicza drobną kwotę za ostre przyprawy/papryczki (np. 1.50 PLN).

* **Wzorzec:** Dekorator (Decorator)
* **Techniczne tipy** Chyyba samo narzucające się. Jedyne co to wymaganie 3 może tutaj leciutko coś dodać

### 3. Zarządzanie procesem zamówień
* **Opis biznesowy:** Złożenie zamówienia wiąże się paroma operacjami. Trzeba faktycznie stworzyć zamówienie, zapisać je do `DailyRegistry`, oraz z racji że dysponujemy stanem magazynowym składników (i innych elementów) zmniejszyć ilość danych składników (lub odmówić zrobienia zamówenia przez brak składników na stanie). Dodatkowo klienci czasami mogą wyjść przedwcześnie, odwołując zamówienie, lub też kelner który wklepuje je do systemu może się pomylić, więc przydałaby się opcja cofnięcia.
* **Wzorzec:** Komenda (Command)
* **Techniczne tipy** Prosta komenda przyjmująca *chyba* tylko zamówienie i realizująca wszystkie operacje wspomniane powyżej. Metoda undo po prostu robiła by to samo tylko odwrotnie. Warto rozważyć tutaj jakąś zwrotke z metody `Execute` która informowałaby o statusie wykonania komendy (sukces/brak_składników) - ogólnie jest to coś co się robi, bo lepiej *handlować rzeczy gracefuly* niż rzucać wyjątek. Dodatkowo warto przemyśleć czy może da się jakoś uprościć klasę `Warehouse`?

## Przydatne materiały

- [Prezentacja z zajęć](https://canva.link/fj399wto9wj0b62)