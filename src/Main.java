public class Main {
    public static void main(String[] args) {
        Managing managing = new Managing();
        managing.setFaire(2000.0);

        Card card1 = managing.addCard(1, 5000.0);
        Card card2 = managing.addCard(2, 10000.0);
        Card card3 = managing.addCard(3, 20000.0);

        /*System.out.println(managing.getCard(1));
        System.out.println(managing.getCard(100));*/

        /*System.out.println(managing.recharge(1, 9000.0));
        System.out.println(managing.recharge(11, 1000.0));
*/
        /*Card[] cardList = managing.getCardList();
        for (Card card : cardList) {
            if (card != null) {
                System.out.println(card);
            }
        }*/
        Terminal terminal1 = managing.addTerminal(1, "Chorsu");
        Terminal terminal2 = managing.addTerminal(2, "Yunusobod");

        /*System.out.println(managing.getTerminalById(1));
        System.out.println(managing.getTerminalById(11));

        Terminal[] terminals = managing.terminalList();
        for (Terminal terminal : terminals) {
            if (terminal != null) {
                System.out.println(terminal);
            }
        }*/

        Transaction transaction1 = managing.makeTransaction(1, 1);
        Transaction transaction2 = managing.makeTransaction(1, 3);
        Transaction transaction3 = managing.makeTransaction(2, 3);

/*
        Transaction transaction3 = managing.makeTransaction(1, 3);
        System.out.println(transaction3);*/

        /*System.out.println();
        System.out.println(managing.getById(transaction1.getId()));*/

//        Transaction transaction3 = managing.makeTransaction(2, 2);

        /*Transaction transaction3 = managing.makeTransaction(2, 2);
        System.out.println();
        Transaction[] transactions = managing.transactionListByTerminal(45);
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                System.out.println(transaction);
            }
        }*/

        /*Transaction[] transactionList = managing.transactionListByCard(2);
        for (Transaction transaction : transactionList) {
            if (transaction != null) {
                System.out.println(transaction);
            }
        }*/

        /*Transaction[] transactions = managing.getTransactionsByDate("2026.02.13");
        for (Transaction transaction : transactions) {
            if (transaction != null){
                System.out.println(transaction);
            }
        }*/

        //transaction list by terminal
        /*Transaction[] transactionArray = terminal1.transactionList();
        for (Transaction transaction : transactionArray){
            if (transaction != null){
                System.out.println(transaction);
            }
        }
*/
       /* Double totalFaireByDay = terminal1.getAmountByDay("2026.02.16");
        System.out.println(totalFaireByDay);
*/
        /*double spentMoneyByDay = card3.getTransactionAmountByDay("2026.02.16");
        System.out.println(spentMoneyByDay);
        */

        Transaction[] transactions = card3.todayTransactionList();
        for (Transaction transaction : transactions) {
            if (transaction != null){
                System.out.println(transaction);
            }
        }
    }
}
