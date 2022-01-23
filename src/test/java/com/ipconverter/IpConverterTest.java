package com.ipconverter;

import com.ipconverter.exception.InvalidIpException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IpConverterTest {

    @Test
    void testValidIpInput() throws InvalidIpException {
        long ip1 = 2149583361L;
        long ip2 = 938046435L;
        long ip3 = 32L;
        long ip4 = 0L;

        assertEquals("128.32.10.1", IpConverter.convertLongToIP(ip1));
        assertEquals("55.233.115.227", IpConverter.convertLongToIP(ip2));
        assertEquals("0.0.0.32", IpConverter.convertLongToIP(ip3));
        assertEquals("0.0.0.0", IpConverter.convertLongToIP(ip4));
    }

    @Test
    void testInvalidIpInput() {
        long ip1 = -32L;
        long ip2 = 5000000000L;

        assertThrows(InvalidIpException.class, () -> {
            IpConverter.convertLongToIP(ip1);
        });

        assertThrows(InvalidIpException.class, () -> {
            IpConverter.convertLongToIP(ip2);
        });
    }
}
