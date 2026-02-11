public class Card {
    private Integer id;
    private Double balance;

    // bugungi transaction lar ro'yxati
    public Transaction[] todayTransactionList() {
        return null;
    }

    // xozirgi balansdagi pul
    public double currentAmount() {
        return 0.0;
    }

    // berilgan kun bo'yicha ishlatilgan pul miqdori yyyy.MM.dd
    public double getTransactionAmountByDay(String date) {
        return 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
