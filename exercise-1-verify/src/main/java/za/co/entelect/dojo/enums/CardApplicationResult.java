package za.co.entelect.dojo.enums;

public enum CardApplicationResult {

    APPROVED(true),
    NO_BANK_ACCOUNT_DECLINED(false),
    UNEMPLOYED_OVERDRAFT_DECLINED(false),
    EMPLOYED_OVERDRAFT_DECLINED(false),
    MIN_BALANCE_DECLINED(false);

    private boolean approved;

    CardApplicationResult(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }
}
