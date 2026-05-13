package LilKlaski;

public class TicketRequest {
    private double price;
    private boolean isVip;

    public TicketRequest(double price, boolean isVip) {
        this.price = price;
        this.isVip = isVip;
    }
    public double getPrice() { return price; }
    public boolean isVip() { return isVip; }
}
