package za.co.entelect.dojo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.entelect.dojo.domain.Card;
import za.co.entelect.dojo.exceptions.AccountException;

import static org.mockito.Mockito.reset;

/**
 * Exercise 3: Use mockito to the test the defined test cases.
 *
 * Syntax examples:
 *
 *  create mock
 *  @Mock
 *  private Service serviceMock
 *
 *  Inject mock
 *  @InjectMocks
 *  private Service service
 *
 *  Mocking behavior
 *
 *  when(mock.methodName(anyString())).thenReturn(true);
 *  doNothing().when(mock).methodName(anyString(), eq(someValue));
 *  doThrow(new Exception()).when(mock).methodName(any(Card.class), anyLong(), anyLong());
 *
 *  Verify Behavior:
 *
 *  verify(mock).methodName(any(Clazz.class));
 *
 *  Argument Captor:
 *
 *  ArgumentCaptor<Object> argument = ArgumentCaptor.forClass(Class.class);
 *  verify(mock).methodName(argument.capture());
 */
@RunWith(MockitoJUnitRunner.class)
public class CardServiceImplTest {

    //add mocks here
    @Mock
    private AccountService accountService;

    //We have to provide a new instance because CardService is an interface.
    //If CardService was not an interface, Mockito would do the instantiation on our behalf
    @InjectMocks
    private CardService cardService = new CardServiceImpl();

    @Test
    public void testInsufficientFunds() {
        /**
         * This test should assert a certain exception to be thrown with
         * the correct value where the exception has a value you gave with the mock
         */

        try {

        } catch (AccountException e) {

        }
    }

    @Test
    public void testInvalidPin() {
        //merely expect a certain exception
    }

    @Test
    public void testWithdrawMoneySuccess() {
        // void methods in services to do NOTHING
        // verify that the services where called
    }

    @Test
    public void testBankCharge() {
        /**
         * Using ArgumentCaptor, verify that the card data sent to the account service was the card data generated by us here.
         */
    }

    private Card getCard(boolean validCardNumber, long balanceAvailableInCents) {
        String cardNumber = "4929900481403641";
        if (!validCardNumber) {
            cardNumber = "492990048140";
        }
        String cardData = cardNumber + "1703101";
        String pinBlock = "FF" + cardNumber;
        return new Card(cardData,pinBlock, balanceAvailableInCents);
    }
}