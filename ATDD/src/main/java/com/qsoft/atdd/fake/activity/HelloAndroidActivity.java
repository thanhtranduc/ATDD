package com.qsoft.atdd.fake.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qsoft.atdd.R;
import com.qsoft.atdd.common.helper.GenericDatabaseHelper;
import com.qsoft.atdd.common.helper.HolderSingletonFactory;
import com.qsoft.atdd.fake.dto.AccountDTO;
import com.qsoft.atdd.fake.dto.CustomerDTO;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.activity.MainActivity_;
import com.qsoft.atdd.ui.model.Account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@EActivity(R.layout.activity_main)
public class HelloAndroidActivity extends Activity
{
    @ViewById(R.id.etFileName)
    EditText etFileName;

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
    }

    public void runSQL(View view)
    {
        Toast.makeText(getApplicationContext(), "Running sql", Toast.LENGTH_SHORT).show();
        String result = getJsonData();
        CustomerDTO customerDTO = gsonParser.fromJson(result, CustomerDTO.class);
        List<AccountDTO> accountDTOList = customerDTO.getAccountDTOList();
        
        try
        {
            etFileName.setText(accountService.findByUsernameAndPassword("anhnt", "123456").getUserName());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        startActivity(new Intent(this, MainActivity_.class));
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

