public class EmailChangedEvent {
    private final int userId;
    private final String newEmail;
    private final UserType type;

    public EmailChangedEvent(int userId, String newEmail, UserType type) {
        this.userId = userId;
        this.newEmail = newEmail;
        this.type = type;
    }

    public int getUserId() { return userId; }
    public String getNewEmail() { return newEmail; }
    public UserType getType() { return type; }
}