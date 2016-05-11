package za.co.entelect.dojo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = IntegrationTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CardIntegrationTest {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PinService pinService;

    @Autowired
    private AccountService accountService;

    @Test
    public void testInsufficientFunds() {

    }
}
