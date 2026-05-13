package BigBoyz;

import LilKlaski.User;

import java.time.LocalDate;
import java.time.Period;

public class VipLoungeAccessValidator {

    public boolean canAccessVipLounge(User user) {
        if (user == null || user.getProfile() == null || user.getRegistrationDate() == null) {
            return false;
        }

        int accountAgeYears = Period.between(user.getRegistrationDate(), LocalDate.now()).getYears();

        if (accountAgeYears >= 1 && user.getAge() >= 18) {
            return user.getProfile().getLoyaltyPoints() >= 1000;
        }

        return false;
    }
}