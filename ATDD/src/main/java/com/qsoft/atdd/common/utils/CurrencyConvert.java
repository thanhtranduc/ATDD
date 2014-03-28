package com.qsoft.atdd.common.utils;

import java.text.DecimalFormat;

/**
 * User: khiemnt
 * Date: 3/28/14
 * Time: 8:33 PM
 */
public class CurrencyConvert
{
    public static String formatNumberForMoney(String numberStr)
    {
        DecimalFormat format = new DecimalFormat("#,##0.00");
        double numberInput = Double.parseDouble(numberStr);
        return format.format(numberInput);
    }
}
