package DomainServices;

import LilKlaski.User;
import LilKlaski.UserProfile;

public class DiscountPolicy {
    public double getDiscountRate(User user) {
        return user.getProfile().isStudent() ? 0.2 : 0.0;
    }
}
