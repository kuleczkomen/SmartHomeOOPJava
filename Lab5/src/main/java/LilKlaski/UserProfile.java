package LilKlaski;

public class UserProfile {
    private boolean isStudent;
    private int loyaltyPoints;

    public UserProfile(boolean isStudent, int loyaltyPoints){
        this.isStudent = isStudent;
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isStudent() { return isStudent; }
    public void setStudent(boolean student) { isStudent = student; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
}
