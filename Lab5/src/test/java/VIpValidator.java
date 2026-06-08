import BigBoyz.VipLoungeAccessValidator;
import LilKlaski.User;
import LilKlaski.UserBuilder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VIpValidator {

    VipLoungeAccessValidator validator = new VipLoungeAccessValidator();

    @ParameterizedTest
    @CsvSource({
            "17, false",
            "18, true",
            "19, true"
    })
    void userAgeValidation(int age, boolean expected) {
        // given
        User user = getVipUserBuilder()
                .withAge(age)
                .build();

        // when
        boolean isVip = validator.canAccessVipLounge(user);

        // then
        assertEquals(expected, isVip);
    }

    @ParameterizedTest
    @CsvSource({
            "11, false",
            "12, true",
            "13, true"
    })
    void accountAgeValidation(int months, boolean expected) {
        // given
        User user = getVipUserBuilder()
                .withRegistrationDate(LocalDate.now().minusMonths(months))
                .build();

        // when
        boolean isVip = validator.canAccessVipLounge(user);

        // then
        assertEquals(expected, isVip);
    }

    @ParameterizedTest
    @CsvSource({
            "999, false",
            "1000, true",
            "1001, true"
    })
    void loyaltyPointsValidation(int points, boolean expected) {
        // given
        User user = getVipUserBuilder()
                .withLoyaltyPoints(points)
                .build();

        // when
        boolean isVip = validator.canAccessVipLounge(user);

        // then
        assertEquals(expected, isVip);
    }


    private UserBuilder getVipUserBuilder() {
        return new UserBuilder()
                .withName("Bill Gates")
                .withRegistrationDate(LocalDate.now().minusMonths(12))
                .withAge(18)
                .isStudent(false)
                .withLoyaltyPoints(1000);
    }

}
