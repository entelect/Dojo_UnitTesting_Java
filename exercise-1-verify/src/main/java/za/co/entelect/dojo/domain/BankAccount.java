package za.co.entelect.dojo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Models the clients bank account, to apply for a card
 */
public class BankAccount {

    private long balanceInCents;

    public BankAccount(long balanceInCents) {
        this.balanceInCents = balanceInCents;
    }

    public boolean hasPositiveBalance(){
        return balanceInCents >= 0;
    }

    public long getBalanceInCents() {
        return balanceInCents;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
