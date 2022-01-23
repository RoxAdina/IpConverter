package com.ipconverter;

import com.ipconverter.exception.InvalidIpException;

public class IpConverter {

    private static final int IDENTITY_ELEMENT = 0xff;
    private static final long UINT_MIN_VALUE = 0;
    private static final long UINT_MAX_VALUE = 4294967295L;
    private static final String INVALID_IP_ERROR_MESSAGE = "The IP number is invalid.";

    public static String convertLongToIP(long longIp) throws InvalidIpException {

        if (!isIpValid(longIp)) {
            throw new InvalidIpException(INVALID_IP_ERROR_MESSAGE);
        }
        long oct1 = longIp >>> 24 & IDENTITY_ELEMENT;
        long oct2 = longIp >>> 16 & IDENTITY_ELEMENT;
        long oct3 = longIp >>> 8 & IDENTITY_ELEMENT;
        long oct4 = longIp & IDENTITY_ELEMENT;

        return String.format("%d.%d.%d.%d", oct1, oct2, oct3, oct4);
    }

    private static boolean isIpValid(long ip) {
        return ip >= UINT_MIN_VALUE && ip <= UINT_MAX_VALUE;
    }
}
