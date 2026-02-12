public class Terminal {
    private Integer id;
    private String address;

    // yyyy.MM.dd
    public double getAmountByDay(String date) {
        return 0.0;
    }

    public Transaction[] transactionList() {
        return null;
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
