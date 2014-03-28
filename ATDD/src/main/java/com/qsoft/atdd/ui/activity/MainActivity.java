package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qsoft.atdd.R;
import com.qsoft.atdd.common.helper.HolderSingletonFactory;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.ui.model.Account;
import com.sun.corba.se.impl.oa.toa.TOA;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

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
    AccountServiceImpl accountService;

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
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "User or pass incorrect", Toast.LENGTH_SHORT).show();

            }
        }
    }

}
