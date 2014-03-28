package com.qsoft.atdd.fake.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: thanhtd
 * Date: 3/6/14
 * Time: 4:18 PM
 */
public class OrderDTO
{
    @SerializedName("orderCode")
    String orderCode;
    @SerializedName("amount")
    String amount;
    @SerializedName("description")
    String description;

    public String getOrderCode()
    {
        return orderCode;
    }

    public void setOrderCode(String orderCode)
    {
        this.orderCode = orderCode;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
