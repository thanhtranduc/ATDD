package com.qsoft.atdd.fake.dto;

import com.google.gson.annotations.SerializedName;
import com.qsoft.atdd.ui.model.Account;

import java.util.List;

/**
 * User: thanhtd
 * Date: 3/6/14
 * Time: 4:18 PM
 */
public class AccountDTO
{
    @SerializedName("id")
    Long id;
    @SerializedName("displayName")
    String displayName;
    @SerializedName("userName")
    String userName;
    @SerializedName("password")
    String password;
    @SerializedName("order_list")
    List<OrderDTO> orderDTOList;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<OrderDTO> getOrderDTOList()
    {
        return orderDTOList;
    }

    public void setOrderDTOList(List<OrderDTO> orderDTOList)
    {
        this.orderDTOList = orderDTOList;
    }

    public Account toAccount(){
        return new Account(displayName, userName, password);
    }
}
