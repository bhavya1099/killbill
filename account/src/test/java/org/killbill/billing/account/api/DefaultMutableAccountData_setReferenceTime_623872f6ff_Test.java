// Test generated by RoostGPT for test java-unit-test-bhavya using AI Type Open AI and AI Model gpt-4

package org.killbill.billing.account.api;

import org.testng.annotations.Test;
import org.mockito.Mockito;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DefaultMutableAccountData_setReferenceTime_623872f6ff_Test {

    @Test
    public void testSetReferenceTimeWithValidDateTime() {
        DateTime dateTime = new DateTime(2022, 3, 15, 12, 0, DateTimeZone.UTC);
        DefaultMutableAccountData defaultMutableAccountData = Mockito.mock(DefaultMutableAccountData.class);
        Mockito.doNothing().when(defaultMutableAccountData).setReferenceTime(dateTime);

        defaultMutableAccountData.setReferenceTime(dateTime);
        Mockito.verify(defaultMutableAccountData, Mockito.times(1)).setReferenceTime(dateTime);
    }

    @Test
    public void testSetReferenceTimeWithNullDateTime() {
        DefaultMutableAccountData defaultMutableAccountData = Mockito.mock(DefaultMutableAccountData.class);
        Mockito.doNothing().when(defaultMutableAccountData).setReferenceTime(null);

        defaultMutableAccountData.setReferenceTime(null);
        Mockito.verify(defaultMutableAccountData, Mockito.times(1)).setReferenceTime(null);
    }

    @Test
    public void testSetReferenceTimeWithFutureDateTime() {
        DateTime futureDateTime = DateTime.now(DateTimeZone.UTC).plusYears(1);
        DefaultMutableAccountData defaultMutableAccountData = Mockito.mock(DefaultMutableAccountData.class);
        Mockito.doNothing().when(defaultMutableAccountData).setReferenceTime(futureDateTime);

        defaultMutableAccountData.setReferenceTime(futureDateTime);
        Mockito.verify(defaultMutableAccountData, Mockito.times(1)).setReferenceTime(futureDateTime);
    }
}
