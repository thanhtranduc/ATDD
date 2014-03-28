package com.qsoft.atdd.fake.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anhnt on 3/28/14.
 */
public class CustomerDTO
{
    @SerializedName("CUSTOMERS")
    List<AccountDTO> accountDTOList;

    public List<AccountDTO> getAccountDTOList()
    {
        return accountDTOList;
    }

    public void setAccountDTOList(List<AccountDTO> accountDTOList)
    {
        this.accountDTOList = accountDTOList;
    }
}
