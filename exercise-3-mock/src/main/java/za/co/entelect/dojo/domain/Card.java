package za.co.entelect.dojo.domain;

/**
 * Our domain object
 */
public class Card {

    private final String cardNumber;
    private final String pinBlock;

    private String track2;
    private long availableBalanceInCents;

    public Card(String aTrack2, String aPinBlock, long aAvailableBalanceInCents) {
        track2 = aTrack2;
        cardNumber = aTrack2.substring(1,17);
        pinBlock = aPinBlock;
        availableBalanceInCents = aAvailableBalanceInCents;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String aTrack2) {
        track2 = aTrack2;
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
