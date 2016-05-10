package za.co.entelect.dojo;

/**
 * Our domain object
 */
public class Card {
    private String track2;
    private String cardNumber;
    private String pinBlock;
    private double availableBalance;

    public Card(String aTrack2, String aPinBlock, double aAvailableBalance) {
        track2 = aTrack2;
        cardNumber = aTrack2.substring(1,17);
        pinBlock = aPinBlock;
        availableBalance = aAvailableBalance;
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

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double aAvailableBalance) {
        availableBalance = aAvailableBalance;
    }
}
