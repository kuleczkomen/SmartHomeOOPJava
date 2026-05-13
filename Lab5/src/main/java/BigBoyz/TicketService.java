package BigBoyz;

import LilKlaski.TicketRequest;
import LilKlaski.User;
import DomainServices.DiscountPolicy;
import DomainServices.FraudDetector;

public class TicketService {
    private final FraudDetector fraudDetector;
    private final DiscountPolicy discountPolicy;

    public TicketService(FraudDetector fraudDetector, DiscountPolicy discountPolicy) {
        this.fraudDetector = fraudDetector;
        this.discountPolicy = discountPolicy;
    }

    public double calculateFinalPrice(User user, TicketRequest request) {
        if (fraudDetector.isSuspicious(user)) {
            throw new IllegalStateException("Wykryto podejrzaną aktywność");
        }

        double discount = discountPolicy.getDiscountRate(user);
        double basePrice = request.getPrice();
        double priceAfterDiscount = basePrice - (basePrice * discount);

        return applyExtraFees(priceAfterDiscount, request);
    }

    private double applyExtraFees(double currentPrice, TicketRequest request) {
        if (request.isVip()) {
            return currentPrice + 50.0;
        }
        return currentPrice + 5.0;
    }
}