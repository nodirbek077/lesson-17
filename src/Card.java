import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Card {
    private Integer id;
    private Double balance;
    private Transaction[] transactionArray = new Transaction[10];
    private int transactionIndex = 0;

    public void addTransaction(Transaction transaction) {
        if (transactionArray.length == transactionIndex) {
            Transaction[] tempArray = new Transaction[transactionArray.length * 2];
            for (int i = 0; i < transactionArray.length; i++) {
                tempArray[i] = transactionArray[i];
            }
            transactionArray = tempArray;
        }

        transactionArray[transactionIndex++] = transaction;
    }

    // bugungi transaction lar ro'yxati
    public Transaction[] todayTransactionList() {
        LocalDate today = LocalDate.now();
        Transaction[] tempArray = new Transaction[transactionIndex];
        int tempIndex = 0;
        for (Transaction transaction : transactionArray){
            if (transaction != null && transaction.getCreatedDate().toLocalDate().isEqual(today)) {
                tempArray[tempIndex++] = transaction;
            }
        }

        return tempArray;
    }

    // xozirgi balansdagi pul
    public double currentAmount() {
        return balance;
    }

    // berilgan kun bo'yicha ishlatilgan pul miqdori yyyy.MM.dd
    public Double getTransactionAmountByDay(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(dateStr, dateTimeFormatter);

        Double spentMoney = 0.0;
        for (Transaction transaction : transactionArray){
            if (transaction != null && transaction.getCreatedDate().toLocalDate().isEqual(date)){
                spentMoney += transaction.getFaire();
            }
        }
        return spentMoney;
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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
