package LilKlaski;

import java.time.LocalDate;

public class UserBuilder {

    private String name = "Bill Gates";
    private LocalDate registrationDate = LocalDate.now().minusMonths(12);
    private int age = 18;
    private boolean isStudent = false;
    private int loyaltyPoints = 1000;

    public UserBuilder() {}

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withRegistrationDate(LocalDate date) {
        this.registrationDate = date;
        return this;
    }

    public UserBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder isStudent(boolean isStudent) {
        this.isStudent = isStudent;
        return this;
    }

    public UserBuilder withLoyaltyPoints(int points) {
        this.loyaltyPoints = points;
        return this;
    }

    public User build() {
        UserProfile freshProfile = new UserProfile(isStudent, loyaltyPoints);
        return new User(name, registrationDate, age, freshProfile);
    }


}
