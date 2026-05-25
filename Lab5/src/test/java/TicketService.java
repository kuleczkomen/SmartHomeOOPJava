import DomainServices.DiscountPolicy;
import DomainServices.FraudDetector;
import LilKlaski.TicketRequest;
import LilKlaski.User;
import LilKlaski.UserBuilder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

public class TicketService {


    @ParameterizedTest
    @CsvSource({
            "false, false",
            "true, true"
    })
    void suspiciousUserHandled(boolean isSuspicious, boolean expected) {
        // given
        User user = (isSuspicious) ? getSuspiciousUser() : getBasicUser().build();
        TicketRequest request = getBasicTicketRequest();
        BigBoyz.TicketService sut = getBasicTicketService();
        boolean userFoundSuspicious = false;

        // when
        try {
            sut.calculateFinalPrice(user, request);
        } catch (IllegalStateException e) {
            userFoundSuspicious = true;
        }

        // then
        assertEquals(expected, userFoundSuspicious);
    }

    @ParameterizedTest
    @CsvSource({
            "100.0, false, false",
            "100.0, true, false",
            "100.0, true, true",
            "100.0, false, true",
    })
    void calculateFinalPrice(double basePrice, boolean isStudent, boolean isVip) {
        // given
        BigBoyz.TicketService sut = getBasicTicketService();
        TicketRequest request = new TicketRequest(basePrice, isVip);
        User user = getBasicUser()
            .isStudent(isStudent)
            .build();
        double discount = (isStudent) ? 0.2 : 0.0;
        double extraFee = (isVip) ? 50.0 : 5.0;

        // when
        double expected = basePrice - (basePrice * discount) + extraFee;

        // then
        assertEquals(expected, sut.calculateFinalPrice(user, request));
    }

    private User getSuspiciousUser() {
        return getBasicUser()
                .withName("BOT_")
                .build();
    }

    private UserBuilder getNonVipUser() {
        return getBasicUser()
                .withRegistrationDate(LocalDate.now().minusMonths(11))
                .withAge(17)
                .withLoyaltyPoints(999);
    }

    private UserBuilder getBasicUser() {
        return new UserBuilder()
                .withName("Bill Gates")
                .withRegistrationDate(LocalDate.now().minusMonths(12))
                .withAge(18)
                .isStudent(false)
                .withLoyaltyPoints(1000);

    }
    private BigBoyz.TicketService getBasicTicketService() {
        return new BigBoyz.TicketService(new FraudDetector(), new DiscountPolicy());
    }

    private TicketRequest getBasicTicketRequest() {
        return new TicketRequest(10.0, false);
    }
}
