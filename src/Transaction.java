import java.time.LocalDateTime;

public class Transaction {
    private Integer id;
    private Terminal terminal;
    private Card card;
    private Double faire;
    private LocalDateTime createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Double getFaire() {
        return faire;
    }

    public void setFaire(Double faire) {
        this.faire = faire;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", terminal=" + terminal +
                ", card=" + card +
                ", faire=" + faire +
                ", createdDate=" + createdDate +
                '}';
    }
}
