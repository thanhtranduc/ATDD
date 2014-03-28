package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.googlecode.androidannotations.annotations.*;
import com.qsoft.atdd.R;
import com.qsoft.atdd.common.helper.GenericDatabaseHelper;
import com.qsoft.atdd.common.helper.HolderSingletonFactory;
import com.qsoft.atdd.fake.dto.AccountDTO;
import com.qsoft.atdd.fake.dto.CustomerDTO;
import com.qsoft.atdd.fake.dto.OrderDTO;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.model.Account;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thinhdd on 3/28/14.
 */
@EActivity(R.layout.login)
public class MainActivity extends FragmentActivity
{
    @ViewById(R.id.login_etUserName)
    EditText etUserName;

    @ViewById(R.id.login_etPass)
    EditText etPass;

    private Account account;

    @Bean
    public HolderSingletonFactory holderSingletonFactory;

    @Bean
    AccountServiceImpl accountService;

    @Bean
    OrderServiceImpl orderService;

    Gson gsonParser = new Gson();

    @AfterViews
    void init()
    {
        GenericDatabaseHelper genericDatabaseHelper = new GenericDatabaseHelper(this);
        holderSingletonFactory.setGenericDatabaseHelper(genericDatabaseHelper);
        runSQL();
    }

    @Click(R.id.login_btLogin)
    void login()
    {
        if (StringUtils.isEmpty(etUserName.getText().toString()) || StringUtils.isEmpty(etPass.getText().toString()))
        {
            Toast.makeText(this, "You must input fill all field", Toast.LENGTH_SHORT).show();
        }
        else
        {
            try
            {
                account = accountService.findByUsernameAndPassword(etUserName.getText().toString(), etPass.getText().toString());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            if (account != null)
            {
                Intent intent = new Intent(this, ShowListOrderActivity_.class);
                intent.putExtra("USER_ID", account.getId());
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "User or pass incorrect", Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void runSQL()
    {
        try
        {
            String result = getJsonData();
            CustomerDTO customerDTO = gsonParser.fromJson(result, CustomerDTO.class);
            List<AccountDTO> accountDTOList = customerDTO.getAccountDTOList();

            List<Account> localAccountList = accountService.getAllUser();
            Map<Long, Account> localMap = new HashMap<Long, Account>();
            for (Account account : localAccountList)
            {
                localMap.put(account.getId(), account);
            }

            for (AccountDTO accountDTO : accountDTOList)
            {
                Account account = accountDTO.toAccount();
                Account accountCheck = localMap.get(account.getId());
                if (accountCheck == null)
                {
                    accountService.create(account);
                    List<OrderDTO> orderDTOList = accountDTO.getOrderDTOList();
                    for (OrderDTO orderDTO : orderDTOList)
                    {
                        orderService.create(orderDTO.toOrder(account.getId()));
                    }
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private String getJsonData()
    {
        AssetManager assetManager = getAssets();
        InputStream input;
        try
        {
            input = assetManager.open("json.txt");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            return new String(buffer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
