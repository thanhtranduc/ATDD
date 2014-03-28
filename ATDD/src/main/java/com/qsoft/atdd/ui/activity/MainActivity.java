package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qsoft.atdd.R;

/**
 * Created by thinhdd on 3/28/14.
 */
@EActivity(R.layout.login)
public class MainActivity extends FragmentActivity
{
    @Click(R.id.login_btLogin)
    void login()
    {
        Intent intent = new Intent(this,ShowListOrderActivity_.class);
        startActivity(intent);
    }

}
