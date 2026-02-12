public class Main {
    public static void main(String[] args) {
        Managing managing = new Managing();
        managing.setFaire(2000.0);

        Card card1 = managing.addCard(1, 3000.0);
        Card card2 = managing.addCard(2, 10000.0);
        Card card3 = managing.addCard(3, 1000.0);

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

        System.out.println(managing.addTerminal(1, "Chorsu"));
        System.out.println(managing.addTerminal(2, "Yunusobod"));

        /*System.out.println(managing.getTerminalById(1));
        System.out.println(managing.getTerminalById(11));

        Terminal[] terminals = managing.terminalList();
        for (Terminal terminal : terminals) {
            if (terminal != null) {
                System.out.println(terminal);
            }
        }*/

        System.out.println();
        System.out.println(managing.getCard(1));
        Transaction transaction1 = managing.makeTransaction(1, 1);
        System.out.println(transaction1);
        System.out.println(managing.getCard(1));

        Transaction transaction2 = managing.makeTransaction(1, 2);
        System.out.println(transaction2);
/*
        Transaction transaction3 = managing.makeTransaction(1, 3);
        System.out.println(transaction3);*/

        System.out.println();
        System.out.println(managing.getById(transaction1.getId()));
    }
}
