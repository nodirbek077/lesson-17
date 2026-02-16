import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Terminal {
    private Integer id;
    private String address;
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

    // yyyy.MM.dd
    public double getAmountByDay(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(dateStr, formatter); //2024-05-26

        Double totalFaire = 0.0;
        for (Transaction transaction : transactionArray){
            if (transaction != null && transaction.getCreatedDate().toLocalDate().equals(date)){
                totalFaire += transaction.getFaire();
            }
        }

        return totalFaire;
    }

    public Transaction[] transactionList() {
        return transactionArray;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
