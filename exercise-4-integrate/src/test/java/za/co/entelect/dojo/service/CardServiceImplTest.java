package za.co.entelect.dojo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.entelect.dojo.Card;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.AccountException;
import za.co.entelect.dojo.exceptions.ValidationException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceImplTest {

    @Mock
    private ValidationService validationService;

    @Mock
    private PinService pinService;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private CardServiceImpl cardService;

    @Before
    public void setUp() {
        resetAll();
    }

    @Test
    public void testHappyCase() {
        /*doNothing().when(validationService).validateTrackData(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doNothing().when(accountService).withdrawMoney(any(Card.class), anyDouble(), anyDouble());*/
        cardService.withdrawMoney(getCard(true,1d), 2d);
    }

    @Test
    public void testInsufficientFunds() {
        doNothing().when(validationService).validateTrackData(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doThrow(new AccountException(ResponseEnum.INSUFFICIENT_FUNDS)).when(accountService).withdrawMoney(any(Card.class), anyDouble(), anyDouble());
        try {
            cardService.withdrawMoney(getCard(true,1d), 2d);
        } catch (AccountException e) {
            Assert.assertEquals(e.getResponseEnum(), ResponseEnum.INSUFFICIENT_FUNDS);
        }
    }

    @Test(expected = ValidationException.class)
    public void testInvalidPin() {
        doNothing().when(validationService).validateTrackData(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doThrow(new ValidationException(ResponseEnum.INVALID_PIN)).when(pinService).validatePin(anyString(),anyString());
        cardService.withdrawMoney(getCard(true,1d), 2d);
    }

    @Test
    public void testBankCharge() {
        doNothing().when(validationService).validateTrackData(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        ArgumentCaptor<Card> argument = ArgumentCaptor.forClass(Card.class);
        Card card = getCard(true,1d);
        cardService.withdrawMoney(card, 2d);
        verify(accountService).withdrawMoney(argument.capture(), anyDouble(), anyDouble());
        Assert.assertEquals(argument.getValue().getTrack2(), card.getTrack2());
    }

    private void resetAll() {
        reset(validationService);
        reset(pinService);
        reset(accountService);
    }

    private Card getCard(boolean validCardNumber, double balanceAvailable) {
        String cardNumber = "4929900481403641";
        if (!validCardNumber) {
            cardNumber = "4929900481403642";
        }
        String track2 = cardNumber + "1703101";
        String pinBlock = "FF" + cardNumber;
        return new Card(track2,pinBlock, balanceAvailable);
    }
}