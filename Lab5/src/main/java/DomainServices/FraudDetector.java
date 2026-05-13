package DomainServices;

import LilKlaski.User;

public class FraudDetector {
    public boolean isSuspicious(User user) {
        return user.getName() != null && user.getName().startsWith("BOT_");
    }
}
