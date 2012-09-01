/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartpaymentformat.utilities;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author petrdvorak
 */
public class SmartPaymentValidatorTest {
    
    public SmartPaymentValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validatePaymentString method, of class SmartPaymentValidator.
     */
    @Test
    public void testValidatePaymentStringBasic() {
        System.out.println("validatePaymentString");
        String paymentString = "PAY*1.0*232131";
        List result = SmartPaymentValidator.validatePaymentString(paymentString);
        // 1 error is expected
        assertEquals(result.size(), 1);
    }
    
    /**
     * Test of validatePaymentString method, of class SmartPaymentValidator.
     */
    @Test
    public void testValidatePaymentStringSimpleCorrect() {
        System.out.println("validatePaymentString");
        String paymentString = "PAY*1.0*ACC:CZ3155000000001043006511";
        List<SmartPaymentValidationError> result = SmartPaymentValidator.validatePaymentString(paymentString);
        // 0 error is expected
        if (result != null && result.size() > 0) {
            System.out.println(result.get(0).getErrorDescription());
        }
        assertNull(result);
    }
    
}
