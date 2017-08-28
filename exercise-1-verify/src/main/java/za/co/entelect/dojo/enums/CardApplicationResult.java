package za.co.entelect.dojo.enums;

/**
 * Defined all the possible outcomes of a card application
 */
public enum CardApplicationResult {

    APPROVED(true),
    NO_BANK_ACCOUNT_DECLINED(false),
    MIN_BALANCE_DECLINED(false);

    private boolean approved;

    CardApplicationResult(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }
}
