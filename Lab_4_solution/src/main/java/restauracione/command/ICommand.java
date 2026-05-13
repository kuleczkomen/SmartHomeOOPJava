package restauracione.command;

public interface ICommand {
    //Dodatkowe informacje
    //Jest taka zasada, że dana akcja systemu albo coś zmienia (komenda), albo coś zwraca (query)
    //Potencjalnie tutaj robimy oba
    //Ale zwrotka to tylko wynik wykonania akcji - więc jest akceptowalne
    //Natomiast rozumiem jakby ktoś wolał to podzielić sobie na metody canExecute() i execute()
    boolean tryExecute();
    void undo();
}
