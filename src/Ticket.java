import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime buyingTime;
    private int validityTime;

    public Ticket(int validityTime) {
        this(LocalDateTime.now(), validityTime);
    }

    public Ticket(LocalDateTime buyingTime, int validityTime) {
        this.buyingTime = buyingTime;
        this.validityTime = validityTime;
    }

    public LocalDateTime getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(LocalDateTime buyingTime) {
        this.buyingTime = buyingTime;
    }

    public int getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(int validityTime) {
        this.validityTime = validityTime;
    }
}
