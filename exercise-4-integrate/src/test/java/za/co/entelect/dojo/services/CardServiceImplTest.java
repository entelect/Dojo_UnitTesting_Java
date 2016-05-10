package za.co.entelect.dojo.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.entelect.dojo.Card;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

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
        doNothing().when(validationService).validateTrackData(anyString());
        doNothing().when(pinService).validatePin(anyString(), anyString());
        doNothing().when(accountService).withdrawMoney(any(Card.class), any(double.class), any(double.class));
        cardService.withdrawMoney(new Card("01234567891234567", "moo", 1d), 2d);
    }

    private void resetAll() {
        reset(validationService);
        reset(pinService);
        reset(accountService);
    }
}