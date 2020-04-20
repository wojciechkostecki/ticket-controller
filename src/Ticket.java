import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

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

    @Override
    public String toString() {
        return "Data i czas zakupu biletu: " + buyingTime +
                ", czas ważności biletu w minutach: " + validityTime;
    }
}
