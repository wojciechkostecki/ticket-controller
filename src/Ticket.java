import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime purchaseDate;
    private int validFor;

    public Ticket(int validFor) {
        this(LocalDateTime.now(), validFor);
    }

    public Ticket(LocalDateTime buyingTime, int validFor) {
        this.purchaseDate = buyingTime;
        this.validFor = validFor;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getValidFor() {
        return validFor;
    }

    public void setValidFor(int validFor) {
        this.validFor = validFor;
    }

    @Override
    public String toString() {
        return "Data i czas zakupu biletu: " + purchaseDate +
                ", czas ważności biletu w minutach: " + validFor;
    }
}
