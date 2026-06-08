import com.google.common.eventbus.EventBus;

public class MessageBus {
    // Statyczna instancja szyny - jedna na całą aplikację
    private static final EventBus eventBus = new EventBus();

    // Metoda przyjmująca event i wysyłająca go dalej
    public static void sendEmailChangedEvent(EmailChangedEvent event) {
        eventBus.post(event);
        System.out.println("MessageBus (Static): Wysłano zdarzenie dla użytkownika ID: " + event.getUserId());
    }
}