// Test generated by RoostGPT for test java-unit-test-bhavya using AI Type Open AI and AI Model gpt-4

package org.killbill.billing.account.api;

import org.testng.annotations.Test;
import org.mockito.Mockito;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class DefaultMutableAccountData_getAddress1_7b5560f816_Test {

    @Test
    public void testGetAddress1WhenAddressIsNotNull() {
        DefaultMutableAccountData defaultMutableAccountData = Mockito.mock(DefaultMutableAccountData.class);
        Mockito.when(defaultMutableAccountData.getAddress1()).thenReturn("123 Main St");

        String result = defaultMutableAccountData.getAddress1();

        assertEquals(result, "123 Main St");
    }

    @Test
    public void testGetAddress1WhenAddressIsNull() {
        DefaultMutableAccountData defaultMutableAccountData = Mockito.mock(DefaultMutableAccountData.class);
        Mockito.when(defaultMutableAccountData.getAddress1()).thenReturn(null);

        String result = defaultMutableAccountData.getAddress1();

        assertNull(result);
    }
}
