package za.co.entelect.dojo.domain;

/**
 * Our domain object
 */
public class Card {

    private static final int CARD_END_INDEX = 16;
    private final String cardNumber;
    private final String pinBlock;

    private String cardData;
    private long availableBalanceInCents;

    public Card(String cardData, String aPinBlock, long aAvailableBalanceInCents) {
        this.cardData = cardData;
        cardNumber = cardData.substring(0, CARD_END_INDEX);
        pinBlock = aPinBlock;
        availableBalanceInCents = aAvailableBalanceInCents;
    }

    public String getCardData() {
        return cardData;
    }

    public void setCardData(String cardData) {
        this.cardData = cardData;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinBlock() {
        return pinBlock;
    }

    public long getAvailableBalanceInCents() {
        return availableBalanceInCents;
    }

    public void setAvailableBalanceInCents(long aAvailableBalanceInCents) {
        availableBalanceInCents = aAvailableBalanceInCents;
    }
}
