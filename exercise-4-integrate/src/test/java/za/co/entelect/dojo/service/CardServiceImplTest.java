package za.co.entelect.dojo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.entelect.dojo.domain.Card;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.AccountException;
import za.co.entelect.dojo.exceptions.ValidationException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceImplTest {

    @Mock
    private CardDataValidationService cardDataValidationService;

    @Mock
    private PinService pinService;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private CardService cardService = new CardServiceImpl();

    @Before
    public void setUp() {
        resetAll();
    }

    @Test
    public void testWithdrawMoneySuccess() {
        /*doNothing().when(cardDataValidationService).isValid(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doNothing().when(accountService).withdrawMoney(any(Card.class), anyDouble(), anyDouble());*/
        Card card = getCard(true, 100L);
        cardService.withdrawMoney(card, 200L);

        verify(cardDataValidationService).isValid(anyString());
        verify(pinService).validatePin(anyString(), anyString());
        verify(accountService).withdrawMoney(eq(card), anyLong(), anyLong());
    }

    @Test
    public void testInsufficientFunds() {
        when(cardDataValidationService.isValid(anyString())).thenReturn(true);
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doThrow(new AccountException(CardValidationErrorType.INSUFFICIENT_FUNDS)).when(accountService).withdrawMoney(any(Card.class), anyLong(), anyLong());
        try {
            cardService.withdrawMoney(getCard(true,100L), 200L);
        } catch (AccountException e) {
            Assert.assertEquals(CardValidationErrorType.INSUFFICIENT_FUNDS, e.getCardValidationErrorType());
        }
    }

    @Test(expected = ValidationException.class)
    public void testInvalidPin() {
        when(cardDataValidationService.isValid(anyString())).thenReturn(true);
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doThrow(new ValidationException(CardValidationErrorType.INVALID_PIN)).when(pinService).validatePin(anyString(),anyString());
        cardService.withdrawMoney(getCard(true,100L), 200L);
    }

    @Test
    public void testBankCharge() {
        when(cardDataValidationService.isValid(anyString())).thenReturn(true);
        doNothing().when(pinService).validatePin(anyString(), anyString());
        ArgumentCaptor<Card> argument = ArgumentCaptor.forClass(Card.class);
        Card card = getCard(true,100L);
        cardService.withdrawMoney(card, 200L);
        verify(accountService).withdrawMoney(argument.capture(), anyLong(), anyLong());
        Assert.assertEquals(argument.getValue().getCardData(), card.getCardData());
    }

    private void resetAll() {
        reset(cardDataValidationService, pinService, accountService);
    }

    private Card getCard(boolean validCardNumber, long balanceAvailable) {
        String cardNumber = "4929900481403641";
        if (!validCardNumber) {
            cardNumber = "492990048140";
        }
        String cardData = cardNumber + "1703101";
        String pinBlock = "FF" + cardNumber;
        return new Card(cardData,pinBlock, balanceAvailable);
    }
}