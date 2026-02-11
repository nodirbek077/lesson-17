public class Managing {
    private Double faire;
    private Card[] cardArray = new Card[10];
    private int cardIndex = 0;

    // yo'l xaqqini o'rnatish (2,000)
    public void setFaire(Double faire) {
        this.faire = faire;
    }

    // card yaratadi
    public Card addCard(Integer id, Double balance) {
        Card card = new Card();
        card.setId(id);
        card.setBalance(balance);

        if (cardArray.length == cardIndex) {
            Card[] tempCardArray = new Card[cardArray.length * 2];
            for (int i = 0; i < cardArray.length; i++) {
                tempCardArray[i] = cardArray[i];
            }
            cardArray = tempCardArray;
        }
        cardArray[cardIndex++] = card;
        return card;
    }

    // get card by id
    public Card getCard(Integer id) {
        return null;
    }

    // cartaga pul tashlash uchun ishlatiladi.
    public Card recharge(Integer id, double amount) {
        return null;
    }

    // get card list
    public Card[] getCardList() {
        return null;
    }

    //
    public Terminal addTerminal(Integer id, String address) {
        return null;
    }

    public Terminal getTerminalById(Integer id) {
        return null;
    }

    public Terminal[] terminalList() {
        return null;
    }
    //

    public Transaction makeTransaction(Integer terminalId, Integer cardId) {
        // 1. null  agar terminal topilmasa
        // 2. null agar  carta topilmasa
        // 3. null agar cartada yetarli pul bo'lmasa
        // 4. null agar shu 1 munit ichida  terminal va carta dan qayta foydalanilsa
        // 5.  agar hammasi to'g'ri bo'lsa  Transaction objecti

        return null;
    }

    public Transaction getById(Integer id) {
        return null;
    }

    //  terminal id bo'yicha barcha  transaction lar
    public Transaction[] transactionListByTerminal(Integer terminalId) {
        return null;
    }

    //  carta id si  bo'yicha barcha  transaction lar
    public Transaction[] transactionListByCard(Integer cardId) {
        return null;
    }

    // kun bo'yicha barcha transaction lar (yyyy.MM.dd    keladigan  kun formati)
    public Transaction[] getTransactionsByDate(String data) {
        return null;
    }

    // Transactionlar soni bo'yicha  terminallar ro'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount() {
        return null;
    }

    //  berilgan kunda  transaction lar soni bo'yicha tartiblangan terminallar yo'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount_aDay(String day) {
        return null;
    }

    // umumiy yo'l kira xaqqini olish
    public double getTotalFaire() {
        return 0.0;
    }

}
