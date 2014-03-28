package com.qsoft.atdd.ui.dto;

/**
 * User: khiemnt
 * Date: 3/28/14
 * Time: 4:17 PM
 */
public class OrderDTO
{
    private String orderCode;
    private double amount;
    private String description;

    //CONSTRUCTOR
    public OrderDTO()
    {
    }

    public OrderDTO(String orderCode, double amount, String description)
    {
        this.orderCode = orderCode;
        this.amount = amount;
        this.description = description;
    }
    //SETTER && GETTER

    public String getOrderCode()
    {
        return orderCode;
    }

    public void setOrderCode(String orderCode)
    {
        this.orderCode = orderCode;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
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
