import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Managing {
    private Double faire;

    //Card
    private Card[] cardArray = new Card[10];
    private int cardIndex = 0;

    //Terminal
    private Terminal[] terminalArray = new Terminal[10];
    private int terminalIndex = 0;

    //Transaction
    private Transaction[] transactionArray = new Transaction[10];
    private int transactionIndex = 0;
    private int generalId = 1;

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
        for (int i = 0; i < cardArray.length; i++) {
            Card card = cardArray[i];
            if (card != null && card.getId().equals(id)) {
                return card;
            }
        }
        return null;
    }

    // cartaga pul tashlash uchun ishlatiladi.
    public Card recharge(Integer id, Double amount) {
        Card card = getCard(id);
        if (card == null) {
            return null;
        }

        Double newBalance = card.getBalance() + amount;
        card.setBalance(newBalance);
        return card;
    }

    // get card list
    public Card[] getCardList() {
        return cardArray;
    }

    //
    public Terminal addTerminal(Integer id, String address) {
        Terminal terminal = new Terminal();
        terminal.setId(id);
        terminal.setAddress(address);
        if (terminalArray.length == terminalIndex) {
            Terminal[] tempArray = new Terminal[terminalArray.length * 2];
            for (int i = 0; i < terminalArray.length; i++) {
                tempArray[i] = terminalArray[i];
            }
            terminalArray = tempArray;
        }
        terminalArray[terminalIndex++] = terminal;
        return terminal;
    }

    public Terminal getTerminalById(Integer id) {
        for (Terminal terminal : terminalArray) {
            if (terminal != null && terminal.getId().equals(id)) {
                return terminal;
            }
        }
        return null;
    }

    public Terminal[] terminalList() {
        return terminalArray;
    }
    //

    public Transaction makeTransaction(Integer terminalId, Integer cardId) {
        // 1. null  agar terminal topilmasa
        Terminal terminal = getTerminalById(terminalId);
        if (terminal == null) {
            return null;
        }

        // 2. null agar  carta topilmasa
        Card card = getCard(cardId);
        if (card == null) {
            return null;
        }

        // 3. null agar cartada yetarli pul bo'lmasa
        if (card.getBalance() < faire) {
            return null;
        }

        // 4. null agar shu 1 munit ichida  terminal va cartadan qayta foydalanilsa
        LocalDateTime checkDate = LocalDateTime.now().minusMinutes(1);
        for (Transaction transaction : transactionArray) {
            if (transaction != null &&
                    transaction.getCard().getId().equals(cardId) &&
                    transaction.getTerminal().getId().equals(terminalId) &&
                    transaction.getCreatedDate().isAfter(checkDate)) {
                return null;
            }
        }

        // 5.  agar hammasi to'g'ri bo'lsa  Transaction objecti yaratiladi
        Transaction transaction = new Transaction();
        transaction.setId(generalId++);
        transaction.setTerminal(terminal);
        transaction.setCard(card);
        transaction.setFaire(faire);
        transaction.setCreatedDate(LocalDateTime.now());

        terminal.addTransaction(transaction);
        card.addTransaction(transaction);

        if (transactionArray.length == transactionIndex) {
            Transaction[] tempArray = new Transaction[transactionArray.length * 2];
            for (int i = 0; i < transactionArray.length; i++) {
                tempArray[i] = transactionArray[i];
            }
            transactionArray = tempArray;
        }
        transactionArray[transactionIndex++] = transaction;

        // 6. Kartadan pul yechib olinishi kerak
        card.setBalance(card.getBalance() - faire);

        return transaction;
    }

    public Transaction getById(Integer id) {
        for (Transaction transaction : transactionArray) {
            if (transaction != null && transaction.getId().equals(id)) {
                return transaction;
            }
        }
        return null;
    }

    //  terminal id bo'yicha barcha  transaction lar
    public Transaction[] transactionListByTerminal(Integer terminalId) {
        Transaction[] tempArray = new Transaction[transactionIndex];
        int i = 0;
        for (Transaction transaction : transactionArray) {
            if (transaction != null && transaction.getTerminal().getId().equals(terminalId)) {
                tempArray[i] = transaction;
            }
        }
        return tempArray;
    }

    //  carta id si  bo'yicha barcha  transaction lar
    public Transaction[] transactionListByCard(Integer cardId) {
        Transaction[] tempArray = new Transaction[transactionIndex];
        int i = 0;
        for (Transaction transaction : transactionArray) {
            if (transaction != null && transaction.getCard().getId().equals(cardId)) {
                tempArray[i++] = transaction;
            }
        }
        return tempArray;
    }

    // kun bo'yicha barcha transaction lar (yyyy.MM.dd    keladigan  kun formati)
    public Transaction[] getTransactionsByDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(dateStr, formatter); //2024-05-26

        Transaction[] tempArray = new Transaction[transactionIndex];
        int i = 0;
        for (Transaction transaction : transactionArray) {
            if (transaction != null && transaction.getCreatedDate().toLocalDate().isEqual(date)) {// 2024-05-26 17:23
                tempArray[i++] = transaction;
            }
        }
        return tempArray;
    }

    // Transactionlar soni bo'yicha terminallar ro'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount() {
        return null;
    }

    //  berilgan kunda  transaction lar soni bo'yicha tartiblangan terminallar yo'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount_aDay(String day) {
        return null;
    }

    // umumiy yo'l kira xaqqini olish
    public double getTotalFaire() {
        return faire;
    }

}
