package com.qsoft.atdd.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qsoft.atdd.R;

/**
 * Created by thinhdd on 3/28/14.
 */
@EActivity(R.layout.list_goods)
public class ShowListOrderActivity extends FragmentActivity
{

    @Click(R.id.list_goods_btAdd)

    void addOrder()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddOrderFragment addOrderFragment = new AddOrderFragment_();
        addOrderFragment.show(fragmentManager,"abc");
    }



}
