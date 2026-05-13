# Laboratorium: Wstęp do testowania

Na tych zajęciach postawimy pierwsze kroki w świecie testów. Skupimy się na trzech głównych obszarach:
* **Dlaczego** w ogóle warto testować kod?
* **Jak** technicznie pisać dobre testy?
* **Co** warto testować, a co lepiej odpuścić (w pigułce).

### O projekcie
Projekt testowy celowo nie jest skomplikowany. – zależy nam na tym, abyście mogli skupić się wyłącznie na mechanikach testowania, a nie na rozszyfrowywaniu zawiłego kodu.

### Rozkład jazdy
Plan gry jest następujący: na początku dostajecie około 15-20 minut na samodzielne napisanie testów (jednostkowych, integracyjnych – pełna dowolność) bazując na Waszej obecnej wiedzy. Następnie wspólnie omówimy Wasze podejścia i zastanowimy się, na ile ta implementacja się sprawdza i co można zrobić lepiej.

Nie oczekuje że zdążycie zaimplementować wszystko, także róbcie kroki w poniższej kolejności, żeby najważniejsze rzeczy były zrobione:

1. **Analiza i szkielet:** Przeanalizujcie kod i zdecydujcie, jakie testy chcecie napisać. Stwórzcie na razie same sygnatury (pliki testowe, nazwy metod, bez implementacji).  Jak uznacie że kod wymaga zmian w celach testowania feel free
2. **Pierwsze starcie:** Zaimplementujcie testy dla metody `CanAccessVipLounge()` w klasie `VipLoungeAccessValidator`.
3. **Drugie starcie:** Napiszcie testy dla metody `calculateFinalPrice()` w klasie `TicketService`.
4. **Reszta:** Jeśli zostanie Wam czas, pokryjcie testami pozostałe elementy.

### Narzędziówka (Co znajdziecie w projekcie)

Do projektu zostały dorzucone świetne i sprawdzone na rynku biblioteki, które bardzo ułatwiają życie:

* **JUnit 5 (Jupiter)** – absolutna podstawa i rynkowy standard do uruchamiania testów. Właściwie załatwia nam wszystko. 
  > *Mała uwaga: w naszym `build.gradle` używamy paczki agregującej, która ściąga wszystko od razu. Jeśli w innych projektach zobaczycie osobno importowane pakiety api/engine, pamiętajcie, że do używania bardziej zaawansowanych funkcji (np. `@ParameterizedTest`) trzeba sobie jawnie dociągnąć paczkę `junit-jupiter-params`.*
* **Mockito** – najpopularniejsze narzędzie do tworzenia mocków (zaślepek). Pozwala nam "udawać" działanie zewnętrznych klas, tak aby móc przetestować interesujący nas fragment kodu w pełnej izolacji.
* **AssertJ** – Wprowadza *Fluent API*, dzięki czemu nasze sprawdzanie warunków brzmi niemal jak naturalny język angielski (np. `assertThat(result).isEqualTo(expected)`). Bardzo wygodne, przejrzyste i przyjemne w użyciu.

### Materiały

* [Prezentacja z zajęć](https://canva.link/58qgrluysu5ak40)
* [Prezentacja z Programowania Obiektowego](https://www.canva.com/design/DAF6FVjz1Wc/IqWlFPIJMEHg9Qpd93Pcyw/view?utm_content=DAF6FVjz1Wc&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=h21660778f0)