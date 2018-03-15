package za.co.entelect.dojo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.entelect.dojo.config.IntegrationTestConfig;
import za.co.entelect.dojo.domain.Card;
import za.co.entelect.dojo.exceptions.AccountException;

@ContextConfiguration(classes = IntegrationTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CardIntegrationTest {

    @Autowired
    private CardDataValidationService cardDataValidationService;

    @Autowired
    private PinService pinService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CardService cardService;

    @Test(expected = AccountException.class)
    public void testInsufficientFunds() {
        cardService.withdrawMoney(getCard(true,1L), 1L);
    }

    private Card getCard(boolean validCardNumber, long balanceAvailable) {
        String cardNumber = "4929900481403641";
        if (!validCardNumber) {
            cardNumber = "4929900481403642";
        }
        String cardData = cardNumber + "1703";
        String pinBlock = "FF" + cardNumber;
        return new Card(cardData,pinBlock, balanceAvailable);
    }
}
