import com.google.common.eventbus.EventBus;

public class User {
    private int userId;
    private String email;
    private UserType type;
    private final EventBus eventBus;

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

    public User(int userId, String email, UserType type, EventBus eventBus) {
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.eventBus = eventBus;
    }

    public void changeEmail(int userId, String newEmail) {
        // Pobranie danych użytkownika z bazy danych
        Object[] data = Database.getUserById(userId);
        this.userId = userId;
        this.email = (String) data[1];
        this.type = (UserType) data[2];

        if (this.email.equals(newEmail)) {
            return;
        }

        // Pobranie danych firmy z bazy danych
        Object[] companyData = Database.getCompany();
        String companyDomainName = (String) companyData[0];
        int numberOfEmployees = (Integer) companyData[1];

        // Wyznaczenie nowego typu użytkownika na podstawie domeny
        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(companyDomainName);
        UserType newType = isEmailCorporate ? UserType.Employee : UserType.Customer;

        // Aktualizacja liczby pracowników, jeśli typ uległ zmianie
        if (this.type != newType) {
            int delta = newType == UserType.Employee ? 1 : -1;
            int newNumber = numberOfEmployees + delta;
            Database.saveCompany(newNumber);
        }

         this.email = newEmail;
         this.type = newType;
         Database.saveUser(this);

        MessageBus.sendEmailChangedEvent(new EmailChangedEvent(this.userId, this.email, this.type));
    }
}