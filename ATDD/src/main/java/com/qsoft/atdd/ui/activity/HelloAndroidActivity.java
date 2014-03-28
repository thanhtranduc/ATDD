package com.qsoft.atdd.ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qsoft.atdd.R;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.model.Account;

import java.sql.SQLException;

@EActivity(R.layout.activity_main)
public class HelloAndroidActivity extends Activity
{
    @ViewById(R.id.etFileName)
    EditText etFileName;

    @Bean
    AccountServiceImpl accountService;

    @Bean
    OrderServiceImpl orderService;

    public void runSQL(View view)
    {
        Toast.makeText(getApplicationContext(), "Running sql", Toast.LENGTH_SHORT).show();
        try
        {
            accountService.create(new Account("anhnt", "123456"));
            accountService.create(new Account("thanhtd", "123456"));
            accountService.create(new Account("thinhdd", "123456"));
            accountService.create(new Account("khiemnt", "123456"));
            accountService.create(new Account("longdt", "123456"));

            etFileName.setText(accountService.findByUsernameAndPassword("anhnt", "123456").toString());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

