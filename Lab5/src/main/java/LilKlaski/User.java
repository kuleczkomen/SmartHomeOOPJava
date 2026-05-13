package LilKlaski;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String name;
    private LocalDate registrationDate;
    private int age;
    private UserProfile profile;

    public User(String name, LocalDate registrationDate, int age, UserProfile userProfile){
        this.name = Objects.requireNonNull(name, "nie można nulla");
        this.registrationDate = Objects.requireNonNull(registrationDate, "nie można nulla");
        setAge(age);
        setProfile(profile);
    }

    public void setProfile(UserProfile profile) { this.profile = Objects.requireNonNull(profile, "nie można nulla"); }


    public String getName() { return name; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public UserProfile getProfile() { return profile; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 13 || age > 100) {
            throw new IllegalArgumentException("Wiek musi być w przedziale 13-100");
        }
        this.age = age;
    }
}
